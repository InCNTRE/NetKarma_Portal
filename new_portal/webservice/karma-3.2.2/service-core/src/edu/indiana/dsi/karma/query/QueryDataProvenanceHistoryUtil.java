package edu.indiana.dsi.karma.query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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

/*
 * @author You-Wei Cheah 
 */

public class QueryDataProvenanceHistoryUtil {

	public static final Log l = LogFactory
			.getLog(QueryDataProvenanceHistoryUtil.class);

	// for use with cache table
	private static final String NEW_CACHE_GRAPH = "INSERT INTO cache_provenance_history_graph (data_product_id, graph_content, generation_time, query_date, time_range, detailed) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_CACHE_GRAPH = "UPDATE cache_provenance_history_graph SET graph_content = ? , dirty = ? , generation_time = ? , query_date = ? WHERE graph_id = ?";
	private static final String GET_CACHE_PROVENANCE_HISTORY_GRAPH = "SELECT * FROM cache_provenance_history_graph WHERE data_product_id = ? and time_range = ? and detailed = ?";
	private static final String GET_CACHE_COUNT = "SELECT count(*) FROM cache_provenance_history_graph";
	private static final String UPDATE_QUERY_DATE = "UPDATE cache_provenance_history_graph SET query_date = ? WHERE graph_id = ?";
	private static final String GET_GRAPH_TO_DELETE = "(SELECT * FROM cache_provenance_history_graph ORDER BY query_date ASC) ORDER BY generation_time ASC limit 1";
	private static final int MAX_CACHE_ENTRIES = 10000;

	/* Hash maps to store visited nodes and edges */
	HashMap<String, String> visitedArtifacts = new HashMap<String, String>();
	HashMap<String, String> visitedProcesses = new HashMap<String, String>();
	HashMap<String, String> visitedAgents = new HashMap<String, String>();
	HashMap<String, String> visitedUsed = new HashMap<String, String>();
	HashMap<String, String> visitedWasGeneratedBy = new HashMap<String, String>();
	HashMap<String, String> visitedWasDerivedFrom = new HashMap<String, String>();
	HashMap<String, String> visitedWasTriggeredBy = new HashMap<String, String>();
	HashMap<String, String> visitedWasControlledBy = new HashMap<String, String>();
	HashMap<String, String> visitedRegEntity = new HashMap<String, String>();

	private void setOPMUsed(Used u, Used newUsed) {

		newUsed.setAnnotationArray(u.getAnnotationArray());
		newUsed.setCause(u.getCause());
		newUsed.setEffect(u.getEffect());
		newUsed.setRole(u.getRole());
		newUsed.setTime(u.getTime());
	}

	private void setOPMWasTriggeredBy(WasTriggeredBy w,
			WasTriggeredBy newWasTriggeredBy) {

		newWasTriggeredBy.setTime(w.getTime());
		newWasTriggeredBy.setEffect(w.getEffect());
		newWasTriggeredBy.setCause(w.getCause());
		newWasTriggeredBy.setAnnotationArray(w.getAnnotationArray());
	}

	private void setOPMWasDerivedFrom(WasDerivedFrom w,
			WasDerivedFrom newWasDerivedFrom) {

		newWasDerivedFrom.setTime(w.getTime());
		newWasDerivedFrom.setEffect(w.getEffect());
		newWasDerivedFrom.setCause(w.getCause());
		newWasDerivedFrom.setAnnotationArray(w.getAnnotationArray());
	}

	private void setOPMWasGeneratedBy(WasGeneratedBy w,
			WasGeneratedBy newWasGeneratedBy) {

		newWasGeneratedBy.setTime(w.getTime());
		newWasGeneratedBy.setEffect(w.getEffect());
		newWasGeneratedBy.setCause(w.getCause());
		newWasGeneratedBy.setAnnotationArray(w.getAnnotationArray());
		newWasGeneratedBy.setRole(w.getRole());
	}

	private void setOPMWasControlledBy(WasControlledBy w,
			WasControlledBy newWasControlledBy) {

		if (w.getStartTime() != null)
			newWasControlledBy.setStartTime(w.getStartTime());
		if (w.getEndTime() != null)
			newWasControlledBy.setEndTime(w.getEndTime());
		newWasControlledBy.setEffect(w.getEffect());
		newWasControlledBy.setCause(w.getCause());
		newWasControlledBy.setAnnotationArray(w.getAnnotationArray());
		newWasControlledBy.setRole(w.getRole());
	}

	private void setOPMProcess(Process p, Process newProcess) {
		if (p.getAnnotationArray() != null)
			newProcess.setAnnotationArray(p.getAnnotationArray());
		if (p.getId() != null)
			newProcess.setId(p.getId());
	}

	private void setOPMArtifact(Artifact a, Artifact newArtifact) {
		if (a.getAnnotationArray() != null)
			newArtifact.setAnnotationArray(a.getAnnotationArray());
		if (a.getId() != null)
			newArtifact.setId(a.getId());
	}

	private void setOPMAgent(Agent a, Agent newAgent) {
		if (a.getAnnotationArray() != null)
			newAgent.setAnnotationArray(a.getAnnotationArray());
		if (a.getId() != null)
			newAgent.setId(a.getId());
	}

	private void copyToNewGraph(OpmGraphDocument oGraph, OpmGraphDocument nGraph) {
		OPMGraph opmGraph = nGraph.getOpmGraph();
		Artifacts processGraphArtifacts = opmGraph.getArtifacts();
		Processes processGraphProcesses = opmGraph.getProcesses();
		Agents processGraphAgents = opmGraph.getAgents();
		CausalDependencies processCausalDependencies = opmGraph
				.getCausalDependencies();
		OPMGraph graph = oGraph.getOpmGraph();

		if (graph.getArtifacts() != null) {
			if (processGraphArtifacts == null)
				processGraphArtifacts = opmGraph.addNewArtifacts();
			for (Artifact a : graph.getArtifacts().getArtifactArray()) {
				Artifact newArtifact = processGraphArtifacts.addNewArtifact();
				setOPMArtifact(a, newArtifact);
			}
		}

		if (graph.getProcesses() != null) {
			if (processGraphProcesses == null)
				processGraphProcesses = opmGraph.addNewProcesses();
			for (Process p : graph.getProcesses().getProcessArray()) {

				Process newProcess = processGraphProcesses.addNewProcess();
				setOPMProcess(p, newProcess);
			}
		}

		if (graph.getAgents() != null) {
			if (processGraphAgents == null)
				processGraphAgents = opmGraph.addNewAgents();
			for (Agent a : graph.getAgents().getAgentArray()) {

				Agent newAgent = processGraphAgents.addNewAgent();
				setOPMAgent(a, newAgent);
			}
		}

		if (graph.getCausalDependencies() != null) {
			if (processCausalDependencies == null)
				processCausalDependencies = opmGraph.addNewCausalDependencies();

			if (graph.getCausalDependencies().getUsedArray() != null) {

				for (Used u : graph.getCausalDependencies().getUsedArray()) {
					Used newUsed = processCausalDependencies.addNewUsed();
					setOPMUsed(u, newUsed);
				}
			}

			if (graph.getCausalDependencies().getWasTriggeredByArray() != null) {

				for (WasTriggeredBy w : graph.getCausalDependencies()
						.getWasTriggeredByArray()) {
					WasTriggeredBy newWasTriggeredBy = processCausalDependencies
							.addNewWasTriggeredBy();
					setOPMWasTriggeredBy(w, newWasTriggeredBy);
				}
			}

			if (graph.getCausalDependencies().getWasGeneratedByArray() != null) {

				for (WasGeneratedBy w : graph.getCausalDependencies()
						.getWasGeneratedByArray()) {
					WasGeneratedBy newWasGeneratedBy = processCausalDependencies
							.addNewWasGeneratedBy();
					setOPMWasGeneratedBy(w, newWasGeneratedBy);
				}
			}

			if (graph.getCausalDependencies().getWasDerivedFromArray() != null) {

				for (WasDerivedFrom w : graph.getCausalDependencies()
						.getWasDerivedFromArray()) {
					WasDerivedFrom newWasDerivedFrom = processCausalDependencies
							.addNewWasDerivedFrom();
					setOPMWasDerivedFrom(w, newWasDerivedFrom);
				}
			}

			if (graph.getCausalDependencies().getWasControlledByArray() != null) {

				for (WasControlledBy w : graph.getCausalDependencies()
						.getWasControlledByArray()) {
					WasControlledBy newWasControlledBy = processCausalDependencies
							.addNewWasControlledBy();
					setOPMWasControlledBy(w, newWasControlledBy);
				}
			}
		}
	}

	public List<WasDerivedFrom> getOPMWasDerivedFrom(Connection connection,
			String dataObjectID, String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (dataObjectID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMWasDerivedFrom()");

		PreparedStatement wasDerivedFromStmt = null;
		ResultSet res = null;
		try {
			wasDerivedFromStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_WAS_DERIVED_FROM);
			wasDerivedFromStmt.setString(
					1,
					dataObjectID.replace(Common.FILE_IDENTIFIER, "").replace(
							Common.BLOCK_IDENTIFIER, ""));
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

				l.info(wasDerivedFrom);
				OTime time = wasDerivedFrom.addNewTime();
				time.setNoEarlierThan(Common
						.getCalendarFromTimeStamp(noEarlierThan));
				time.setNoLaterThan(Common
						.getCalendarFromTimeStamp(noLaterThan));

				if (informationDetailLevel != null
						&& informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {
					EmbeddedAnnotation effectDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, res.getString("consumed_event_id"));
					EmbeddedAnnotation causeDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, res.getString("produced_event_id"));
					if (effectDataLifecycleAnnotation != null) {
						wasDerivedFrom.addNewAnnotation();
						int i = wasDerivedFrom.getAnnotationArray().length - 1;
						wasDerivedFrom.setAnnotationArray(i,
								effectDataLifecycleAnnotation);

					}

					if (causeDataLifecycleAnnotation != null) {
						wasDerivedFrom.addNewAnnotation();
						int i = wasDerivedFrom.getAnnotationArray().length - 1;
						wasDerivedFrom.setAnnotationArray(i,
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

	public List<WasTriggeredBy> getOPMWasTriggeredBy(Connection connection,
			String processID, String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (processID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMWasTriggeredBy()");

		PreparedStatement wasTriggeredByStmt = null;
		ResultSet res = null;

		try {
			processID = processID.replace(Common.PROCESS_IDENTIFIER, "");
			List<WasTriggeredBy> wasTriggeredByList = new ArrayList<WasTriggeredBy>();

			wasTriggeredByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_WAS_TRIGGERED_BY_WITH_ARTIFACTS);

			wasTriggeredByStmt.setString(1, processID);

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
						&& informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {
					EmbeddedAnnotation consumedDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, res.getString("consumed_event_id"));
					EmbeddedAnnotation producedDataLifecycleAnnotation = getDataLifecycleAnnotation(
							connection, res.getString("produced_event_id"));
					if (consumedDataLifecycleAnnotation != null) {
						wasTriggeredBy.addNewAnnotation();
						int i = wasTriggeredBy.getAnnotationArray().length - 1;
						wasTriggeredBy.setAnnotationArray(i,
								consumedDataLifecycleAnnotation);

					}

					if (producedDataLifecycleAnnotation != null) {
						wasTriggeredBy.addNewAnnotation();
						int i = wasTriggeredBy.getAnnotationArray().length - 1;
						wasTriggeredBy.setAnnotationArray(i,
								producedDataLifecycleAnnotation);
					}
				}

				l.info(wasTriggeredBy);
				wasTriggeredByList.add(wasTriggeredBy);

			}
			res.close();
			wasTriggeredByStmt.close();

			wasTriggeredByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_WAS_TRIGGERED_BY_WITHOUT_ARTIFACTS);

			wasTriggeredByStmt.setString(1, processID);
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
							connection, provenanceHistoryDataObjectID,
							invocationId);
					if (invocationAnnotation != null) {
						wasTriggeredBy.addNewAnnotation();
						wasTriggeredBy.setAnnotationArray(0,
								invocationAnnotation);
					}
				}
				l.info(wasTriggeredBy);
				wasTriggeredByList.add(wasTriggeredBy);

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

	public List<WasControlledBy> getOPMWasControlledBy(Connection connection,
			String processID, String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (processID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMWasControlledBy()");

		PreparedStatement wasControlledByStmt = null;
		ResultSet res = null;

		try {
			wasControlledByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_CONTROLLED_BY_ID);
			wasControlledByStmt.setString(1,
					processID.replace(Common.PROCESS_IDENTIFIER, ""));
			res = wasControlledByStmt.executeQuery();
			List<WasControlledBy> wasControlledByList = new ArrayList<WasControlledBy>();

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

				if (informationDetailLevel != null
						&& informationDetailLevel.equals(DetailEnumType.FINE)) {

					// EmbeddedAnnotation dataLifecycleAnnotation =
					// getDataLifecycleAnnotation(
					// connection, dataObjectID, fRes.getString(5));
					// if (dataLifecycleAnnotation != null) {
					// wasControlledBy.addNewAnnotation();
					// wasControlledBy.setAnnotationArray(0,
					// dataLifecycleAnnotation);
					// }
				}
				l.info(wasControlledBy);
				wasControlledByList.add(wasControlledBy);
			}

			res.close();
			wasControlledByStmt.close();

			wasControlledByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_WAS_CONTROLLED_BY_ID_WITH_CONTROL_INVOCATION);
			wasControlledByStmt.setString(1,
					processID.replace(Common.PROCESS_IDENTIFIER, ""));

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

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	public List<WasGeneratedBy> getOPMWasGeneratedBy(Connection connection,
			String dataObjectID, String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (dataObjectID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMWasGeneratedBy()");

		PreparedStatement wasGeneratedByStmt = null;
		ResultSet res = null;

		try {
			wasGeneratedByStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_FILE_WAS_GENERATED_BY);
			l.debug("getOPMWasGeneratedBy() using dataObjectID: "
					+ dataObjectID);
			wasGeneratedByStmt.setString(
					1,
					dataObjectID.replace(Common.FILE_IDENTIFIER, "").replace(
							Common.BLOCK_IDENTIFIER, ""));
			res = wasGeneratedByStmt.executeQuery();
			List<WasGeneratedBy> wasGeneratedByList = new ArrayList<WasGeneratedBy>();

			while (res.next()) {
				String processId = Common.PROCESS_IDENTIFIER + res.getInt(1);
				int dataObjectId = res.getInt(2);
				java.sql.Timestamp noEarlierThan = res.getTimestamp(4);
				String role = res.getString(6);

				WasGeneratedBy wasGeneratedBy = WasGeneratedBy.Factory
						.newInstance();

				wasGeneratedBy.addNewEffect().setRef(
						Common.FILE_IDENTIFIER + dataObjectId);
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
							connection, res.getString(5));
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
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_BLOCK_WAS_GENERATED_BY);
			wasGeneratedByStmt.setString(1,
					dataObjectID.replace(Common.BLOCK_IDENTIFIER, ""));
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
							connection, res.getString(5));
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

			// Collection support to be implemented.

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

	public List<Used> getOPMUsed(Connection connection, String processID,
			String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (processID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMUsed()");

		PreparedStatement dataObjectUsedSqlStmt = null;
		ResultSet res = null;
		try {
			processID = processID.replace(Common.PROCESS_IDENTIFIER, "");
			List<Used> usedList = new ArrayList<Used>();

			dataObjectUsedSqlStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_FILE_USED);
			dataObjectUsedSqlStmt.setString(1, processID);
			l.info("processID : " + processID);

			res = dataObjectUsedSqlStmt.executeQuery();

			while (res.next()) {
				String pID = Common.PROCESS_IDENTIFIER + res.getString(1);
				int dataObjectId = res.getInt(2);
				java.sql.Timestamp usedTime = res.getTimestamp(4);
				String role = res.getString(6);

				Used used = Used.Factory.newInstance();
				ProcessRef effect = used.addNewEffect();
				effect.setRef(pID);
				ArtifactRef cause = used.addNewCause();
				cause.setRef(Common.FILE_IDENTIFIER + dataObjectId);

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
							connection, res.getString(5));
					used.addNewAnnotation();
					used.setAnnotationArray(0, dataLifecycleAnnotation);
				}

				usedList.add(used);

			}
			res.close();
			dataObjectUsedSqlStmt.close();

			dataObjectUsedSqlStmt = connection
					.prepareStatement(OPMSqlQuery.GET_OPM_DATA_BLOCK_USED);
			dataObjectUsedSqlStmt.setString(1, processID);
			res = dataObjectUsedSqlStmt.executeQuery();

			while (res.next()) {
				String pID = Common.PROCESS_IDENTIFIER + res.getString(1);
				int dataObjectId = res.getInt(2);
				String artifactID = res.getString(3);
				java.sql.Timestamp usedTime = res.getTimestamp(4);
				String role = res.getString(6);

				Used used = Used.Factory.newInstance();
				ProcessRef effect = used.addNewEffect();
				effect.setRef(pID);
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
							connection, res.getString(5));
					used.addNewAnnotation();
					used.setAnnotationArray(0, dataLifecycleAnnotation);
				}

				usedList.add(used);

			}
			res.close();
			dataObjectUsedSqlStmt.close();

			// Collection support to be implemented.

			l.info("Exiting getOPMUsed() with success");
			return usedList;
		} catch (SQLException e) {
			l.error("Exiting getOPMUsed() with errors");
			l.error(e.toString());
			return null;
		} finally {

			if (dataObjectUsedSqlStmt != null) {
				dataObjectUsedSqlStmt.close();
				dataObjectUsedSqlStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	public Agent getOPMAgentByID(Connection connection, String agentID,
			String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (agentID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMAgentByID()");
		Agent agent = Agent.Factory.newInstance();

		agent.setId(agentID);

		int userID = Integer.parseInt(agentID.replace(Common.AGENT_IDENTIFIER,
				""));
		PreparedStatement getUserControllerStmt = null;
		PreparedStatement getRoleStmt = null;
		ResultSet res = null;
		ResultSet roleResultSet = null;

		if (informationDetailLevel != null
				&& informationDetailLevel.equals(DetailEnumType.FINE)) {

			try {
				getUserControllerStmt = connection
						.prepareStatement(OPMSqlQuery.GET_USER_CONTROLLER_BY_ID);
				getUserControllerStmt.setInt(1, userID);

				res = getUserControllerStmt.executeQuery();

				if (res.next()) {

					String dn = res.getString("dn");
					String name = res.getString("name");
					String affiliation = res.getString("affiliation");
					String email = res.getString("email");

					if (dn != null) {

						Property property;

						if (agent.getAnnotationArray().length == 0) {
							EmbeddedAnnotation embeddedAnnotation = agent
									.addNewAnnotation();
							property = embeddedAnnotation.addNewProperty();
						} else {
							property = agent.getAnnotationArray(0)
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

						if (agent.getAnnotationArray().length == 0) {
							EmbeddedAnnotation embeddedAnnotation = agent
									.addNewAnnotation();
							property = embeddedAnnotation.addNewProperty();
						} else {
							property = agent.getAnnotationArray(0)
									.addNewProperty();
						}
						try {
							property.addNewValue().set(
									XmlObject.Factory.parse("<name>" + name
											+ "</name>"));
							property.setUri("agent-name");

						} catch (XmlException e) {
							l.error("Set agent name error.");
							l.error(e.toString());
						}
					}

					if (affiliation != null) {

						Property property;

						if (agent.getAnnotationArray().length == 0) {
							EmbeddedAnnotation embeddedAnnotation = agent
									.addNewAnnotation();
							property = embeddedAnnotation.addNewProperty();
						} else {
							property = agent.getAnnotationArray(0)
									.addNewProperty();
						}
						try {
							property.addNewValue().set(
									XmlObject.Factory.parse("<affiliation>"
											+ affiliation + "</affiliation>"));
							property.setUri("agent-affiliation");

						} catch (XmlException e) {
							l.error("Set agent affiliation error.");
							l.error(e.toString());
						}
					}

					if (email != null) {

						Property property;

						if (agent.getAnnotationArray().length == 0) {
							EmbeddedAnnotation embeddedAnnotation = agent
									.addNewAnnotation();
							property = embeddedAnnotation.addNewProperty();
						} else {
							property = agent.getAnnotationArray(0)
									.addNewProperty();
						}
						try {
							property.addNewValue().set(
									XmlObject.Factory.parse("<email>" + email
											+ "</email>"));
							property.setUri("agent-email");

						} catch (XmlException e) {
							l.error("Set agent email error.");
							l.error(e.toString());
						}
					}

					getRoleStmt = connection
							.prepareStatement(OPMSqlQuery.GET_AUTHORSHIP_BY_ENTITY_ID);
					getRoleStmt.setInt(1, userID);
					roleResultSet = getRoleStmt.executeQuery();

					if (roleResultSet.next()) {
						String role = roleResultSet.getString("role");

						if (role != null) {

							Property property;

							if (agent.getAnnotationArray().length == 0) {
								EmbeddedAnnotation embeddedAnnotation = agent
										.addNewAnnotation();
								property = embeddedAnnotation.addNewProperty();
							} else {
								property = agent.getAnnotationArray(0)
										.addNewProperty();
							}
							try {
								property.addNewValue().set(
										XmlObject.Factory.parse("<role>" + role
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

				getUserControllerStmt.close();
				res.close();

			} catch (SQLException e) {
				l.error("Exiting getAgentByID() with errors");
				l.error(e.toString());
				return null;
			} finally {

				if (getUserControllerStmt != null) {
					getUserControllerStmt.close();
					getUserControllerStmt = null;
				}

				if (getRoleStmt != null) {
					getRoleStmt.close();
					getRoleStmt = null;
				}

				if (res != null) {
					res.close();
					res = null;
				}

				if (roleResultSet != null) {
					roleResultSet.close();
					roleResultSet = null;
				}
			}
		}

		return agent;
	}

	public Processes getOPMProcessesByID(Connection connection,
			String processID, String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (processID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMProcessesByID()");

		PreparedStatement getOPMProcessesStmt = null;
		PreparedStatement getOPMRegProcessesStmt = null;
		ResultSet res = null;
		ResultSet regProcessResult = null;
		try {
			Processes processes = Processes.Factory.newInstance();
			Process process = processes.addNewProcess();

			getOPMProcessesStmt = connection
					.prepareStatement(OPMSqlQuery.GET_EXE_ENTITIES_BY_ID);
			l.info("getProcessByID: " + processID);
			getOPMProcessesStmt.setString(1,
					processID.replace(Common.PROCESS_IDENTIFIER, ""));
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
			String entityType = null;
			int instanceOfID = 0;

			res = getOPMProcessesStmt.executeQuery();

			while (res.next()) {
				userID = workflowID = serviceID = methodID = workflowNodeID = processID = entityType = null;
				timestep = -1;
				entityType = res.getString("entity_type");
				instanceOfID = res.getInt("instance_of");

				/* create the process ID */
				processID = Common.PROCESS_IDENTIFIER + res.getInt("entity_id");

				/* Add the new Process in the Processes list and set the fields */
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
							userID = res.getString("entity_uri");

							Property userIDProperty = embeddedAnnotation
									.addNewProperty();
							userIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<userID>" + userID
											+ "</userID>"));
							userIDProperty.setUri("process-userID");

						} else if (entityType
								.equals(EntityCategoryEnum.WORKFLOW.toString())) {
							workflowID = res.getString("entity_uri");

							Property workflowIDProperty = embeddedAnnotation
									.addNewProperty();
							workflowIDProperty.addNewValue().set(
									XmlObject.Factory.parse("<workflowID>"
											+ workflowID + "</workflowID>"));
							workflowIDProperty.setUri("process-workflowID");

						} else if (entityType.equals(EntityCategoryEnum.SERVICE
								.toString())) {

							workflowID = res.getString("context_workflow_uri");
							serviceID = res.getString("entity_uri");
							workflowNodeID = res
									.getString("context_wf_node_id_token");
							timestep = res.getInt("timestep");

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
							workflowID = res.getString("context_workflow_uri");
							serviceID = res.getString("context_service_uri");
							workflowNodeID = res
									.getString("context_wf_node_id_token");
							timestep = res.getInt("timestep");
							methodID = res.getString("entity_uri");

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
								connection, provenanceHistoryDataObjectID,
								res.getString("entity_id"));
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
											.setUri("process-version");

									EmbeddedAnnotation regEntityAnnotation = getRegEntityAnnotation(
											connection,
											provenanceHistoryDataObjectID,
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

						regProcessResult.close();
						getOPMRegProcessesStmt.close();
					}
				}
			}
			res.close();
			getOPMProcessesStmt.close();
			l.info(process);
			l.info("Exiting getOPMProcessesByID()");
			return processes;
		} catch (SQLException e) {
			l.error("Exiting getOPMProcessesByID() with errors");
			l.error(e.toString());
			return null;
		} finally {

			if (getOPMProcessesStmt != null) {
				getOPMProcessesStmt.close();
				getOPMProcessesStmt = null;
			}

			if (getOPMRegProcessesStmt != null) {
				getOPMRegProcessesStmt.close();
				getOPMRegProcessesStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}

			if (regProcessResult != null) {
				regProcessResult.close();
				regProcessResult = null;
			}
		}
	}

	public Artifact getOPMArtifactByID(Connection connection,
			String artifactID, String provenanceHistoryDataObjectID,
			DetailEnumType.Enum informationDetailLevel) throws SQLException {
		assert (connection != null);
		assert (artifactID != null);
		assert (provenanceHistoryDataObjectID != null);
		l.info("Entering getOPMArtifactsByID()");

		PreparedStatement getArtifactStmt = null;
		ResultSet res = null;

		/* get artifact based on unique ID */
		try {
			Artifact opmArtifact = Artifact.Factory.newInstance();

			/* get file_id */
			if (artifactID.startsWith(Common.FILE_IDENTIFIER)) {
				String fileID = artifactID.replace(Common.FILE_IDENTIFIER, "");

				getArtifactStmt = connection
						.prepareStatement(OPMSqlQuery.GET_FILE_BY_ID);
				getArtifactStmt.setString(1, fileID);

				res = getArtifactStmt.executeQuery();

				if (res.next()) {
					String fileURI = res.getString(1);
					String size = res.getString(2);

					opmArtifact.setId(artifactID);

					if (informationDetailLevel != null
							&& informationDetailLevel
									.equals(DetailEnumType.FINE)) {

						try {
							Property newProperty;
							EmbeddedAnnotation embeddedAnnotation = opmArtifact
									.addNewAnnotation();
							newProperty = embeddedAnnotation.addNewProperty();
							newProperty.addNewValue().set(
									XmlObject.Factory.parse("<fileURI>"
											+ fileURI + "</fileURI>"));

							newProperty.setUri("artifact-uri");

						} catch (XmlException e) {
							l.error("Set uri annotation error.");
							l.error(e.toString());
						}

						if (size != null) {
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
										XmlObject.Factory.parse("<size>" + size
												+ "</size>"));
								newProperty.setUri("artifact-size");

							} catch (XmlException e) {
								l.error("Set size annotation error.");
								l.error(e.toString());
							}

						}

						EmbeddedAnnotation entityAnnotation = getDataObjectAnnotation(
								connection, provenanceHistoryDataObjectID,
								fileID);
						if (entityAnnotation != null) {
							opmArtifact.addNewAnnotation();
							opmArtifact
									.setAnnotationArray(
											opmArtifact.getAnnotationArray().length - 1,
											entityAnnotation);
						}
					}
					l.info("Got artifact with ID : " + fileID);
				}

				res.close();
				getArtifactStmt.close();
			} else if (artifactID.startsWith(Common.BLOCK_IDENTIFIER)) {
				String inputBlockID = artifactID.replace(
						Common.BLOCK_IDENTIFIER, "");
				/* get block_id */
				getArtifactStmt = connection
						.prepareStatement(OPMSqlQuery.GET_BLOCK_BY_ID);
				getArtifactStmt.setString(1, inputBlockID);

				res = getArtifactStmt.executeQuery();

				if (res.next()) {

					String size = res.getString(2);
					String content = res.getString(3);
					opmArtifact.setId(artifactID);
					if (res.getString(1).equals(inputBlockID)
							&& informationDetailLevel != null
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

						if (content != null) {
							try {
								if (opmArtifact.getAnnotationArray().length == 0) {
									EmbeddedAnnotation embeddedAnnotation = opmArtifact
											.addNewAnnotation();
									Property newProperty = embeddedAnnotation
											.addNewProperty();
									newProperty.addNewValue().set(
											XmlObject.Factory.parse("<content>"
													+ content + "</content>"));
									newProperty.setUri("artifact-content");

								} else {
									Property newProperty = opmArtifact
											.getAnnotationArray(0)
											.addNewProperty();
									newProperty.addNewValue().set(
											XmlObject.Factory.parse("<content>"
													+ content + "</content>"));
									newProperty.setUri("artifact-content");
								}
							} catch (XmlException e) {
								l.error("Set content annotation error.");
								l.error(e.toString());
							}

						}

						EmbeddedAnnotation entityAnnotation = getDataObjectAnnotation(
								connection, provenanceHistoryDataObjectID,
								inputBlockID);
						if (entityAnnotation != null) {
							opmArtifact.addNewAnnotation();
							opmArtifact
									.setAnnotationArray(
											opmArtifact.getAnnotationArray().length - 1,
											entityAnnotation);
						}
					}
				}

				res.close();
				getArtifactStmt.close();
			}

			l.info(opmArtifact.getId());
			l.info("Exiting getArtifactDataID() with success");

			return opmArtifact;

		} catch (SQLException e) {
			l.error("Exiting getArtifactDataID() with errors");
			l.error(e.toString());
			return null;
		} finally {

			if (getArtifactStmt != null) {
				getArtifactStmt.close();
				getArtifactStmt = null;
			}

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	private OpmGraphDocument getOPMGraphDocumentByArtifactID(
			Connection connection, List<Artifact> artifactList,
			String provenanceHistoryDataObjectID, Calendar boundaryTime,
			DetailEnumType.Enum informationDetailLevel) throws QueryException,
			SQLException {

		l.info("Entering getOPMGraphDocumentByArtifactID()");

		OpmGraphDocument opmGraphDoc = OpmGraphDocument.Factory.newInstance();
		OPMGraph opmGraph = opmGraphDoc.addNewOpmGraph();

		List<Artifact> OPMArtifacts = new ArrayList<Artifact>();
		List<Process> OPMProcesses = new ArrayList<Process>();
		List<WasDerivedFrom> OPMWasDerivedFrom = new ArrayList<WasDerivedFrom>();
		List<WasDerivedFrom> wasDerivedFromProcessingList = new ArrayList<WasDerivedFrom>();
		List<WasGeneratedBy> OPMWasGeneratedBy = new ArrayList<WasGeneratedBy>();
		List<WasGeneratedBy> wasGeneratedByProcessingList = new ArrayList<WasGeneratedBy>();

		for (Artifact artifact : artifactList) {
			OPMWasDerivedFrom.addAll(getOPMWasDerivedFrom(connection,
					artifact.getId(), provenanceHistoryDataObjectID,
					informationDetailLevel));

			OPMWasGeneratedBy.addAll(getOPMWasGeneratedBy(connection,
					artifact.getId(), provenanceHistoryDataObjectID,
					informationDetailLevel));
		}

		while (OPMWasDerivedFrom.size() > 0) {
			WasDerivedFrom wasDerivedFrom = OPMWasDerivedFrom.get(0);

			if (boundaryTime == null
					|| wasDerivedFrom.getTime().getNoEarlierThan()
							.equals(boundaryTime)
					|| wasDerivedFrom.getTime().getNoEarlierThan()
							.after(boundaryTime)) {
				if (visitedWasDerivedFrom.size() == 0
						|| visitedWasDerivedFrom.get(wasDerivedFrom.getCause()
								.getRef()) == null
						|| !visitedWasDerivedFrom.get(
								wasDerivedFrom.getCause().getRef()).equals(
								wasDerivedFrom.getEffect().getRef())) {

					if (visitedArtifacts.size() == 0
							|| visitedArtifacts.get(wasDerivedFrom.getCause()
									.getRef()) == null) {

						OPMArtifacts.add(getOPMArtifactByID(connection,
								wasDerivedFrom.getCause().getRef(),
								provenanceHistoryDataObjectID,
								informationDetailLevel));
						visitedArtifacts.put(
								wasDerivedFrom.getCause().getRef(),
								wasDerivedFrom.getCause().getRef());
					}

					wasDerivedFromProcessingList.add(wasDerivedFrom);
					visitedWasDerivedFrom.put(wasDerivedFrom.getCause()
							.getRef(), wasDerivedFrom.getEffect().getRef());
				}
			}

			OPMWasDerivedFrom.remove(0);
		}

		while (OPMWasGeneratedBy.size() > 0) {
			WasGeneratedBy wasGeneratedBy = OPMWasGeneratedBy.get(0);
			if (boundaryTime == null
					|| wasGeneratedBy.getTime().getNoEarlierThan()
							.equals(boundaryTime)
					|| wasGeneratedBy.getTime().getNoEarlierThan()
							.after(boundaryTime)) {

				if (visitedWasGeneratedBy.size() == 0
						|| visitedWasGeneratedBy.get(wasGeneratedBy.getCause()
								.getRef()) == null
						|| !visitedWasGeneratedBy.get(
								wasGeneratedBy.getCause().getRef()).equals(
								wasGeneratedBy.getEffect().getRef())) {

					if (visitedProcesses.size() == 0
							|| visitedProcesses.get(wasGeneratedBy.getCause()
									.getRef()) == null) {

						Processes processesByID = getOPMProcessesByID(
								connection, wasGeneratedBy.getCause().getRef(),
								provenanceHistoryDataObjectID,
								informationDetailLevel);

						if (processesByID != null) {
							for (Process p : processesByID.getProcessArray())
								OPMProcesses.add(p);
						}
						visitedProcesses.put(
								wasGeneratedBy.getCause().getRef(),
								wasGeneratedBy.getCause().getRef());
					}
					wasGeneratedByProcessingList.add(wasGeneratedBy);
					visitedWasGeneratedBy.put(wasGeneratedBy.getCause()
							.getRef(), wasGeneratedBy.getEffect().getRef());
				}
			}
			OPMWasGeneratedBy.remove(0);
		}

		if (OPMArtifacts.size() == 0) {
			/* Base case: do nothing */
		} else {
			/* Expand Graph for Artifacts within time range */
			l.info("getOPMGraphDocumentByArtifactID: " + OPMArtifacts.size());
			OpmGraphDocument opmGraphDocumentByArtifactID = getOPMGraphDocumentByArtifactID(
					connection, OPMArtifacts, provenanceHistoryDataObjectID,
					boundaryTime, informationDetailLevel);

			copyToNewGraph(opmGraphDocumentByArtifactID, opmGraphDoc);

			if (OPMArtifacts.size() > 0 && opmGraph.getArtifacts() == null)
				opmGraph.addNewArtifacts();
			for (int i = 0; i < OPMArtifacts.size(); i++) {
				Artifact a = OPMArtifacts.get(i);
				Artifact newArtifact = opmGraph.getArtifacts().addNewArtifact();
				setOPMArtifact(a, newArtifact);
			}
		}

		if (OPMProcesses.size() == 0) {
			/* Base case: do nothing */
		} else {
			if (OPMProcesses.size() == 0) {

			} else {
				/* Expand Graph for Artifacts within time range */

				OpmGraphDocument opmGraphDocumentByProcessID = getOPMGraphDocumentByProcessID(
						connection, OPMProcesses,
						provenanceHistoryDataObjectID, boundaryTime,
						informationDetailLevel);
				copyToNewGraph(opmGraphDocumentByProcessID, opmGraphDoc);

				if (OPMProcesses.size() > 0 && opmGraph.getProcesses() == null)
					opmGraph.addNewProcesses();
				for (int i = 0; i < OPMProcesses.size(); i++) {
					Process p = OPMProcesses.get(i);
					Process newProcess = opmGraph.getProcesses()
							.addNewProcess();
					setOPMProcess(p, newProcess);
				}
			}
		}

		if ((wasDerivedFromProcessingList.size() > 0)
				|| (wasGeneratedByProcessingList.size() > 0)) {
			if (opmGraph.getCausalDependencies() == null)
				opmGraph.addNewCausalDependencies();

			CausalDependencies causalDependencies = opmGraph
					.getCausalDependencies();
			for (WasDerivedFrom w : wasDerivedFromProcessingList) {
				causalDependencies.addNewWasDerivedFrom();
				int i = causalDependencies.getWasDerivedFromArray().length - 1;
				causalDependencies.setWasDerivedFromArray(i, w);
			}

			for (WasGeneratedBy w : wasGeneratedByProcessingList) {
				causalDependencies.addNewWasGeneratedBy();
				int i = causalDependencies.getWasGeneratedByArray().length - 1;
				causalDependencies.setWasGeneratedByArray(i, w);
			}

		}

		l.info("Exiting getOPMGraphDocumentByArtifactID() with success.");
		return opmGraphDoc;
	}

	private OpmGraphDocument getOPMGraphDocumentByProcessID(
			Connection connection, List<Process> processList,
			String provenanceHistoryDataObjectID, Calendar boundaryTime,
			DetailEnumType.Enum informationDetailLevel) throws QueryException,
			SQLException {
		l.info("Entering getOPMGraphDocumentByProcessID()");
		OpmGraphDocument opmGraphDoc = OpmGraphDocument.Factory.newInstance();
		OPMGraph opmGraph = opmGraphDoc.addNewOpmGraph();

		List<Artifact> OPMArtifacts = new ArrayList<Artifact>();
		List<Process> OPMProcesses = new ArrayList<Process>();
		List<Agent> OPMAgents = new ArrayList<Agent>();

		List<WasTriggeredBy> OPMWasTriggeredBy = new ArrayList<WasTriggeredBy>();
		List<WasTriggeredBy> wasTriggeredByProcessingList = new ArrayList<WasTriggeredBy>();
		List<Used> OPMUsed = new ArrayList<Used>();
		List<Used> usedProcessingList = new ArrayList<Used>();
		List<WasControlledBy> OPMWasControlledBy = new ArrayList<WasControlledBy>();
		List<WasControlledBy> wasControlledByProcessingList = new ArrayList<WasControlledBy>();

		for (Process process : processList) {
			OPMWasTriggeredBy.addAll(getOPMWasTriggeredBy(connection,
					process.getId(), provenanceHistoryDataObjectID,
					informationDetailLevel));

			OPMUsed.addAll(getOPMUsed(connection, process.getId(),
					provenanceHistoryDataObjectID, informationDetailLevel));

			OPMWasControlledBy.addAll(getOPMWasControlledBy(connection,
					process.getId(), provenanceHistoryDataObjectID,
					informationDetailLevel));
		}

		for (int i = 0; i < OPMWasTriggeredBy.size(); i++) {
			WasTriggeredBy wasTriggeredBy = OPMWasTriggeredBy.get(i);
			if (boundaryTime == null
					|| wasTriggeredBy.getTime().getNoEarlierThan()
							.equals(boundaryTime)
					|| wasTriggeredBy.getTime().getNoEarlierThan()
							.after(boundaryTime)) {

				if (visitedWasTriggeredBy.size() == 0
						|| visitedWasTriggeredBy.get(wasTriggeredBy.getCause()
								.getRef()) == null
						|| !visitedWasTriggeredBy.get(
								wasTriggeredBy.getCause().getRef()).equals(
								wasTriggeredBy.getEffect().getRef())) {

					if (visitedProcesses.size() == 0
							|| visitedProcesses.get(wasTriggeredBy.getCause()
									.getRef()) == null) {

						Processes processesByID = getOPMProcessesByID(
								connection, wasTriggeredBy.getCause().getRef(),
								provenanceHistoryDataObjectID,
								informationDetailLevel);

						if (processesByID != null) {
							for (Process p : processesByID.getProcessArray())
								OPMProcesses.add(p);
						}
						visitedProcesses.put(
								wasTriggeredBy.getCause().getRef(),
								wasTriggeredBy.getCause().getRef());
					}
					wasTriggeredByProcessingList.add(wasTriggeredBy);
					visitedWasTriggeredBy.put(wasTriggeredBy.getCause()
							.getRef(), wasTriggeredBy.getEffect().getRef());

				}
			}
		}

		while (OPMUsed.size() > 0) {
			Used used = OPMUsed.get(0);

			if (boundaryTime == null
					|| used.getTime().getNoEarlierThan().equals(boundaryTime)
					|| used.getTime().getNoEarlierThan().after(boundaryTime)) {

				if (visitedUsed.size() == 0
						|| visitedUsed.get(used.getCause().getRef()) == null
						|| !visitedUsed.get(used.getCause().getRef()).equals(
								used.getEffect().getRef())) {

					if (visitedArtifacts.size() == 0
							|| visitedArtifacts.get(used.getCause().getRef()) == null) {

						OPMArtifacts.add(getOPMArtifactByID(connection, used
								.getCause().getRef(),
								provenanceHistoryDataObjectID,
								informationDetailLevel));
						visitedArtifacts.put(used.getCause().getRef(), used
								.getCause().getRef());
					}
					usedProcessingList.add(used);
					visitedUsed.put(used.getCause().getRef(), used.getEffect()
							.getRef());

				}
			}
			OPMUsed.remove(0);

		}

		while (OPMWasControlledBy.size() > 0) {
			WasControlledBy wasControlledBy = OPMWasControlledBy.get(0);

			if (boundaryTime == null
					|| wasControlledBy.getStartTime().getNoEarlierThan()
							.equals(boundaryTime)
					|| wasControlledBy.getStartTime().getNoEarlierThan()
							.after(boundaryTime)) {

				if (visitedWasControlledBy.size() == 0
						|| visitedWasControlledBy.get(wasControlledBy
								.getCause().getRef()) == null
						|| !visitedWasControlledBy.get(
								wasControlledBy.getCause().getRef()).equals(
								wasControlledBy.getEffect().getRef())) {

					if (visitedAgents.size() == 0
							|| visitedAgents.get(wasControlledBy.getCause()
									.getRef()) == null) {

						OPMAgents.add(getOPMAgentByID(connection,
								wasControlledBy.getCause().getRef(),
								provenanceHistoryDataObjectID,
								informationDetailLevel));
						visitedAgents.put(wasControlledBy.getCause().getRef(),
								wasControlledBy.getCause().getRef());
					}
					wasControlledByProcessingList.add(wasControlledBy);
					visitedAgents.put(wasControlledBy.getCause().getRef(),
							wasControlledBy.getEffect().getRef());

				}
			}
			OPMWasControlledBy.remove(0);

		}

		if (OPMArtifacts.size() == 0) {
			/* Base case: do nothing */
		} else {
			/* Expand Graph for Artifacts within time range */
			l.info("getOPMGraphDocumentByArtifactID: " + OPMArtifacts.size());
			OpmGraphDocument opmGraphDocumentByArtifactID = getOPMGraphDocumentByArtifactID(
					connection, OPMArtifacts, provenanceHistoryDataObjectID,
					boundaryTime, informationDetailLevel);
			copyToNewGraph(opmGraphDocumentByArtifactID, opmGraphDoc);

			if (OPMArtifacts.size() > 0 && opmGraph.getArtifacts() == null)
				opmGraph.addNewArtifacts();
			for (int i = 0; i < OPMArtifacts.size(); i++) {
				Artifact a = OPMArtifacts.get(i);
				Artifact newArtifact = opmGraph.getArtifacts().addNewArtifact();
				setOPMArtifact(a, newArtifact);
			}
		}

		if (OPMProcesses.size() == 0) {
			/* Base case: do nothing */
		} else {
			if (OPMProcesses.size() == 0) {

			} else {
				/* Expand Graph for Artifacts within time range */

				OpmGraphDocument opmGraphDocumentByProcessID = getOPMGraphDocumentByProcessID(
						connection, OPMProcesses,
						provenanceHistoryDataObjectID, boundaryTime,
						informationDetailLevel);
				copyToNewGraph(opmGraphDocumentByProcessID, opmGraphDoc);

				if (OPMProcesses.size() > 0 && opmGraph.getProcesses() == null)
					opmGraph.addNewProcesses();
				for (int i = 0; i < OPMProcesses.size(); i++) {
					Process p = OPMProcesses.get(i);
					Process newProcess = opmGraph.getProcesses()
							.addNewProcess();
					setOPMProcess(p, newProcess);
				}
			}
		}

		if (OPMAgents.size() == 0) {
			/* Base case: do nothing */
		} else {
			if (OPMAgents.size() == 0) {

			} else {
				/* Expand Graph for Artifacts within time range */

				if (OPMAgents.size() > 0 && opmGraph.getAgents() == null)
					opmGraph.addNewAgents();
				for (int i = 0; i < OPMAgents.size(); i++) {
					Agent a = OPMAgents.get(i);
					Agent newAgent = opmGraph.getAgents().addNewAgent();
					setOPMAgent(a, newAgent);
				}
			}
		}

		if ((usedProcessingList.size() > 0)
				|| (wasTriggeredByProcessingList.size() > 0)
				|| (wasControlledByProcessingList.size() > 0)) {
			if (opmGraph.getCausalDependencies() == null)
				opmGraph.addNewCausalDependencies();
			CausalDependencies causalDependencies = opmGraph
					.getCausalDependencies();
			for (Used u : usedProcessingList) {
				causalDependencies.addNewUsed();
				int i = causalDependencies.getUsedArray().length - 1;
				causalDependencies.setUsedArray(i, u);
			}

			for (WasTriggeredBy w : wasTriggeredByProcessingList) {
				causalDependencies.addNewWasTriggeredBy();
				int i = causalDependencies.getWasTriggeredByArray().length - 1;
				causalDependencies.setWasTriggeredByArray(i, w);
			}

			for (WasControlledBy w : wasControlledByProcessingList) {
				causalDependencies.addNewWasControlledBy();
				int i = causalDependencies.getWasControlledByArray().length - 1;
				causalDependencies.setWasControlledByArray(i, w);
			}
		}

		l.info("Exiting getOPMGraphDocumentByProcessID() with success");
		return opmGraphDoc;
	}

	public OpmGraphDocument getOPMGraphDocumentByDataID(Connection connection,
			String dataObjectID, long timeRange,
			DetailEnumType.Enum informationDetailLevel) throws QueryException {

		OpmGraphDocument opmGraphDoc = OpmGraphDocument.Factory.newInstance();
		OPMGraph opmGraph = opmGraphDoc.addNewOpmGraph();

		try {
			PreparedStatement statement = connection
					.prepareStatement(GET_CACHE_PROVENANCE_HISTORY_GRAPH);
			statement.setString(1, dataObjectID);
			statement.setString(2, String.valueOf(timeRange));
			if (informationDetailLevel.equals(DetailEnumType.FINE)) {
				statement.setBoolean(3, true);
			} else {
				statement.setBoolean(3, false);
			}
			ResultSet resultSet = statement.executeQuery();

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
				} else {
					statement.close();
					resultSet.close();
				}
			} else {
				l.info("Query has not been cached.");
				isCached = false;
			}

			long beginTime = System.currentTimeMillis();
			Artifacts artifacts = opmGraph.addNewArtifacts();

			/* Initial Condition */
			Artifact initialArtifact = getOPMArtifactByID(connection,
					dataObjectID, dataObjectID, informationDetailLevel);
			l.info(initialArtifact);

			Calendar boundaryTime = Calendar.getInstance();
			String artifactID = null;
			if (initialArtifact.getId() != null) {
				if (initialArtifact.getId().startsWith(Common.BLOCK_IDENTIFIER)) {
					artifactID = initialArtifact.getId().replace(
							Common.BLOCK_IDENTIFIER, "");
					PreparedStatement getBlockEventTimeStmt = connection
							.prepareStatement(OPMSqlQuery.GET_BLOCK_EVENT_TIME_BY_ID);
					getBlockEventTimeStmt.setString(1, artifactID);
					ResultSet blockResultSet = getBlockEventTimeStmt
							.executeQuery();

					if (blockResultSet.next()) {
						Timestamp timestamp = blockResultSet.getTimestamp(1);
						if (timestamp != null) {
							l.info("Date to set: " + timestamp);
							boundaryTime.setTime(timestamp);
						} else {
							l.info("Time not set.");
						}
					}
					getBlockEventTimeStmt.close();
					blockResultSet.close();

				} else {
					final PreparedStatement getFileIDStmt;
					try {

						String fileID = dataObjectID.replace(
								Common.FILE_IDENTIFIER, "");
						getFileIDStmt = connection
								.prepareStatement(OPMSqlQuery.GET_FILE_BY_ID);
						getFileIDStmt.setString(1, fileID);
						ResultSet fileResultSet = getFileIDStmt.executeQuery();
						if (fileResultSet.next()) {
							artifactID = fileID;
							Date date = fileResultSet.getDate(3);
							if (date != null) {
								boundaryTime.setTime(date);
							} else {
								l.info("Time not set.");
							}
						}
						getFileIDStmt.close();
						fileResultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// no artifact found.
				l.info("Exiting getOPMGraphDocumentByDataID() with success: No initial artifact found.");
				return opmGraphDoc;
			}

			artifacts.addNewArtifact();
			artifacts.setArtifactArray(0, initialArtifact);
			visitedArtifacts.put(initialArtifact.getId(),
					initialArtifact.getId());

			/* Set time boundary */
			if (boundaryTime != null)
				l.info("Boundary time before adding on time range: "
						+ boundaryTime.getTime());

			if (timeRange != 0)
				boundaryTime.setTimeInMillis(boundaryTime.getTimeInMillis()
						- timeRange);
			else
				boundaryTime = null;

			if (boundaryTime != null)
				l.info("Boundary time after subtracting  time range: "
						+ boundaryTime.getTime());

			List<Artifact> OPMArtifacts = new ArrayList<Artifact>();
			List<Process> OPMProcesses = new ArrayList<Process>();
			List<WasDerivedFrom> OPMWasDerivedFrom = getOPMWasDerivedFrom(
					connection, dataObjectID, dataObjectID,
					informationDetailLevel);
			List<WasGeneratedBy> OPMWasGeneratedBy = getOPMWasGeneratedBy(
					connection, dataObjectID, dataObjectID,
					informationDetailLevel);

			if ((OPMWasGeneratedBy.size() > 0)
					|| (OPMWasDerivedFrom.size() > 0)) {
				if (opmGraph.getCausalDependencies() == null)
					opmGraph.addNewCausalDependencies();

				CausalDependencies causalDependencies = opmGraph
						.getCausalDependencies();

				for (WasDerivedFrom w : OPMWasDerivedFrom) {
					if (boundaryTime == null
							|| w.getTime().getNoEarlierThan()
									.equals(boundaryTime)
							|| w.getTime().getNoEarlierThan()
									.after(boundaryTime)) {

						if (visitedWasDerivedFrom.size() == 0
								|| visitedWasDerivedFrom.get(w.getCause()
										.getRef()) == null
								|| !visitedWasDerivedFrom.get(
										w.getCause().getRef()).equals(
										w.getEffect().getRef())) {

							causalDependencies.addNewWasDerivedFrom();
							int i = causalDependencies.getWasDerivedFromArray().length - 1;
							causalDependencies.setWasDerivedFromArray(i, w);
							if (visitedArtifacts.size() == 0
									|| visitedArtifacts.get(w.getCause()
											.getRef()) == null) {
								OPMArtifacts.add(getOPMArtifactByID(connection,
										w.getCause().getRef(), dataObjectID,
										informationDetailLevel));
								visitedArtifacts.put(w.getCause().getRef(), w
										.getCause().getRef());
							}

							visitedWasDerivedFrom.put(w.getCause().getRef(), w
									.getEffect().getRef());
						}
					}
				}

				for (WasGeneratedBy w : OPMWasGeneratedBy) {
					if (boundaryTime == null
							|| w.getTime().getNoEarlierThan()
									.equals(boundaryTime)
							|| w.getTime().getNoEarlierThan()
									.after(boundaryTime)) {

						if (visitedWasGeneratedBy.size() == 0
								|| visitedWasGeneratedBy.get(w.getCause()
										.getRef()) == null
								|| !visitedWasGeneratedBy.get(
										w.getCause().getRef()).equals(
										w.getEffect().getRef())) {

							visitedWasGeneratedBy.put(w.getEffect().getRef(), w
									.getCause().getRef());
							causalDependencies.addNewWasGeneratedBy();
							int i = causalDependencies.getWasGeneratedByArray().length - 1;
							causalDependencies.setWasGeneratedByArray(i, w);
							if (visitedProcesses.size() == 0
									|| visitedProcesses.get(w.getCause()
											.getRef()) == null) {

								Processes processesByID = getOPMProcessesByID(
										connection, w.getCause().getRef(),
										dataObjectID, informationDetailLevel);

								if (processesByID != null) {
									for (Process p : processesByID
											.getProcessArray())
										OPMProcesses.add(p);
								}

								visitedProcesses.put(w.getCause().getRef(), w
										.getCause().getRef());
							}
						}
					}
				}
			}

			if (OPMArtifacts.size() == 0) {
				/* Base case */
			} else {
				/* Expand Graph for Artifacts within time range */

				OpmGraphDocument opmGraphDocumentByArtifactID = getOPMGraphDocumentByArtifactID(
						connection, OPMArtifacts, dataObjectID, boundaryTime,
						informationDetailLevel);

				copyToNewGraph(opmGraphDocumentByArtifactID, opmGraphDoc);

				if (OPMArtifacts.size() > 0 && opmGraph.getArtifacts() == null)
					opmGraph.addNewArtifacts();
				for (int i = 0; i < OPMArtifacts.size(); i++) {
					Artifact a = OPMArtifacts.get(i);
					Artifact newArtifact = opmGraph.getArtifacts()
							.addNewArtifact();
					setOPMArtifact(a, newArtifact);
				}
			}

			if (OPMProcesses.size() == 0) {
				/* Base case */
			} else {
				/* Expand Graph for Artifacts within time range */
				l.info("getOPMGraphDocumentByDataID: " + OPMProcesses.size());

				OpmGraphDocument opmGraphDocumentByProcessID = getOPMGraphDocumentByProcessID(
						connection, OPMProcesses, dataObjectID, boundaryTime,
						informationDetailLevel);

				copyToNewGraph(opmGraphDocumentByProcessID, opmGraphDoc);

				if (OPMProcesses.size() > 0 && opmGraph.getProcesses() == null)
					opmGraph.addNewProcesses();
				for (int i = 0; i < OPMProcesses.size(); i++) {
					Process p = OPMProcesses.get(i);
					Process newProcess = opmGraph.getProcesses()
							.addNewProcess();
					setOPMProcess(p, newProcess);
				}

			}

			long endTime = System.currentTimeMillis();

			long generationTime = endTime - beginTime;
			l.info(opmGraphDoc);

			if (!isCached) {
				// graph is not cached
				PreparedStatement getCountStatement = connection
						.prepareStatement(GET_CACHE_COUNT);

				ResultSet rs = getCountStatement.executeQuery();
				if (rs.next()) {
					if (rs.getInt(1) == MAX_CACHE_ENTRIES) {
						statement = connection
								.prepareStatement(GET_GRAPH_TO_DELETE);
						statement.execute();
						if (rs.next()) {
							rs.deleteRow();
						}
						statement.close();
					}

					statement = connection.prepareStatement(NEW_CACHE_GRAPH);
					statement.setString(1, dataObjectID);
					statement.setString(2, opmGraphDoc.xmlText());
					statement.setString(3, String.valueOf(generationTime));
					statement.setTimestamp(4, new java.sql.Timestamp(Calendar
							.getInstance().getTimeInMillis()));
					statement.setString(5, String.valueOf(timeRange));
					if (informationDetailLevel == DetailEnumType.FINE) {
						statement.setBoolean(6, true);
					} else {
						statement.setBoolean(6, false);
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
			l.error("Exiting getOPMGraphDocumentByDataID() with SQL errors");
			l.error(e.toString());
			return opmGraphDoc;

		} catch (XmlException e) {
			l.error("Exiting getOPMGraphDocumentByDataID() with XML parse errors");
			l.error(e.toString());
			return opmGraphDoc;

		}

		l.info("Exiting getOPMGraphDocumentByDataID() with success");
		return opmGraphDoc;

	}

	/* This function retrieves data lifecycle annotations by event id. */
	public static EmbeddedAnnotation getDataLifecycleAnnotation(
			Connection connection, String eventID) throws SQLException {
		assert (connection != null);
		assert (eventID != null);
		l.info("Entering getDataLifecycleAnnotation");

		PreparedStatement dataLifecycleAnnotationStmt = null;
		ResultSet res = null;

		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			dataLifecycleAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_LIFECYCLE_ANNOTATIONS_BY_ID);
			dataLifecycleAnnotationStmt.setString(1, eventID);

			res = dataLifecycleAnnotationStmt.executeQuery();

			while (res.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("data-lifecycle-annotation/" + res.getString(5)
						+ "/" + res.getString(3));
				property.setValue(XmlObject.Factory.parse(res.getString(4)));
				embeddedAnnotation
						.setId(Common.DATA_LIFECYCLE_ANNOTATION_IDENTIFIER
								+ res.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			dataLifecycleAnnotationStmt.close();
			res.close();
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

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/* This function retrieves execution level entity annotations by entity id. */
	public static EmbeddedAnnotation getExeEntityAnnotation(
			Connection connection, String dataObjectID, String entityID)
			throws SQLException {
		assert (connection != null);
		assert (dataObjectID != null);
		assert (entityID != null);
		l.info("Entering getEntityAnnotation()");

		PreparedStatement entityAnnotationStmt = null;
		ResultSet res = null;
		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			entityAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_EXE_ENTITY_ANNOTATIONS_BY_ID);
			entityAnnotationStmt.setString(1, entityID);

			res = entityAnnotationStmt.executeQuery();

			while (res.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("process-annotation/" + res.getString(5) + "/"
						+ res.getString(3));
				property.setValue(XmlObject.Factory.parse(res.getString(4)));
				embeddedAnnotation.setId(Common.PROCESS_ANNOTATION_IDENTIFIER
						+ res.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			entityAnnotationStmt.close();
			res.close();
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

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/* This function retrieves registry level entity annotations by entity id. */
	public static EmbeddedAnnotation getRegEntityAnnotation(
			Connection connection, String dataObjectID, String entityID)
			throws SQLException {
		assert (connection != null);
		assert (dataObjectID != null);
		assert (entityID != null);
		l.info("Entering getRegEntityAnnotation()");

		PreparedStatement entityAnnotationStmt = null;
		ResultSet res = null;

		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			entityAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_REG_ENTITY_ANNOTATIONS_BY_ID);
			entityAnnotationStmt.setString(1, entityID);

			res = entityAnnotationStmt.executeQuery();

			while (res.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("process-annotation/" + res.getString(5) + "/"
						+ res.getString(3));
				property.setValue(XmlObject.Factory.parse(res.getString(4)));
				embeddedAnnotation.setId(Common.PROCESS_ANNOTATION_IDENTIFIER
						+ res.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			entityAnnotationStmt.close();
			res.close();
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

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/* This function retrieves invocation annotations by entity id. */
	public static EmbeddedAnnotation getInvocationAnnotation(
			Connection connection, String dataObjectID, String invocationID)
			throws SQLException {
		assert (connection != null);
		assert (dataObjectID != null);
		assert (invocationID != null);
		l.info("Entering getInvocationAnnotation()");

		PreparedStatement invocationAnnotationStmt = null;
		ResultSet res = null;

		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			invocationAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_INVOCATION_ANNOTATIONS_BY_ID);
			invocationAnnotationStmt.setString(1, invocationID);

			res = invocationAnnotationStmt.executeQuery();

			while (res.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("invocation-annotation/" + res.getString(5)
						+ "/" + res.getString(3));
				property.setValue(XmlObject.Factory.parse(res.getString(4)));
				embeddedAnnotation
						.setId(Common.INVOCATION_ANNOTATION_IDENTIFIER
								+ res.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			res.close();
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

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}

	/* This function retrieves data object annotations by data object id. */
	public static EmbeddedAnnotation getDataObjectAnnotation(
			Connection connection, String dataObjectID, String objectID)
			throws SQLException {
		assert (connection != null);
		assert (dataObjectID != null);
		assert (objectID != null);
		l.info("Entering getDataObjectAnnotation()");

		PreparedStatement dataObjectAnnotationStmt = null;
		ResultSet res = null;
		try {

			EmbeddedAnnotation embeddedAnnotation = EmbeddedAnnotation.Factory
					.newInstance();

			dataObjectAnnotationStmt = connection
					.prepareStatement(OPMSqlQuery.GET_DATA_OBJECT_ANNOTATIONS_BY_ID);
			dataObjectAnnotationStmt.setString(1, objectID);

			res = dataObjectAnnotationStmt.executeQuery();

			while (res.next()) {

				Property property = embeddedAnnotation.addNewProperty();
				property.setUri("artifact-annotation/" + res.getString(5) + "/"
						+ res.getString(3));
				property.setValue(XmlObject.Factory.parse(res.getString(4)));
				embeddedAnnotation.setId(Common.ARTIFACT_ANNOTATION_IDENTIFIER
						+ res.getString(1));
			}

			if (!embeddedAnnotation.isSetId()) {
				embeddedAnnotation = null;
			}

			dataObjectAnnotationStmt.close();
			res.close();
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

			if (res != null) {
				res.close();
				res = null;
			}
		}
	}
}