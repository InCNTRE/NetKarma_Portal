/*
#
# Copyright 2009 The Trustees of Indiana University
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or areed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project:  Karma Provenance Service
# File:  OPMGraphUtil.java
# Description:  Supports retrieval of provenance data from the database
# and building of provenance graph.
#
#
# -----------------------------------------------------------------
# 
 */

/*
 * Author : Girish Subramanian (subramag@umail.iu.edu)
 * Modified: You-Wei Cheah (yocheah@indiana.edu)
 */

package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma.query._2010._10.DetailEnumType;
import org.openprovenance.model.v1_1_a.Agent;
import org.openprovenance.model.v1_1_a.AgentRef;
import org.openprovenance.model.v1_1_a.Agents;
import org.openprovenance.model.v1_1_a.Artifact;
import org.openprovenance.model.v1_1_a.ArtifactRef;
import org.openprovenance.model.v1_1_a.Artifacts;
import org.openprovenance.model.v1_1_a.CausalDependencies;
import org.openprovenance.model.v1_1_a.EmbeddedAnnotation;
import org.openprovenance.model.v1_1_a.OPMGraph;
import org.openprovenance.model.v1_1_a.OTime;
import org.openprovenance.model.v1_1_a.OpmGraphDocument;
import org.openprovenance.model.v1_1_a.Process;
import org.openprovenance.model.v1_1_a.ProcessRef;
import org.openprovenance.model.v1_1_a.Processes;
import org.openprovenance.model.v1_1_a.Property;
import org.openprovenance.model.v1_1_a.Role;
import org.openprovenance.model.v1_1_a.Used;
import org.openprovenance.model.v1_1_a.WasControlledBy;
import org.openprovenance.model.v1_1_a.WasDerivedFrom;
import org.openprovenance.model.v1_1_a.WasGeneratedBy;
import org.openprovenance.model.v1_1_a.WasTriggeredBy;

import edu.indiana.dsi.karma.ingest.EntityObject.EntityCategoryEnum;
import edu.indiana.dsi.karma.query.common.Common;

/* This class helps in exporting the provenance data as OPM graph */
public class QueryByWorkflowURIUtil {

	public static final Log l = LogFactory.getLog(QueryByWorkflowURIUtil.class);

	// for use with cache table
	private static final String NEW_CACHE_GRAPH = "INSERT INTO cache_workflow_graph (graph_context_wf_uri, graph_content, generation_time, query_date, detailed) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_CACHE_GRAPH = "UPDATE cache_workflow_graph SET graph_content = ? , dirty = ? , generation_time = ? , query_date = ? WHERE graph_id = ?";
	private static final String GET_CACHE_WF_GRAPH = "SELECT * FROM cache_workflow_graph WHERE graph_context_wf_uri = ? and detailed = ?";
	private static final String GET_CACHE_COUNT = "SELECT count(*) FROM cache_workflow_graph";
	private static final String UPDATE_QUERY_DATE = "UPDATE cache_workflow_graph SET query_date = ? WHERE graph_id = ?";
	private static final String GET_GRAPH_TO_DELETE = "(SELECT * FROM cache_workflow_graph ORDER BY query_date ASC) ORDER BY generation_time ASC limit 1";
	private static final int MAX_CACHE_ENTRIES = 10000;
	HashMap<String, String> visitedRegEntity = new HashMap<String, String>();

	/*
	 * This function gets all the OPM process for a given instance id
	 * 
	 * @param - connection : The database connection handle - contextWorkflowURI
	 * : The instance of the workflow run
	 * 
	 * @return - Processes : All the OPM processes for the given instance.
	 */
	public Processes getOPMProcesses(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {

		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMProcesses()");

		PreparedStatement getOPMProcessesStmt = null;
		PreparedStatement getOPMRegProcessesStmt = null;
		ResultSet result = null;
		ResultSet regProcessResult = null;

		try {
			getOPMProcessesStmt = connection
					.prepareStatement(OPMSqlQuery.GET_ENTITIES_BY_CONTEXT_WORKFLOW_URI);
			getOPMProcessesStmt.setString(1, contextWorkflowURI);
			getOPMProcessesStmt.setString(2, contextWorkflowURI);
			Processes processes = Processes.Factory.newInstance();
			/*
			 * In karma entity id is composed of
			 * {workflowID,serviceID,methodID,timestep,workflowNodeID}. All
			 * these information are stored as the value field of each Process.
			 * Unique IDs are assigned for each process in the loop. AccountID
			 * corresponds to the instance. ProcessID and the entity id are kept
			 * same for simplifying the Used and WasGeneratedBy relation
			 */
			String userID = null;
			String workflowID = null;
			String serviceID = null;
			String methodID = null;
			int timestep = -1;
			String workflowNodeID = null;
			String processID = null;
			String entityType = null;
			int instanceOfID = 0;

			result = getOPMProcessesStmt.executeQuery();
			while (result.next()) {
				userID = workflowID = serviceID = methodID = workflowNodeID = processID = entityType = null;
				timestep = -1;
				entityType = result.getString("entity_type");
				instanceOfID = result.getInt("instance_of");

				/* create the process ID */
				processID = Common.PROCESS_IDENTIFIER
						+ result.getInt("entity_id");

				/* Add the new Process in the Processes list and set the fields */
				Process process = processes.addNewProcess();
				process.setId(processID);

				try {
					if (informationDetailLevel != null
							&& informationDetailLevel
									.equals(DetailEnumType.FINE)) {

						EmbeddedAnnotation embeddedAnnotation = process
								.addNewAnnotation();
						Property entityTypeProperty = embeddedAnnotation
								.addNewProperty();
						entityTypeProperty.addNewValue().set(
								XmlObject.Factory.parse("<type>" + entityType
										+ "</type>"));
						entityTypeProperty.setUri("process-type");

						/* User Entity */
						if (entityType.equals(EntityCategoryEnum.USER
								.toString())) {
							userID = result.getString("entity_uri");

							Property userIDProperty = embeddedAnnotation
									.addNewProperty();
							userIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<userID>" + userID
											+ "</userID>"));
							userIDProperty.setUri("process-userID");

						} else if (entityType
								.equals(EntityCategoryEnum.WORKFLOW.toString())) {
							workflowID = result.getString("entity_uri");

							Property workflowIDProperty = embeddedAnnotation
									.addNewProperty();
							workflowIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<workflowID>"
											+ workflowID + "</workflowID>"));
							workflowIDProperty.setUri("process-workflowID");

						} else if (entityType.equals(EntityCategoryEnum.SERVICE
								.toString())) {

							workflowID = result
									.getString("context_workflow_uri");
							serviceID = result.getString("entity_uri");
							workflowNodeID = result
									.getString("context_wf_node_id_token");
							timestep = result.getInt("timestep");

							Property workflowIDProperty = embeddedAnnotation
									.addNewProperty();
							workflowIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<workflowID>"
											+ workflowID + "</workflowID>"));
							workflowIDProperty.setUri("process-workflowID");

							Property serviceIDProperty = embeddedAnnotation
									.addNewProperty();
							serviceIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<serviceID>"
											+ serviceID + "</serviceID>"));
							serviceIDProperty.setUri("process-serviceID");

							Property timestepProperty = embeddedAnnotation
									.addNewProperty();
							timestepProperty.addNewValue().set(
									XmlObject.Factory.parse("<timestep>"
											+ timestep + "</timestep>"));
							timestepProperty.setUri("process-timestep");

							Property workflowNodeIDProperty = embeddedAnnotation
									.addNewProperty();
							workflowNodeIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<workflowNodeID>"
											+ workflowNodeID
											+ "</workflowNodeID>"));
							workflowNodeIDProperty
									.setUri("process-workflowNodeID");

						} else if (entityType.equals(EntityCategoryEnum.METHOD
								.toString())) {
							workflowID = result
									.getString("context_workflow_uri");
							serviceID = result.getString("context_service_uri");
							workflowNodeID = result
									.getString("context_wf_node_id_token");
							timestep = result.getInt("timestep");
							methodID = result.getString("entity_uri");

							Property workflowIDProperty = embeddedAnnotation
									.addNewProperty();
							workflowIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<workflowID>"
											+ workflowID + "</workflowID>"));
							workflowIDProperty.setUri("process-workflowID");

							Property serviceIDProperty = embeddedAnnotation
									.addNewProperty();
							serviceIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<serviceID>"
											+ serviceID + "</serviceID>"));
							serviceIDProperty.setUri("process-serviceID");

							Property methodIDProperty = embeddedAnnotation
									.addNewProperty();
							methodIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<methodID>"
											+ methodID + "</methodID>"));
							methodIDProperty.setUri("process-methodID");

							Property timestepProperty = embeddedAnnotation
									.addNewProperty();
							timestepProperty.addNewValue().set(
									XmlObject.Factory.parse("<timestep>"
											+ timestep + "</timestep>"));
							timestepProperty.setUri("process-timestep");

							Property workflowNodeIDProperty = embeddedAnnotation
									.addNewProperty();
							workflowNodeIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<workflowNodeID>"
											+ workflowNodeID
											+ "</workflowNodeID>"));
							workflowNodeIDProperty
									.setUri("process-workflowNodeID");
						}

						EmbeddedAnnotation entityAnnotation = getExeEntityAnnotation(
								connection, contextWorkflowURI,
								result.getString("entity_id"));
						if (entityAnnotation != null) {
							process.addNewAnnotation();
							process.setAnnotationArray(
									process.getAnnotationArray().length - 1,
									entityAnnotation);
						}
					}
				} catch (XmlException e) {
					l.error("Error while setting the annotation value of the exe_process.");
					l.error(e.toString());
				}

				if (instanceOfID > 0) {
					if (visitedRegEntity.get(Common.REG_PROCESS_IDENTIFIER
							+ instanceOfID) == null) {

						visitedRegEntity.put(Common.REG_PROCESS_IDENTIFIER
								+ instanceOfID, Common.REG_PROCESS_IDENTIFIER
								+ instanceOfID);

						getOPMRegProcessesStmt = connection
								.prepareStatement(OPMSqlQuery.GET_REG_ENTITIES_BY_ID);
						getOPMRegProcessesStmt.setString(1, instanceOfID + "");

						regProcessResult = getOPMRegProcessesStmt
								.executeQuery();
						while (regProcessResult.next()) {

							/* create the process ID */
							processID = Common.REG_PROCESS_IDENTIFIER
									+ instanceOfID;

							/*
							 * Add the new Process in the Processes list and set
							 * the fields
							 */
							Process regProcess = processes.addNewProcess();
							regProcess.setId(processID);

							String regEntityType = regProcessResult
									.getString("entity_type");
							String regEntityName = regProcessResult
									.getString("name");
							String regEntityVersion = regProcessResult
									.getString("version");
							String regEntityCreationTime = regProcessResult
									.getString("creation_time");

							if (informationDetailLevel != null
									&& informationDetailLevel
											.equals(DetailEnumType.FINE)) {

								try {
									EmbeddedAnnotation embeddedAnnotation = regProcess
											.addNewAnnotation();
									Property entityTypeProperty = embeddedAnnotation
											.addNewProperty();
									entityTypeProperty.addNewValue().set(
											XmlObject.Factory
													.parse("<type>"
															+ regEntityType
															+ "</type>"));
									entityTypeProperty.setUri("process-type");

									Property entityNameProperty = embeddedAnnotation
											.addNewProperty();
									entityNameProperty.addNewValue().set(
											XmlObject.Factory
													.parse("<name>"
															+ regEntityName
															+ "</name>"));
									entityNameProperty.setUri("process-name");

									Property entityVersionProperty = embeddedAnnotation
											.addNewProperty();
									entityVersionProperty.addNewValue().set(
											XmlObject.Factory.parse("<version>"
													+ regEntityVersion
													+ "</version>"));
									entityVersionProperty
											.setUri("process-version");

									Property entityCreationTimeProperty = embeddedAnnotation
											.addNewProperty();
									entityCreationTimeProperty
											.addNewValue()
											.set(XmlObject.Factory
													.parse("<creationTime>"
															+ regEntityCreationTime
															+ "</creationTime>"));
									entityCreationTimeProperty
											.setUri("process-creation-time");

									EmbeddedAnnotation regEntityAnnotation = getRegEntityAnnotation(
											connection, contextWorkflowURI,
											String.valueOf(instanceOfID));
									if (regEntityAnnotation != null) {
										process.addNewAnnotation();
										process.setAnnotationArray(
												process.getAnnotationArray().length - 1,
												regEntityAnnotation);
									}

								} catch (XmlException e) {
									l.error("Error while setting the annotation value of the reg_process.");
									l.error(e.toString());
								}
							}
						}
					}
				}
			}

			l.info(processes);
			l.info("Exiting getOPMProcesses");

			return processes;

		} catch (SQLException e) {
			l.error("Exiting getOPMProcesses() with errors");
			l.error(e.toString());
			return null;

		} finally {
			if (result != null) {
				result.close();
				result = null;
			}

			if (regProcessResult != null) {
				regProcessResult.close();
				regProcessResult = null;
			}

			if (getOPMProcessesStmt != null) {
				getOPMProcessesStmt.close();
				getOPMProcessesStmt = null;
			}

			if (getOPMRegProcessesStmt != null) {
				getOPMRegProcessesStmt.close();
				getOPMRegProcessesStmt = null;
			}
		}
	}

	/*
	 * This function gets all the OPM artifacts for a given instance id
	 * 
	 * @param - connection : The database connection handle - contextWorkflowURI
	 * : The instance of the workflow run
	 * 
	 * @return - Artifacts : All the OPM artifacts for the given instance.
	 */
	public Artifacts getOPMArtifacts(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMArtifacts()");
		/*
		 * There may be some data products that may be both produced and
		 * consumed hence storing them in a HashMap. Store corresponding event
		 * ids in a sepaate HashMap for simplicity.
		 */
		Map<String, String> artifacts = new HashMap<String, String>();
		Map<String, String> uris = new HashMap<String, String>();

		PreparedStatement getDataObjectStmt = null;
		ResultSet res = null;

		/* get all the data produced in this instance */
		try {

			/* get all the files that were produced */
			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_FILES_PRODUCED);
			getDataObjectStmt.setString(1, contextWorkflowURI);

			res = getDataObjectStmt.executeQuery();
			while (res.next()) {
				String fileURI = res.getString(1);
				String size = res.getString(2);
				String fileID = res.getString(3);

				artifacts.put(Common.FILE_IDENTIFIER + fileID, size);
				uris.put(Common.FILE_IDENTIFIER + fileID, fileURI);
			}

			res.close();
			getDataObjectStmt.close();

			/* get all the blocks that were produced */
			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_BLOCKS_PRODUCED);
			getDataObjectStmt.setString(1, contextWorkflowURI);

			res = getDataObjectStmt.executeQuery();
			while (res.next()) {
				String blockID = res.getString(1);
				String blockSize = res.getString(2);
				String blockContent = res.getString(3);

				artifacts.put(Common.BLOCK_IDENTIFIER + blockID, blockSize);
				/* Store content of blocks in the same HashMap */
				artifacts.put("BlockContent_" + blockID, blockContent);
				uris.put(Common.BLOCK_IDENTIFIER + blockID, blockID);
			}

			res.close();
			getDataObjectStmt.close();

			/* TODO: get all the collections that were produced */

			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_COLLECTIONS_PRODUCED);
			getDataObjectStmt.setString(1, contextWorkflowURI);

			res = getDataObjectStmt.executeQuery();
			while (res.next()) {
				String collectionID = res.getString(1);
				String collectionURI = res.getString(2);

				artifacts
						.put(Common.COLLECTION_IDENTIFIER + collectionID, null);
				uris.put(Common.COLLECTION_IDENTIFIER + collectionID,
						collectionURI);
			}

			res.close();
			getDataObjectStmt.close();

			/* get all the files that were consumed */
			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_FILES_CONSUMED);
			getDataObjectStmt.setString(1, contextWorkflowURI);
			res = getDataObjectStmt.executeQuery();

			while (res.next()) {
				String fileURI = res.getString(1);
				String size = res.getString(2);
				String fileID = res.getString(3);

				artifacts.put(Common.FILE_IDENTIFIER + fileID, size);
				uris.put(Common.FILE_IDENTIFIER + fileID, fileURI);
			}
			res.close();
			getDataObjectStmt.close();

			/* get all the blocks that were consumed */
			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_BLOCKS_CONSUMED);
			getDataObjectStmt.setString(1, contextWorkflowURI);
			res = getDataObjectStmt.executeQuery();

			while (res.next()) {
				String blockID = res.getString(1);
				String blockSize = res.getString(2);
				String blockContent = res.getString(3);

				artifacts.put(Common.BLOCK_IDENTIFIER + blockID, blockSize);
				/* Store content of blocks in the same HashMap */
				artifacts.put("BlockContent_" + blockID, blockContent);
				uris.put(Common.BLOCK_IDENTIFIER + blockID, blockID);
			}
			res.close();
			getDataObjectStmt.close();

			/* TODO: get all the collections that were consumed */

			getDataObjectStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_COLLECTIONS_CONSUMED);
			getDataObjectStmt.setString(1, contextWorkflowURI);

			res = getDataObjectStmt.executeQuery();
			while (res.next()) {
				String collectionID = res.getString(1);
				String collectionURI = res.getString(2);
				artifacts
						.put(Common.COLLECTION_IDENTIFIER + collectionID, null);
				uris.put(Common.COLLECTION_IDENTIFIER + collectionID,
						collectionURI);

			}

			res.close();
			getDataObjectStmt.close();

			Artifacts opmartifacts = Artifacts.Factory.newInstance();

			Set<String> artifactIdSet = artifacts.keySet();

			/* build the XML tree */
			for (String artifactId : artifactIdSet) {
				if (artifactId.startsWith("BlockContent_")) {
					continue;
				} else {

					String size = artifacts.get(artifactId);
					String dataObjectURI = uris.get(artifactId);
					Artifact opmArtifact = opmartifacts.addNewArtifact();

					opmArtifact.setId(artifactId);

					if (informationDetailLevel != null
							&& informationDetailLevel
									.equals(DetailEnumType.FINE)) {
						if (size != null) {

							try {
								EmbeddedAnnotation embeddedAnnotation = opmArtifact
										.addNewAnnotation();
								Property newProperty = embeddedAnnotation
										.addNewProperty();

								newProperty.addNewValue().set(
										XmlObject.Factory.parse("<size>" + size
												+ "</size>"));

								newProperty.setUri("artifact-size");

							} catch (XmlException e) {
								l.error("Set size annotation error.");
								l.error(e.toString());
							}
						}

						if (artifactId.startsWith(Common.BLOCK_IDENTIFIER)) {
							String content = artifacts.get("BlockContent_"
									+ artifactId.replace(
											Common.BLOCK_IDENTIFIER, ""));

							if (content != null) {
								try {
									Property newProperty;
									if (opmArtifact.getAnnotationArray().length == 0) {
										EmbeddedAnnotation embeddedAnnotation = opmArtifact
												.addNewAnnotation();
										newProperty = embeddedAnnotation
												.addNewProperty();
									} else {
										newProperty = opmArtifact
												.getAnnotationArray(0)
												.addNewProperty();
									}
									newProperty.addNewValue().set(
											XmlObject.Factory.parse("<content>"
													+ content + "</content>"));
									newProperty.setUri("artifact-content");

								} catch (XmlException e) {
									l.error("Set content annotation error.");
									l.error(e.toString());
								}
							}
						} else if (artifactId
								.startsWith(Common.FILE_IDENTIFIER)) {
							try {
								Property newProperty;
								if (opmArtifact.getAnnotationArray().length == 0) {
									EmbeddedAnnotation embeddedAnnotation = opmArtifact
											.addNewAnnotation();
									newProperty = embeddedAnnotation
											.addNewProperty();
								} else {
									newProperty = opmArtifact
											.getAnnotationArray(0)
											.addNewProperty();
								}

								newProperty.addNewValue()
										.set(XmlObject.Factory
												.parse("<fileURI>"
														+ dataObjectURI
														+ "</fileURI>"));

								newProperty.setUri("artifact-uri");
							} catch (XmlException e) {
								l.error("Set uri annotation error.");
								l.error(e.toString());
							}
						}

						String[] split = artifactId.split("_");

						EmbeddedAnnotation entityAnnotation = getDataObjectAnnotation(
								connection, contextWorkflowURI, split[1]);
						if (entityAnnotation != null) {
							opmArtifact.addNewAnnotation();
							opmArtifact
									.setAnnotationArray(
											opmArtifact.getAnnotationArray().length - 1,
											entityAnnotation);
						}

					}
				}
			}

			l.info(opmartifacts);
			l.info("Exiting getOPMArtifacts() with success");
			return opmartifacts;

		} catch (SQLException e) {
			l.error("Exiting getOPMArtifacts() with errors");
			l.error(e.toString());
			return null;
		} finally {

			if (getDataObjectStmt != null) {
				getDataObjectStmt.close();
				getDataObjectStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function gets all the OPM agents for a given context workflow URI
	 * 
	 * @param - connection : The database connection handle - contextWorkflowURI
	 * : The instance of the workflow run
	 * 
	 * @return - Agents : All the OPM agents for the given instance.
	 */

	public Agents getOPMAgents(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {

		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMAgents()");

		PreparedStatement getOPMAgentsStmt = null;
		PreparedStatement getUserControllerStmt = null;
		PreparedStatement getRoleStmt = null;

		ResultSet result = null;
		ResultSet roleResultSet = null;

		try {

			Agents agents = Agents.Factory.newInstance();
			Vector<String> invokerIDs = new Vector<String>();

			getOPMAgentsStmt = connection
					.prepareStatement(OPMSqlQuery.GET_USER_INVOCATION_BY_ENTITY_URI);
			getOPMAgentsStmt.setString(1, contextWorkflowURI);
			getOPMAgentsStmt.setString(2, contextWorkflowURI);

			result = getOPMAgentsStmt.executeQuery();

			if (result.next()) {
				String invokerID = result.getString("invoker_id");
				invokerIDs.add(invokerID);
			}

			result.close();
			getOPMAgentsStmt.close();

			getOPMAgentsStmt = connection
					.prepareStatement(OPMSqlQuery.GET_USER_BEHALF_AGENT_BY_ENTITY_URI);
			getOPMAgentsStmt.setString(1, contextWorkflowURI);

			result = getOPMAgentsStmt.executeQuery();

			if (result.next()) {
				String invokerID = result.getString("user_id");
				invokerIDs.add(invokerID);
			}

			result.close();
			getOPMAgentsStmt.close();

			if (invokerIDs.size() > 0) {
				for (String invokerID : invokerIDs) {

					Agent opmAgent = agents.addNewAgent();
					opmAgent.setId(Common.AGENT_IDENTIFIER + invokerID);

					getUserControllerStmt = connection
							.prepareStatement(OPMSqlQuery.GET_USER_CONTROLLER_BY_ID);
					getUserControllerStmt.setString(1, invokerID);
					result = getUserControllerStmt.executeQuery();

					if (informationDetailLevel != null
							&& informationDetailLevel
									.equals(DetailEnumType.FINE)) {
						if (result.next()) {

							String dn = result.getString("dn");
							String name = result.getString("name");
							String affiliation = result
									.getString("affiliation");
							String email = result.getString("email");

							if (dn != null) {

								Property property;

								if (opmAgent.getAnnotationArray().length == 0) {
									EmbeddedAnnotation embeddedAnnotation = opmAgent
											.addNewAnnotation();
									property = embeddedAnnotation
											.addNewProperty();
								} else {
									property = opmAgent.getAnnotationArray(0)
											.addNewProperty();
								}
								try {
									property.addNewValue().set(
											XmlObject.Factory.parse("<dn>" + dn
													+ "</dn>"));
									property.setUri("agent-dn");

								} catch (XmlException e) {
									l.error("Set agent dn error.");
									l.error(e.toString());
								}
							}

							if (name != null) {

								Property property;

								if (opmAgent.getAnnotationArray().length == 0) {
									EmbeddedAnnotation embeddedAnnotation = opmAgent
											.addNewAnnotation();
									property = embeddedAnnotation
											.addNewProperty();
								} else {
									property = opmAgent.getAnnotationArray(0)
											.addNewProperty();
								}
								try {
									property.addNewValue().set(
											XmlObject.Factory.parse("<name>"
													+ name + "</name>"));
									property.setUri("agent-name");

								} catch (XmlException e) {
									l.error("Set agent name error.");
									l.error(e.toString());
								}
							}

							if (affiliation != null) {

								Property property;

								if (opmAgent.getAnnotationArray().length == 0) {
									EmbeddedAnnotation embeddedAnnotation = opmAgent
											.addNewAnnotation();
									property = embeddedAnnotation
											.addNewProperty();
								} else {
									property = opmAgent.getAnnotationArray(0)
											.addNewProperty();
								}
								try {
									property.addNewValue()
											.set(XmlObject.Factory
													.parse("<affiliation>"
															+ affiliation
															+ "</affiliation>"));
									property.setUri("agent-affiliation");

								} catch (XmlException e) {
									l.error("Set agent affiliation error.");
									l.error(e.toString());
								}
							}

							if (email != null) {

								Property property;

								if (opmAgent.getAnnotationArray().length == 0) {
									EmbeddedAnnotation embeddedAnnotation = opmAgent
											.addNewAnnotation();
									property = embeddedAnnotation
											.addNewProperty();
								} else {
									property = opmAgent.getAnnotationArray(0)
											.addNewProperty();
								}
								try {
									property.addNewValue().set(
											XmlObject.Factory.parse("<email>"
													+ email + "</email>"));
									property.setUri("agent-email");

								} catch (XmlException e) {
									l.error("Set agent email error.");
									l.error(e.toString());
								}
							}

							getRoleStmt = connection
									.prepareStatement(OPMSqlQuery.GET_AUTHORSHIP_BY_ENTITY_ID);
							getRoleStmt.setString(1, invokerID);
							roleResultSet = getRoleStmt.executeQuery();
							if (roleResultSet.next()) {
								String role = roleResultSet.getString("role");

								if (role != null) {

									Property property;

									if (opmAgent.getAnnotationArray().length == 0) {
										EmbeddedAnnotation embeddedAnnotation = opmAgent
												.addNewAnnotation();
										property = embeddedAnnotation
												.addNewProperty();
									} else {
										property = opmAgent.getAnnotationArray(
												0).addNewProperty();
									}
									try {
										property.addNewValue().set(
												XmlObject.Factory
														.parse("<role>" + role
																+ "</role>"));
										property.setUri("agent-role");
									} catch (XmlException e) {
										l.error("Set agent role error.");
										l.error(e.toString());
									}
								}
							}

							getRoleStmt.close();
							roleResultSet.close();
						}
					}

					result.close();
					getUserControllerStmt.close();

				}
			}

			l.info("Exiting getOPMAgents() with success");
			return agents;

		} catch (SQLException e) {
			l.error("Exiting getOPMAgents() with errors");
			l.error(e.toString());
			return null;
		} finally {

			if (getOPMAgentsStmt != null) {
				getOPMAgentsStmt.close();
				getOPMAgentsStmt = null;
			}

			if (getUserControllerStmt != null) {
				getUserControllerStmt.close();
				getUserControllerStmt = null;
			}

			if (getRoleStmt != null) {
				getRoleStmt.close();
				getRoleStmt = null;
			}

			if (result != null) {
				result.close();
				result = null;
			}

			if (roleResultSet != null) {
				roleResultSet.close();
				roleResultSet = null;
			}
		}

	}

	/* This function retrieves execution level entity annotations by entity id. */
	public EmbeddedAnnotation getExeEntityAnnotation(Connection connection,
			String contextWorkflowURI, String entityID) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		assert (entityID != null);
		l.info("Entering getEntityAnnotation()");

		PreparedStatement entityAnnotationStmt = null;
		ResultSet entityAnnotationResult = null;
		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			entityAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_EXE_ENTITY_ANNOTATIONS_BY_ID);
			entityAnnotationStmt.setString(1, entityID);

			entityAnnotationResult = entityAnnotationStmt.executeQuery();

			while (entityAnnotationResult.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("process-annotation/"
						+ entityAnnotationResult.getString(5) + "/"
						+ entityAnnotationResult.getString(3));
				property.setValue(XmlObject.Factory
						.parse(entityAnnotationResult.getString(4)));
				embeddedAnnotation.setId(Common.PROCESS_ANNOTATION_IDENTIFIER
						+ entityAnnotationResult.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			entityAnnotationStmt.close();
			entityAnnotationResult.close();
			l.info("Exiting getEntityAnnotation() with success");

			return embeddedAnnotation;
		} catch (SQLException e) {
			l.error("Exiting getEntityAnnotation() with error");
			l.error(e.toString());
			return null;
		} catch (XmlException e) {
			l.error("Exiting getEntityAnnotation() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (entityAnnotationStmt != null) {
				entityAnnotationStmt.close();
				entityAnnotationStmt = null;
			}

			if (entityAnnotationResult != null) {
				entityAnnotationResult.close();
				entityAnnotationResult = null;
			}
		}
	}

	/* This function retrieves registry level entity annotations by entity id. */
	public EmbeddedAnnotation getRegEntityAnnotation(Connection connection,
			String contextWorkflowURI, String entityID) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		assert (entityID != null);
		l.info("Entering getRegEntityAnnotation()");

		PreparedStatement entityAnnotationStmt = null;
		ResultSet entityAnnotationResult = null;

		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			entityAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_REG_ENTITY_ANNOTATIONS_BY_ID);
			entityAnnotationStmt.setString(1, entityID);

			entityAnnotationResult = entityAnnotationStmt.executeQuery();

			while (entityAnnotationResult.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("process-annotation/"
						+ entityAnnotationResult.getString(5) + "/"
						+ entityAnnotationResult.getString(3));
				property.setValue(XmlObject.Factory
						.parse(entityAnnotationResult.getString(4)));
				embeddedAnnotation.setId(Common.PROCESS_ANNOTATION_IDENTIFIER
						+ entityAnnotationResult.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			entityAnnotationStmt.close();
			entityAnnotationResult.close();
			l.info("Exiting getRegEntityAnnotation() with success");

			return embeddedAnnotation;
		} catch (SQLException e) {
			l.error("Exiting getRegEntityAnnotation() with error");
			l.error(e.toString());
			return null;
		} catch (XmlException e) {
			l.error("Exiting getRegEntityAnnotation() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (entityAnnotationStmt != null) {
				entityAnnotationStmt.close();
				entityAnnotationStmt = null;
			}

			if (entityAnnotationResult != null) {
				entityAnnotationResult.close();
				entityAnnotationResult = null;
			}
		}
	}

	/* This function retrieves data object annotations by data object id. */
	public EmbeddedAnnotation getDataObjectAnnotation(Connection connection,
			String contextWorkflowURI, String objectID) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		assert (objectID != null);
		l.info("Entering getDataObjectAnnotation()");

		PreparedStatement dataObjectAnnotationStmt = null;
		ResultSet dataObjectAnnotationResult = null;

		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			dataObjectAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_OBJECT_ANNOTATIONS_BY_ID);
			dataObjectAnnotationStmt.setString(1, objectID);

			dataObjectAnnotationResult = dataObjectAnnotationStmt
					.executeQuery();

			while (dataObjectAnnotationResult.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("artifact-annotation/"
						+ dataObjectAnnotationResult.getString(5) + "/"
						+ dataObjectAnnotationResult.getString(3));
				property.setValue(XmlObject.Factory
						.parse(dataObjectAnnotationResult.getString(4)));
				embeddedAnnotation.setId(Common.ARTIFACT_ANNOTATION_IDENTIFIER
						+ dataObjectAnnotationResult.getString(1));

			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			dataObjectAnnotationStmt.close();
			dataObjectAnnotationResult.close();
			l.info("Exiting getDataObjectAnnotation() with success");

			return embeddedAnnotation;
		} catch (SQLException e) {
			l.error("Exiting getDataObjectAnnotation() with error");
			l.error(e.toString());
			return null;
		} catch (XmlException e) {
			l.error("Exiting getDataObjectAnnotation() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (dataObjectAnnotationStmt != null) {
				dataObjectAnnotationStmt.close();
				dataObjectAnnotationStmt = null;
			}

			if (dataObjectAnnotationResult != null) {
				dataObjectAnnotationResult.close();
				dataObjectAnnotationResult = null;
			}
		}
	}

	/* This function retrieves invocation annotations by entity id. */
	public EmbeddedAnnotation getInvocationAnnotation(Connection connection,
			String contextWorkflowURI, String invocationID) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		assert (invocationID != null);
		l.info("Entering getInvocationAnnotation()");

		PreparedStatement invocationAnnotationStmt = null;
		ResultSet invocationAnnotationResult = null;
		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			invocationAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_INVOCATION_ANNOTATIONS_BY_ID);
			invocationAnnotationStmt.setString(1, invocationID);

			invocationAnnotationResult = invocationAnnotationStmt
					.executeQuery();

			while (invocationAnnotationResult.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("invocation-annotation/"
						+ invocationAnnotationResult.getString(5) + "/"
						+ invocationAnnotationResult.getString(3));
				property.setValue(XmlObject.Factory
						.parse(invocationAnnotationResult.getString(4)));
				embeddedAnnotation
						.setId(Common.INVOCATION_ANNOTATION_IDENTIFIER
								+ invocationAnnotationResult.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			invocationAnnotationStmt.close();
			invocationAnnotationStmt.close();
			l.info("Exiting getInvocationAnnotation() with success");

			return embeddedAnnotation;
		} catch (SQLException e) {
			l.error("Exiting getInvocationAnnotation() with error");
			l.error(e.toString());
			return null;
		} catch (XmlException e) {
			l.error("Exiting getInvocationAnnotation() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (invocationAnnotationStmt != null) {
				invocationAnnotationStmt.close();
				invocationAnnotationStmt = null;
			}

			if (invocationAnnotationResult != null) {
				invocationAnnotationResult.close();
				invocationAnnotationResult = null;
			}
		}
	}

	/* This function retrieves data lifecycle annotations by event id. */
	public EmbeddedAnnotation getDataLifecycleAnnotation(Connection connection,
			String contextWorkflowURI, String eventID) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		assert (eventID != null);
		l.info("Entering getDataLifecycleAnnotation()");

		PreparedStatement dataLifecycleAnnotationStmt = null;
		ResultSet dataLifecycleAnnotationResult = null;

		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			dataLifecycleAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_LIFECYCLE_ANNOTATIONS_BY_ID);
			dataLifecycleAnnotationStmt.setString(1, eventID);

			dataLifecycleAnnotationResult = dataLifecycleAnnotationStmt
					.executeQuery();

			while (dataLifecycleAnnotationResult.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("data-lifecycle-annotation/"
						+ dataLifecycleAnnotationResult.getString(5) + "/"
						+ dataLifecycleAnnotationResult.getString(3));
				property.setValue(XmlObject.Factory
						.parse(dataLifecycleAnnotationResult.getString(4)));
				embeddedAnnotation
						.setId(Common.DATA_LIFECYCLE_ANNOTATION_IDENTIFIER
								+ dataLifecycleAnnotationResult.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			dataLifecycleAnnotationStmt.close();
			dataLifecycleAnnotationResult.close();
			l.info("Exiting getDataLifecycleAnnotation() with success");

			return embeddedAnnotation;
		} catch (SQLException e) {
			l.error("Exiting getDataLifecycleAnnotation() with error");
			l.error(e.toString());
			return null;
		} catch (XmlException e) {
			l.error("Exiting getDataLifecycleAnnotation() with error");
			l.error(e.toString());
			return null;
		} finally {
			if (dataLifecycleAnnotationStmt != null) {
				dataLifecycleAnnotationStmt.close();
				dataLifecycleAnnotationStmt = null;
			}

			if (dataLifecycleAnnotationResult != null) {
				dataLifecycleAnnotationResult.close();
				dataLifecycleAnnotationResult = null;
			}
		}
	}

	/*
	 * This function returns all the nodes that are connected by Used causal
	 * dependency
	 */
	public List<Used> getOPMUsed(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMUsed()");

		PreparedStatement usedStmt = null;
		ResultSet resultSet = null;

		try {

			List<Used> usedList = new ArrayList<Used>();

			usedStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_FILE_USED);
			usedStmt.setString(1, contextWorkflowURI);

			resultSet = usedStmt.executeQuery();

			while (resultSet.next()) {
				String processID = Common.PROCESS_IDENTIFIER
						+ resultSet.getString(1);
				int dataObjectId = resultSet.getInt(2);
				String artifactID = Common.getArtifactId(connection,
						dataObjectId);
				java.sql.Timestamp usedTime = resultSet.getTimestamp(4);
				String role = resultSet.getString(6);

				Used used = Used.Factory.newInstance();
				ProcessRef effect = used.addNewEffect();
				effect.setRef(processID);
				ArtifactRef cause = used.addNewCause();
				cause.setRef(artifactID);

				OTime time = used.addNewTime();

				Calendar noEarlierThan = Common.getArtifactGeneratedTime(
						connection, dataObjectId);

				Calendar noLaterThan = Calendar.getInstance();
				noLaterThan.setTimeInMillis(usedTime.getTime());

				/*
				 * if noEarlierThan time is unavailable, we default to
				 * noLaterThan time
				 */
				if (noEarlierThan == null) {
					time.setNoEarlierThan(noLaterThan);
				} else {
					time.setNoEarlierThan(noEarlierThan);
				}
				time.setNoLaterThan(noLaterThan);

				if (role == null) {
					used.addNewRole().setValue("Input");
				} else {
					used.addNewRole().setValue(role);
				}

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation dataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI,
							resultSet.getString(5));
					if (dataLifecycleAnnotation != null) {
						used.addNewAnnotation();
						used.setAnnotationArray(0, dataLifecycleAnnotation);
					}
				}

				l.info(used);
				usedList.add(used);

			}
			resultSet.close();
			usedStmt.close();

			usedStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_BLOCK_USED);
			usedStmt.setString(1, contextWorkflowURI);
			resultSet = usedStmt.executeQuery();

			while (resultSet.next()) {
				String processID = Common.PROCESS_IDENTIFIER
						+ resultSet.getString(1);
				int dataObjectId = resultSet.getInt(2);
				String artifactID = resultSet.getString(3);
				java.sql.Timestamp usedTime = resultSet.getTimestamp(4);
				String role = resultSet.getString(6);

				Used used = Used.Factory.newInstance();
				ProcessRef effect = used.addNewEffect();
				effect.setRef(processID);
				ArtifactRef cause = used.addNewCause();
				cause.setRef(Common.BLOCK_IDENTIFIER + artifactID);

				OTime time = used.addNewTime();

				Calendar noEarlierThan = Common.getArtifactGeneratedTime(
						connection, dataObjectId);

				Calendar noLaterThan = Calendar.getInstance();
				noLaterThan.setTimeInMillis(usedTime.getTime());

				/*
				 * if noEarlierThan time is unavailable, we default to
				 * noLaterThan time
				 */
				if (noEarlierThan == null) {
					time.setNoEarlierThan(noLaterThan);
				} else {
					time.setNoEarlierThan(noEarlierThan);
				}
				time.setNoLaterThan(noLaterThan);

				if (role == null) {
					used.addNewRole().setValue("Input");
				} else {
					used.addNewRole().setValue(role);
				}

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation dataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI,
							resultSet.getString(5));

					if (dataLifecycleAnnotation != null) {
						used.addNewAnnotation();
						used.setAnnotationArray(0, dataLifecycleAnnotation);
					}
				}

				l.info(used);
				usedList.add(used);

			}
			resultSet.close();
			usedStmt.close();

			usedStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_COLLECTION_USED);
			usedStmt.setString(1, contextWorkflowURI);
			resultSet = usedStmt.executeQuery();

			while (resultSet.next()) {
				String processID = Common.PROCESS_IDENTIFIER
						+ resultSet.getString(1);
				int dataObjectId = resultSet.getInt(2);
				String artifactID = resultSet.getString(3);
				java.sql.Timestamp usedTime = resultSet.getTimestamp(4);
				String role = resultSet.getString(6);

				Used used = Used.Factory.newInstance();
				ProcessRef effect = used.addNewEffect();
				effect.setRef(processID);
				ArtifactRef cause = used.addNewCause();
				cause.setRef(Common.COLLECTION_IDENTIFIER + artifactID);

				OTime time = used.addNewTime();

				Calendar noEarlierThan = Common.getArtifactGeneratedTime(
						connection, dataObjectId);

				Calendar noLaterThan = Calendar.getInstance();
				noLaterThan.setTimeInMillis(usedTime.getTime());

				/*
				 * if noEarlierThan time is unavailable, we default to
				 * noLaterThan time
				 */

				if (noEarlierThan == null) {
					time.setNoEarlierThan(noLaterThan);
				} else {
					time.setNoEarlierThan(noEarlierThan);
				}
				time.setNoLaterThan(noLaterThan);

				if (role == null) {
					used.addNewRole().setValue("Input");
				} else {
					used.addNewRole().setValue(role);
				}

				l.info(used);
				usedList.add(used);

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation dataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI,
							resultSet.getString(5));
					if (dataLifecycleAnnotation != null) {
						used.addNewAnnotation();
						used.setAnnotationArray(0, dataLifecycleAnnotation);
					}
				}

				l.info(used);
				usedList.add(used);

			}
			resultSet.close();
			usedStmt.close();

			l.info("Exiting getOPMUsed() with success");
			return usedList;
		} catch (SQLException e) {
			l.error("Exiting getOPMUsed() with errors");
			l.error(e.toString());
			return null;
		} finally {
			if (usedStmt != null) {
				usedStmt.close();
				usedStmt = null;
			}

			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
		}
	}

	/*
	 * This function returns all the nodes that are connected by WasGeneratedBy
	 * causal dependency.
	 */
	public List<WasGeneratedBy> getOPMWasGeneratedBy(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMWasGeneratedBy()");

		PreparedStatement wasGeneratedByStmt = null;
		ResultSet res = null;

		try {
			List<WasGeneratedBy> wasGeneratedByList = new ArrayList<WasGeneratedBy>();

			wasGeneratedByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_FILE_WAS_GENERATED_BY);
			wasGeneratedByStmt.setString(1, contextWorkflowURI);
			res = wasGeneratedByStmt.executeQuery();

			while (res.next()) {
				String processId = Common.PROCESS_IDENTIFIER + res.getInt(1);
				int dataObjectId = res.getInt(2);
				String artifactId = Common.getArtifactId(connection,
						dataObjectId);
				java.sql.Timestamp noEarlierThan = res.getTimestamp(4);
				String role = res.getString(6);
				WasGeneratedBy wasGeneratedBy = WasGeneratedBy.Factory
						.newInstance();

				wasGeneratedBy.addNewEffect().setRef(artifactId);
				wasGeneratedBy.addNewCause().setRef(processId);

				if (role == null) {
					wasGeneratedBy.addNewRole().setValue("Output");
				} else {
					wasGeneratedBy.addNewRole().setValue(role);
				}

				OTime time = wasGeneratedBy.addNewTime();

				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				Calendar c = Common.getArtifactUsedTime(connection,
						dataObjectId);
				if (c == null)
					time.setNoLaterThan(Common
							.getCalendarFromTimeStamp(noEarlierThan));
				else
					time.setNoLaterThan(c);

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation dataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI, res.getString(5));
					if (dataLifecycleAnnotation != null) {
						wasGeneratedBy.addNewAnnotation();
						wasGeneratedBy.setAnnotationArray(0,
								dataLifecycleAnnotation);
					}
				}
				l.info(wasGeneratedBy);
				wasGeneratedByList.add(wasGeneratedBy);
			}

			res.close();
			wasGeneratedByStmt.close();

			wasGeneratedByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_BLOCK_WAS_GENERATED_BY);
			wasGeneratedByStmt.setString(1, contextWorkflowURI);
			res = wasGeneratedByStmt.executeQuery();

			while (res.next()) {
				String processId = Common.PROCESS_IDENTIFIER + res.getInt(1);
				int dataObjectId = res.getInt(2);
				String artifactId = res.getString(3);
				java.sql.Timestamp noEarlierThan = res.getTimestamp(4);
				String role = res.getString(6);

				WasGeneratedBy wasGeneratedBy = WasGeneratedBy.Factory
						.newInstance();

				wasGeneratedBy.addNewEffect().setRef(
						Common.BLOCK_IDENTIFIER + artifactId);
				wasGeneratedBy.addNewCause().setRef(processId);

				if (role == null) {
					wasGeneratedBy.addNewRole().setValue("Output");
				} else {
					wasGeneratedBy.addNewRole().setValue(role);
				}

				OTime time = wasGeneratedBy.addNewTime();

				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				Calendar c = Common.getArtifactUsedTime(connection,
						dataObjectId);
				if (c == null)
					time.setNoLaterThan(Common
							.getCalendarFromTimeStamp(noEarlierThan));
				else
					time.setNoLaterThan(c);

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation dataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI, res.getString(5));
					if (dataLifecycleAnnotation != null) {
						wasGeneratedBy.addNewAnnotation();
						wasGeneratedBy.setAnnotationArray(0,
								dataLifecycleAnnotation);
					}
				}

				l.info(wasGeneratedBy);
				wasGeneratedByList.add(wasGeneratedBy);
			}

			res.close();
			wasGeneratedByStmt.close();

			wasGeneratedByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_COLLECTION_WAS_GENERATED_BY);
			wasGeneratedByStmt.setString(1, contextWorkflowURI);
			res = wasGeneratedByStmt.executeQuery();

			while (res.next()) {
				String processId = Common.PROCESS_IDENTIFIER + res.getInt(1);
				int dataObjectId = res.getInt(2);
				String artifactId = res.getString(3);
				java.sql.Timestamp noEarlierThan = res.getTimestamp(4);
				String role = res.getString(6);

				WasGeneratedBy wasGeneratedBy = WasGeneratedBy.Factory
						.newInstance();

				wasGeneratedBy.addNewEffect().setRef(
						Common.COLLECTION_IDENTIFIER + artifactId);
				wasGeneratedBy.addNewCause().setRef(processId);

				if (role == null) {
					wasGeneratedBy.addNewRole().setValue("Output");
				} else {
					wasGeneratedBy.addNewRole().setValue(role);
				}

				OTime time = wasGeneratedBy.addNewTime();

				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				Calendar c = Common.getArtifactUsedTime(connection,
						dataObjectId);
				if (c == null)
					time.setNoLaterThan(Common
							.getCalendarFromTimeStamp(noEarlierThan));
				else
					time.setNoLaterThan(c);

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation dataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI, res.getString(5));
					if (dataLifecycleAnnotation != null) {
						wasGeneratedBy.addNewAnnotation();
						wasGeneratedBy.setAnnotationArray(0,
								dataLifecycleAnnotation);
					}
				}

				l.info(wasGeneratedBy);
				wasGeneratedByList.add(wasGeneratedBy);
			}

			res.close();
			wasGeneratedByStmt.close();

			l.info("Exiting getOPMWasGeneratedBy() with success");
			return wasGeneratedByList;
		} catch (SQLException e) {
			l.error("Exiting getOPMWasGeneratedBy() with errors");
			l.error(e.toString());
			return null;
		} finally {
			if (wasGeneratedByStmt != null) {
				wasGeneratedByStmt.close();
				wasGeneratedByStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function returns all the nodes that are connected by WasTriggeredBy
	 * causal dependency.
	 */
	public List<WasTriggeredBy> getOPMWasTriggeredBy(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMWasTriggeredBy()");

		HashMap<String, String> visitedWasTriggeredByEntity = new HashMap<String, String>();
		PreparedStatement wasTriggeredByStmt = null;
		ResultSet res = null;

		try {

			List<WasTriggeredBy> wasTriggeredByList = new ArrayList<WasTriggeredBy>();

			wasTriggeredByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_TRIGGERED_BY_WITH_ARTIFACTS);
			wasTriggeredByStmt.setString(1, contextWorkflowURI);
			wasTriggeredByStmt.setString(2, contextWorkflowURI);
			l.debug(wasTriggeredByStmt);
			res = wasTriggeredByStmt.executeQuery();

			while (res.next()) {
				String effectId = Common.PROCESS_IDENTIFIER
						+ res.getInt("effect");
				String causeId = Common.PROCESS_IDENTIFIER
						+ res.getInt("cause");

				java.sql.Timestamp noEarlierThan = res
						.getTimestamp("noEarlierThan");
				java.sql.Timestamp noLaterThan = res
						.getTimestamp("noLaterThan");

				WasTriggeredBy wasTriggeredBy = WasTriggeredBy.Factory
						.newInstance();
				ProcessRef effect = wasTriggeredBy.addNewEffect();
				effect.setRef(effectId);
				ProcessRef cause = wasTriggeredBy.addNewCause();
				cause.setRef(causeId);
				OTime time = wasTriggeredBy.addNewTime();
				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				time.setNoLaterThan(Common
						.getCalendarFromTimeStamp(noLaterThan));

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation consumedDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI,
							res.getString("consumed_event_id"));
					EmbeddedAnnotation producedDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI,
							res.getString("produced_event_id"));

					if (consumedDataLifecycleAnnotation != null) {
						wasTriggeredBy.addNewAnnotation();
						wasTriggeredBy.setAnnotationArray(0,
								consumedDataLifecycleAnnotation);
					}

					if (producedDataLifecycleAnnotation != null) {
						wasTriggeredBy.addNewAnnotation();
						wasTriggeredBy.setAnnotationArray(
								wasTriggeredBy.getAnnotationArray().length - 1,
								producedDataLifecycleAnnotation);
					}
				}

				l.info(wasTriggeredBy);
				wasTriggeredByList.add(wasTriggeredBy);
				visitedWasTriggeredByEntity.put(wasTriggeredBy.getEffect()
						.getRef() + wasTriggeredBy.getCause().getRef(),
						wasTriggeredBy.getCause().getRef());

			}
			res.close();
			wasTriggeredByStmt.close();

			wasTriggeredByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_TRIGGERED_BY_WITHOUT_ARTIFACTS);
			wasTriggeredByStmt.setString(1, contextWorkflowURI);
			l.debug(wasTriggeredByStmt);
			res = wasTriggeredByStmt.executeQuery();

			while (res.next()) {
				String effectId = Common.PROCESS_IDENTIFIER
						+ res.getInt("effect");
				String causeId = Common.PROCESS_IDENTIFIER
						+ res.getInt("cause");
				String invocationId = res.getString("invocation_id");
				java.sql.Timestamp noEarlierThan = res
						.getTimestamp("noEarlierThan");
				java.sql.Timestamp noLaterThan = res
						.getTimestamp("noLaterThan");

				WasTriggeredBy wasTriggeredBy = WasTriggeredBy.Factory
						.newInstance();
				ProcessRef effect = wasTriggeredBy.addNewEffect();
				effect.setRef(effectId);
				ProcessRef cause = wasTriggeredBy.addNewCause();
				cause.setRef(causeId);
				OTime time = wasTriggeredBy.addNewTime();
				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				time.setNoLaterThan(Common
						.getCalendarFromTimeStamp(noLaterThan));

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {
					EmbeddedAnnotation invocationAnnotation = getInvocationAnnotation(
							connection, contextWorkflowURI, invocationId);
					if (invocationAnnotation != null) {
						wasTriggeredBy.addNewAnnotation();
						wasTriggeredBy.setAnnotationArray(
								wasTriggeredBy.getAnnotationArray().length - 1,
								invocationAnnotation);
					}
				}

				l.info(wasTriggeredBy);
				if (visitedWasTriggeredByEntity.get(wasTriggeredBy.getEffect()
						.getRef() + wasTriggeredBy.getCause().getRef()) == null) {
					wasTriggeredByList.add(wasTriggeredBy);
				}
			}
			res.close();
			wasTriggeredByStmt.close();
			l.info("Exiting getOPMWasTriggeredBy() with success");

			return wasTriggeredByList;

		} catch (SQLException e) {
			l.error("Exiting getOPMWasTriggeredBy() with errors");
			l.error(e.toString());
			return null;
		} finally {
			if (wasTriggeredByStmt != null) {
				wasTriggeredByStmt.close();
				wasTriggeredByStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function returns all the nodes that are connected by WasControlledBy
	 * causal dependency.
	 */
	public List<WasControlledBy> getOPMWasControlledBy(Connection connection,
			String contextWorkflowURI) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMWasControlledBy()");

		PreparedStatement wasControlledByStmt = null;
		PreparedStatement wasControlledInvocationStmt = null;
		ResultSet res = null;

		try {

			List<WasControlledBy> wasControlledByList = new ArrayList<WasControlledBy>();

			wasControlledByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_CONTROLLED_BY_URI);
			wasControlledByStmt.setString(1, contextWorkflowURI);

			res = wasControlledByStmt.executeQuery();

			while (res.next()) {
				String causeId = Common.AGENT_IDENTIFIER
						+ res.getString("controller");
				String effectId = Common.PROCESS_IDENTIFIER
						+ res.getInt("process");

				WasControlledBy wasControlledBy = WasControlledBy.Factory
						.newInstance();
				ProcessRef effect = wasControlledBy.addNewEffect();
				effect.setRef(effectId);
				AgentRef cause = wasControlledBy.addNewCause();
				cause.setRef(causeId);
				Role role = wasControlledBy.addNewRole();
				role.setValue("ProcessControl");

				OTime startTime = wasControlledBy.addNewStartTime();
				OTime endTime = wasControlledBy.addNewEndTime();
				java.sql.Timestamp noEarlierThan = res
						.getTimestamp("noEarlierThan");
				java.sql.Timestamp noLaterThan = res
						.getTimestamp("noLaterThan");

				startTime.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				endTime.setNoLaterThan(Common
						.getCalendarFromTimeStamp(noLaterThan));

				l.info(wasControlledBy);
				wasControlledByList.add(wasControlledBy);

			}

			res.close();
			wasControlledByStmt.close();

			wasControlledInvocationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_CONTROLLED_BY_URI_WITH_CONTROL_INVOCATION);
			wasControlledInvocationStmt.setString(1, contextWorkflowURI);
			wasControlledInvocationStmt.setString(2, contextWorkflowURI);

			res = wasControlledInvocationStmt.executeQuery();

			while (res.next()) {
				String causeId = Common.AGENT_IDENTIFIER
						+ res.getString("controller");
				String effectId = Common.PROCESS_IDENTIFIER
						+ res.getInt("process");

				WasControlledBy wasControlledBy = WasControlledBy.Factory
						.newInstance();
				ProcessRef effect = wasControlledBy.addNewEffect();
				effect.setRef(effectId);
				AgentRef cause = wasControlledBy.addNewCause();
				cause.setRef(causeId);
				Role role = wasControlledBy.addNewRole();
				role.setValue("ProcessControl");

				OTime startTime = wasControlledBy.addNewStartTime();
				OTime endTime = wasControlledBy.addNewEndTime();
				java.sql.Timestamp noEarlierThan = res
						.getTimestamp("noEarlierThan");
				java.sql.Timestamp noLaterThan = res
						.getTimestamp("noLaterThan");

				startTime.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				endTime.setNoLaterThan(Common
						.getCalendarFromTimeStamp(noLaterThan));

				l.info(wasControlledBy);
				wasControlledByList.add(wasControlledBy);
			}

			res.close();
			wasControlledInvocationStmt.close();

			l.info("Exiting getOPMWasControlledBy() with success");
			return wasControlledByList;

		} catch (SQLException e) {
			l.error("Exiting getOPMWasControlledBy() with errors");
			l.error(e.toString());
			return null;
		} finally {
			if (wasControlledByStmt != null) {
				wasControlledByStmt.close();
				wasControlledByStmt = null;
			}

			if (wasControlledInvocationStmt != null) {
				wasControlledInvocationStmt.close();
				wasControlledInvocationStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function returns all the node that are connected by WasDerivedFrom
	 * causal dependency
	 */
	public List<WasDerivedFrom> getOPMWasDerivedFrom(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (contextWorkflowURI != null);
		l.info("Entering getOPMWasDerivedFrom()");

		PreparedStatement wasDerivedFromStmt = null;
		ResultSet res = null;
		try {
			wasDerivedFromStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_DERIVED_FROM);
			wasDerivedFromStmt.setString(1, contextWorkflowURI);
			res = wasDerivedFromStmt.executeQuery();

			List<WasDerivedFrom> wasDerivedFromList = new ArrayList<WasDerivedFrom>();

			while (res.next()) {
				String effectId = Common.getArtifactId(connection,
						res.getInt(1));
				java.sql.Timestamp noLaterThan = res.getTimestamp(2);
				String causeId = Common
						.getArtifactId(connection, res.getInt(3));
				java.sql.Timestamp noEarlierThan = res.getTimestamp(4);

				WasDerivedFrom wasDerivedFrom = WasDerivedFrom.Factory
						.newInstance();
				wasDerivedFrom.addNewEffect().setRef(effectId);
				wasDerivedFrom.addNewCause().setRef(causeId);

				OTime time = wasDerivedFrom.addNewTime();
				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				time.setNoLaterThan(Common
						.getCalendarFromTimeStamp(noLaterThan));

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					EmbeddedAnnotation effectDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI, res.getString(5));
					EmbeddedAnnotation causeDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, contextWorkflowURI, res.getString(6));
					if (effectDataLifecycleAnnotation != null) {
						wasDerivedFrom.addNewAnnotation();
						wasDerivedFrom.setAnnotationArray(0,
								effectDataLifecycleAnnotation);
					}
					if (causeDataLifecycleAnnotation != null) {
						wasDerivedFrom.addNewAnnotation();
						wasDerivedFrom.setAnnotationArray(1,
								causeDataLifecycleAnnotation);
					}
				}

				l.info(wasDerivedFrom);
				wasDerivedFromList.add(wasDerivedFrom);
			}
			l.info("Exiting getOPMWasDerivedFrom() with success");
			res.close();
			wasDerivedFromStmt.close();
			return wasDerivedFromList;
		} catch (SQLException e) {
			l.error("Exiting getOPMWasDerivedFrom() with errors");
			l.error(e.toString());
			return null;
		} finally {
			if (wasDerivedFromStmt != null) {
				wasDerivedFromStmt.close();
				wasDerivedFromStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/*
	 * This function returns all the causal dependency involved
	 */
	public CausalDependencies getOPMCausalDependencies(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {

		CausalDependencies causalDependencies = CausalDependencies.Factory
				.newInstance();
		List<Used> usedList = getOPMUsed(connection, contextWorkflowURI,
				informationDetailLevel);
		List<WasDerivedFrom> wasDerivedFromList = getOPMWasDerivedFrom(
				connection, contextWorkflowURI, informationDetailLevel);
		List<WasTriggeredBy> wasTriggeredByList = getOPMWasTriggeredBy(
				connection, contextWorkflowURI, informationDetailLevel);
		List<WasGeneratedBy> wasGeneratedByList = getOPMWasGeneratedBy(
				connection, contextWorkflowURI, informationDetailLevel);
		List<WasControlledBy> wasControlledByList = getOPMWasControlledBy(
				connection, contextWorkflowURI);

		if (usedList != null)
			causalDependencies.setUsedArray(usedList.toArray(new Used[0]));
		if (wasDerivedFromList != null)
			causalDependencies.setWasDerivedFromArray(wasDerivedFromList
					.toArray(new WasDerivedFrom[0]));
		if (wasTriggeredByList != null)
			causalDependencies.setWasTriggeredByArray(wasTriggeredByList
					.toArray(new WasTriggeredBy[0]));
		if (wasGeneratedByList != null)
			causalDependencies.setWasGeneratedByArray(wasGeneratedByList
					.toArray(new WasGeneratedBy[0]));
		if (wasControlledByList != null)
			causalDependencies.setWasControlledByArray(wasControlledByList
					.toArray(new WasControlledBy[0]));

		l.info(causalDependencies);
		return causalDependencies;
	}

	/* This function is used to get the opm graph for the given instance */
	public OpmGraphDocument getOPMGraphDocument(Connection connection,
			String contextWorkflowURI,
			DetailEnumType.Enum informationDetailLevel) throws QueryException,
			SQLException {

		OpmGraphDocument opmGraphDoc = OpmGraphDocument.Factory.newInstance();
		OPMGraph opmGraph = opmGraphDoc.addNewOpmGraph();

		PreparedStatement statement = null;
		PreparedStatement getCountStatement = null;
		ResultSet resultSet = null;
		ResultSet rs = null;

		try {
			statement = connection.prepareStatement(GET_CACHE_WF_GRAPH);
			statement.setString(1, contextWorkflowURI);
			if (informationDetailLevel.equals(DetailEnumType.FINE)) {
				statement.setBoolean(2, true);
			} else {
				statement.setBoolean(2, false);
			}
			resultSet = statement.executeQuery();

			boolean isCached = false;
			boolean b = false;
			int id = 0;
			if (resultSet.next()) {
				b = resultSet.getBoolean(4);
				id = resultSet.getInt(1);
				String cachedGraph = resultSet.getString(3);
				isCached = true;
				if (!b) {
					l.info("Returning cached graph.");
					statement.close();
					resultSet.close();

					statement = connection.prepareStatement(UPDATE_QUERY_DATE);
					statement.setTimestamp(1, new java.sql.Timestamp(Calendar
							.getInstance().getTimeInMillis()));
					statement.setInt(2, id);
					statement.execute();
					statement.close();

					opmGraphDoc = OpmGraphDocument.Factory.parse(cachedGraph);
					return opmGraphDoc;
				}
			} else {
				l.info("Query has not been cached.");
				isCached = false;
			}

			statement.close();
			resultSet.close();

			long beginTime = System.currentTimeMillis();

			Processes opmProcesses = getOPMProcesses(connection,
					contextWorkflowURI, informationDetailLevel);
			Artifacts opmArtifacts = getOPMArtifacts(connection,
					contextWorkflowURI, informationDetailLevel);
			Agents opmAgents = getOPMAgents(connection, contextWorkflowURI,
					informationDetailLevel);

			if (opmProcesses.getProcessArray().length > 0)
				opmGraph.setProcesses(opmProcesses);
			if (opmArtifacts.getArtifactArray().length > 0)
				opmGraph.setArtifacts(opmArtifacts);
			if (opmAgents.getAgentArray().length > 0)
				opmGraph.setAgents(opmAgents);

			opmGraph.setCausalDependencies(getOPMCausalDependencies(connection,
					contextWorkflowURI, informationDetailLevel));

			long endTime = System.currentTimeMillis();

			long generationTime = endTime - beginTime;
			l.info(opmGraphDoc);

			if (!isCached) {
				// graph is not cached
				getCountStatement = connection
						.prepareStatement(GET_CACHE_COUNT);
				rs = getCountStatement.executeQuery();
				if (rs.next()) {
					if (rs.getInt(1) == MAX_CACHE_ENTRIES) {
						statement = connection
								.prepareStatement(GET_GRAPH_TO_DELETE);
						resultSet = statement.executeQuery();
						if (resultSet.next()) {
							resultSet.deleteRow();
						}
						statement.close();
						resultSet.close();
					}

					statement = connection.prepareStatement(NEW_CACHE_GRAPH);
					statement.setString(1, contextWorkflowURI);
					statement.setString(2, opmGraphDoc.xmlText());
					statement.setString(3, String.valueOf(generationTime));
					statement.setTimestamp(4, new java.sql.Timestamp(Calendar
							.getInstance().getTimeInMillis()));
					if (informationDetailLevel == DetailEnumType.FINE) {
						statement.setBoolean(5, true);
					} else {
						statement.setBoolean(5, false);
					}

				}

				getCountStatement.close();
				l.info("Caching graph.");
			} else {
				// dirty bit was set so update
				statement = connection.prepareStatement(UPDATE_CACHE_GRAPH);
				statement.setString(1, opmGraphDoc.xmlText());
				statement.setBoolean(2, false);
				statement.setString(3, String.valueOf(generationTime));
				statement.setTimestamp(4, new java.sql.Timestamp(Calendar
						.getInstance().getTimeInMillis()));
				statement.setInt(5, id);
				l.info("Updating cache graph.");
			}

			statement.executeUpdate();
			statement.close();

		} catch (SQLException e) {
			l.error("Exiting getOPMGraphDocument() with SQL errors");
			l.error(e.toString());
			return opmGraphDoc;

		} catch (XmlException e) {
			l.error("Exiting getOPMGraphDocument() with XML parse errors");
			l.error(e.toString());
			return opmGraphDoc;

		} finally {
			if (statement != null) {
				statement.close();
				statement = null;
			}

			if (getCountStatement != null) {
				getCountStatement.close();
				getCountStatement = null;
			}

			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}

			if (rs != null) {
				rs.close();
				rs = null;
			}
		}

		l.info("Exiting getOPMGraphDocument() with success");
		return opmGraphDoc;
	}
}
