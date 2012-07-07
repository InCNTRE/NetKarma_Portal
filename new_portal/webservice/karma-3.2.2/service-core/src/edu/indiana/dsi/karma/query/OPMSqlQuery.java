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
# File:  OPMSqlQuery.java
# Description:  Contains formed SQL queries in support of provenance
# graph construction.
#
# -----------------------------------------------------------------
# 
 */

/*
 * Author : Girish Subramanian (subramag@umail.iu.edu)
 * Modified: You-Wei Cheah (yocheah@indiana.edu)
 */
package edu.indiana.dsi.karma.query;

public class OPMSqlQuery {

	/*
	 * Fetch all the entities from the entity table for the given instance id
	 * 
	 * Changed to context_workflow_uri from entity_uri for v3.1
	 */

	public static final String GET_ENTITIES_BY_CONTEXT_WORKFLOW_URI = "SELECT * FROM exe_entity WHERE context_workflow_uri = ? OR entity_uri = ?";

	public static final String GET_ENTITY_CONTROLLER_BY_ID = "SELECT DISTINCT entity_uri AS agent FROM exe_entity WHERE e.entity_id = ?";

	public static final String GET_USER_CONTROLLER_BY_ID = "SELECT * FROM reg_personnel r WHERE r.personnel_id = ?";

	public static final String GET_USER_BEHALF_ID = "SELECT DISTINCT user_id FROM exe_behalf WHERE entity_id = ?";

	public static final String GET_AUTHORSHIP_BY_ENTITY_ID = "SELECT role FROM reg_entity_authorship WHERE author_id = ?";

	public static final String GET_USER_BEHALF_AGENT_BY_ENTITY_URI = "SELECT b.user_id FROM exe_invocation i, exe_behalf b, exe_entity e "
			+ "WHERE i.invoker_id = b.entity_id "
			+ "AND i.invoker_id = e.entity_id "
			+ "AND e.context_workflow_uri = ?";

	public static final String GET_USER_INVOCATION_BY_ENTITY_URI = "SELECT i.invoker_id FROM exe_invocation as i, exe_entity as e "
			+ "WHERE (e.context_workflow_uri = ? "
			+ "OR (e.entity_uri = ? AND e.context_workflow_uri is NULL)) "
			+ "AND e.entity_id = i.invokee_id "
			+ "AND i.invocation_type = 'CONTROL'";

	public static final String GET_DATA_FILES_PRODUCED = "SELECT d.file_uri, d.size, d.file_id "
			+ "FROM exe_file d, exe_data_lifecycle p, exe_entity e "
			+ "WHERE p.data_id = d.file_id AND "
			+ "p.actor_id = e.entity_id AND p.event_action='PRODUCE' AND e.context_workflow_uri = ?";

	public static final String GET_DATA_BLOCKS_PRODUCED = "SELECT d.block_id, d.size, d.block_content "
			+ "FROM exe_block d, exe_data_lifecycle p, exe_entity e "
			+ "WHERE p.data_id = d.block_id AND "
			+ "p.actor_id = e.entity_id AND p.event_action='PRODUCE' AND e.context_workflow_uri = ?";

	public static final String GET_DATA_COLLECTIONS_PRODUCED = "SELECT d.collection_id, d.collection_uri "
			+ "FROM exe_data_collection d, exe_data_lifecycle p, exe_entity e "
			+ "WHERE p.data_id = d.collection_id AND "
			+ "p.actor_id = e.entity_id AND p.event_action='PRODUCE' AND e.context_workflow_uri = ?";

	public static final String GET_DATA_FILES_CONSUMED = "SELECT d.file_uri, d.size, d.file_id "
			+ "FROM exe_file d, exe_data_lifecycle c, exe_entity e "
			+ "WHERE d.file_id = c.data_id AND "
			+ "c.actor_id = e.entity_id AND c.event_action='CONSUME' AND e.context_workflow_uri = ?";

	public static final String GET_DATA_BLOCKS_CONSUMED = "SELECT d.block_id, d.size, d.block_content "
			+ "FROM exe_block d, exe_data_lifecycle c, exe_entity e "
			+ "WHERE d.block_id = c.data_id AND "
			+ "c.actor_id = e.entity_id AND c.event_action='CONSUME' AND e.context_workflow_uri = ?";

	public static final String GET_DATA_COLLECTIONS_CONSUMED = "SELECT d.collection_id, d.collection_uri "
			+ "FROM exe_data_collection d, exe_data_lifecycle c, exe_entity e "
			+ "WHERE d.collection_id = c.data_id AND "
			+ "c.actor_id = e.entity_id AND c.event_action='CONSUME' AND e.context_workflow_uri = ?";

	public static final String GET_OPM_FILE_USED = "SELECT e.entity_id, c.data_id, d.file_uri, c.event_time, c.event_id, c.role "
			+ "FROM exe_entity e, exe_data_lifecycle c, exe_file d "
			+ "WHERE e.entity_id = c.actor_id AND c.event_action='CONSUME' AND "
			+ "c.data_id = d.file_id AND " + "e.context_workflow_uri = ?";

	public static final String GET_OPM_BLOCK_USED = "SELECT e.entity_id, c.data_id, d.block_id, c.event_time, c.event_id, c.role "
			+ "FROM exe_entity e, exe_data_lifecycle c, exe_block d "
			+ "WHERE e.entity_id = c.actor_id AND c.event_action='CONSUME' AND "
			+ "c.data_id = d.block_id AND " + "e.context_workflow_uri = ?";

	public static final String GET_OPM_COLLECTION_USED = "SELECT e.entity_id, c.data_id, d.collection_id, c.event_time, c.event_id, c.role "
			+ "FROM exe_entity e, exe_data_lifecycle c, exe_data_collection d "
			+ "WHERE e.entity_id = c.actor_id AND c.event_action='CONSUME' AND "
			+ "c.data_id = d.collection_id AND " + "e.context_workflow_uri = ?";

	public static final String GET_OPM_FILE_WAS_GENERATED_BY = "SELECT e.entity_id, p.data_id, d.file_uri, p.event_time, p.event_id, p.role "
			+ "FROM exe_entity e, exe_data_lifecycle p, exe_file d "
			+ "WHERE e.entity_id = p.actor_id AND p.event_action='PRODUCE' AND "
			+ "p.data_id = d.file_id AND " + "e.context_workflow_uri = ?";

	public static final String GET_OPM_BLOCK_WAS_GENERATED_BY = "SELECT e.entity_id, p.data_id, d.block_id, p.event_time, p.event_id, p.role "
			+ "FROM exe_entity e, exe_data_lifecycle p, exe_block d "
			+ "WHERE e.entity_id = p.actor_id AND p.event_action='PRODUCE' AND "
			+ "p.data_id = d.block_id AND " + "e.context_workflow_uri = ?";

	public static final String GET_OPM_COLLECTION_WAS_GENERATED_BY = "SELECT e.entity_id, p.data_id, d.collection_id, p.event_time, p.event_id, p.role "
			+ "FROM exe_entity e, exe_data_lifecycle p, exe_data_collection d "
			+ "WHERE e.entity_id = p.actor_id AND p.event_action='PRODUCE' AND "
			+ "p.data_id = d.collection_id AND " + "e.context_workflow_uri = ?";

	public static final String GET_OPM_WAS_DERIVED_FROM = "SELECT p.data_id AS produced_id , p.event_time AS production_time, "
			+ "c.data_id AS consumed_id, c.event_time AS consumption_time, c.event_id AS consume_event, p.event_id AS produce_event "
			+ "FROM exe_data_lifecycle c, exe_data_lifecycle p, exe_entity e "
			+ "WHERE c.actor_id = p.actor_id AND c.actor_id = e.entity_id AND "
			+ "c.event_action='CONSUME' AND p.event_action='PRODUCE' AND e.context_workflow_uri = ?";

	public final static String GET_OPM_WAS_TRIGGERED_BY_WITH_ARTIFACTS = "SELECT DISTINCT c.actor_id AS effect , p.actor_id AS cause, "
			+ "c.event_time AS noLaterThan, p.event_time AS noEarlierThan, c.event_id AS consumed_event_id, p.event_id AS produced_event_id "
			+ "FROM exe_data_lifecycle c, exe_data_lifecycle p "
			+ "WHERE c.data_id = p.data_id "
			+ "AND c.actor_id IN (SELECT entity_id FROM exe_entity WHERE context_workflow_uri = ?) AND c.event_action='CONSUME' "
			+ "AND p.actor_id IN (SELECT entity_id FROM exe_entity WHERE context_workflow_uri = ?) AND p.event_action='PRODUCE'";

	public final static String GET_OPM_WAS_TRIGGERED_BY_WITHOUT_ARTIFACTS = "SELECT DISTINCT e2.entity_id AS effect , e1.entity_id AS cause, "
			+ "i.execution_end_time AS noLaterThan, i.invocation_start_time AS noEarlierThan, invocation_id "
			+ "FROM exe_invocation i, exe_entity e1, exe_entity e2 "
			+ "WHERE i.invoker_id = e1.entity_id "
			+ "AND  i.invokee_id = e2.entity_id "
			+ "AND i.invocation_type = 'INVOKE' "
			+ "AND i.invokee_id != i.invoker_id "
			+ "AND  e2.context_workflow_uri = ?";

	public final static String GET_OPM_WAS_CONTROLLED_BY_URI = "SELECT DISTINCT p.personnel_id AS controller, e.entity_id AS process, "
			+ "i.invocation_start_time AS noEarlierThan, i.execution_end_time AS noLaterThan "
			+ "FROM exe_behalf b, reg_personnel p, exe_entity e, exe_invocation i "
			+ "WHERE b.user_id = p.personnel_id "
			+ "AND e.entity_id = i.invoker_id "
			+ "AND  b.entity_id = e.entity_id "
			+ "AND e.entity_id IN (SELECT entity_id FROM exe_entity WHERE context_workflow_uri = ?)";

	public final static String GET_OPM_WAS_CONTROLLED_BY_URI_WITH_CONTROL_INVOCATION = "SELECT i.invoker_id AS controller, i.invokee_id AS process, "
			+ "i.invocation_start_time AS noEarlierThan, i.execution_end_time AS noLaterThan "
			+ "FROM exe_invocation i, exe_entity e "
			+ "WHERE invocation_type = 'CONTROL'"
			+ "AND e.entity_id = i.invokee_id " 
			+ "AND (e.context_workflow_uri = ? "
			+ "OR (e.entity_uri = ? "
			+ "AND e.context_workflow_uri is NULL))";

	public final static String GET_OPM_WAS_CONTROLLED_BY_ID = "SELECT DISTINCT p.personnel_id AS controller, e.entity_id AS process, "
			+ "i.invocation_start_time AS noEarlierThan, i.execution_end_time AS noLaterThan "
			+ "FROM exe_behalf b, reg_personnel p, exe_entity e, exe_invocation i "
			+ "WHERE b.user_id = p.personnel_id "
			+ "AND e.entity_id = i.invoker_id "
			+ "AND b.entity_id = e.entity_id " 
			+ "AND e.entity_id = ?";

	public final static String GET_OPM_WAS_CONTROLLED_BY_ID_WITH_CONTROL_INVOCATION = "SELECT i.invoker_id AS controller, i.invokee_id AS process, "
			+ "i.invocation_start_time AS noEarlierThan, i.execution_end_time AS noLaterThan "
			+ "FROM exe_invocation i, exe_entity e "
			+ "WHERE invocation_type = 'CONTROL'"
			+ "AND e.entity_id = i.invokee_id " 
			+ "AND e.entity_id = ?";

	public final static String GET_ARTIFACT_PRODUCED_TIME = "SELECT min(event_time) "
			+ "FROM exe_data_lifecycle "
			+ "WHERE data_id = ? "
			+ "AND event_action = 'PRODUCE'";

	public final static String GET_ARTIFACT_USED_TIME = "SELECT min(event_time) "
			+ "FROM exe_data_lifecycle "
			+ "WHERE data_id = ? "
			+ "AND event_action = 'CONSUME'";

	public final static String GET_FILE_URI = "SELECT file_uri, size "
			+ "FROM exe_file " + "WHERE file_id = ?";

	public final static String GET_BLOCK_ID = "SELECT block_id, size "
			+ "FROM exe_block " + "WHERE block_id = ?";

	public final static String GET_COLLECTION_URI = "SELECT collection_uri "
			+ "FROM exe_data_collection " + "WHERE collection_id = ?";

	public final static String GET_COUNT_ENTITIES_BY_CONTEXT_WORKFLOW_URI = "SELECT count(*) FROM exe_entity WHERE context_workflow_uri = ?";

	public final static String GET_COUNT_ARTIFACTS_USED = "SELECT count(*) "
			+ "FROM exe_data_lifecycle d, exe_entity e, exe_file f "
			+ "WHERE d.data_id = f.file_id " + "AND d.event_action != 'NULL' "
			+ "AND e.entity_id = d.actor_id "
			+ "AND e.context_workflow_uri = ?";

	public static final String GET_OPM_DATA_FILE_WAS_GENERATED_BY = "SELECT e.entity_id, p.data_id, d.file_uri, p.event_time, p.event_id, p.role "
			+ "FROM exe_entity e, exe_data_lifecycle p, exe_file d "
			+ "WHERE e.entity_id = p.actor_id AND p.event_action='PRODUCE' AND "
			+ "p.data_id = ? AND d.file_id = p.data_id";

	public static final String GET_OPM_DATA_BLOCK_WAS_GENERATED_BY = "SELECT e.entity_id, p.data_id, d.block_id, p.event_time, p.event_id, p.role "
			+ "FROM exe_entity e, exe_data_lifecycle p, exe_block d "
			+ "WHERE e.entity_id = p.actor_id AND p.event_action='PRODUCE' AND "
			+ "p.data_id = d.block_id AND p.data_id = ?";

	public static final String GET_OPM_DATA_WAS_DERIVED_FROM = "SELECT p.data_id AS produced_id, p.event_time AS production_time, "
			+ "c.data_id AS consumed_id, c.event_time AS consumption_time, c.event_id AS consumed_event_id, p.event_id AS produced_event_id "
			+ "FROM exe_data_lifecycle c, exe_data_lifecycle p, exe_entity e "
			+ "WHERE c.actor_id = p.actor_id AND c.actor_id = e.entity_id AND "
			+ "c.event_action='CONSUME' AND p.event_action='PRODUCE' AND p.data_id = ?";

	public final static String GET_OPM_DATA_WAS_TRIGGERED_BY_WITH_ARTIFACTS = "SELECT DISTINCT c.actor_id AS effect, p.actor_id AS cause, "
			+ "c.event_time as noLaterThan, p.event_time as noEarlierThan, c.event_id AS consumed_event_id, p.event_id AS produced_event_id "
			+ "FROM exe_data_lifecycle c, exe_data_lifecycle p "
			+ "WHERE c.data_id = p.data_id "
			+ "AND c.event_action='CONSUME' "
			+ "AND p.event_action='PRODUCE' " + "AND c.actor_id = ?";

	public final static String GET_OPM_DATA_WAS_TRIGGERED_BY_WITHOUT_ARTIFACTS = "SELECT DISTINCT e2.entity_id AS effect , e1.entity_id AS cause, "
			+ "i.execution_end_time as noLaterThan, i.invocation_start_time as noEarlierThan, invocation_id "
			+ "FROM exe_invocation i, exe_entity e1, exe_entity e2 "
			+ "WHERE i.invoker_id = e1.entity_id "
			+ "AND i.invokee_id = e2.entity_id "
			+ "AND i.invokee_id != i.invoker_id "
			+ "AND i.invocation_type = 'INVOKE' " + "AND  i.invokee_id = ? ";

	public static final String GET_OPM_DATA_FILE_USED = "SELECT e.entity_id, c.data_id, d.file_uri, c.event_time, c.event_id, c.role "
			+ "FROM exe_entity e, exe_data_lifecycle c, exe_file d "
			+ "WHERE e.entity_id = c.actor_id "
			+ "AND c.event_action='CONSUME' "
			+ "AND c.data_id = d.file_id "
			+ "AND e.entity_id = ? ";

	public static final String GET_OPM_DATA_BLOCK_USED = "SELECT e.entity_id, c.data_id, d.block_id, c.event_time, c.event_id, c.role "
			+ "FROM exe_entity e, exe_data_lifecycle c, exe_block d "
			+ "WHERE e.entity_id = c.actor_id "
			+ "AND c.event_action='CONSUME' AND "
			+ "c.data_id = d.block_id "
			+ "AND e.entity_id = ?";

	public final static String GET_FILE_BY_ID = "SELECT file_uri, size, creation_date "
			+ "FROM exe_file " + "WHERE file_id = ?";

	public final static String GET_BLOCK_BY_ID = "SELECT block_id, size, block_content "
			+ "FROM exe_block " + "WHERE block_id = ?";

	public static final String GET_EXE_ENTITIES_BY_ID = "SELECT * FROM exe_entity WHERE entity_id = ?";

	public static final String GET_REG_ENTITIES_BY_ID = "SELECT * FROM reg_entity WHERE entity_id = ?";

	public static final String GET_OBJECT_TYPE_BY_ID = "SELECT object_type FROM exe_data_object WHERE object_id = ?";

	public static final String GET_DATA_LIFECYCLE_ANNOTATIONS_BY_ID = "SELECT * FROM exe_data_lifecycle_annotation WHERE event_id = ? ";

	public static final String GET_DATA_OBJECT_ANNOTATIONS_BY_ID = "SELECT * FROM exe_data_object_annotation WHERE object_id = ? ";

	public static final String GET_DATA_TRANSFORM_ANNOTATIONS_BY_ID = "SELECT * FROM exe_data_transform_annotation WHERE transform_id = ? ";

	public static final String GET_DATA_TRANSFER_ANNOTATIONS_BY_ID = "SELECT * FROM exe_data_transfer_annotation WHERE transfer_id = ? ";

	public static final String GET_EXE_ENTITY_ANNOTATIONS_BY_ID = "SELECT * FROM exe_entity_annotation WHERE entity_id = ?";

	public static final String GET_REG_ENTITY_ANNOTATIONS_BY_ID = "SELECT * FROM reg_entity_annotation WHERE entity_id = ?";

	public static final String GET_INVOCATION_ANNOTATIONS_BY_ID = "SELECT * FROM exe_invocation_annotation WHERE invocation_id = ?";

	public static final String GET_BLOCK_EVENT_TIME_BY_ID = "(SELECT event_time FROM exe_data_lifecycle c, exe_block b WHERE b.block_id = ? AND b.block_id = c.data_id) ORDER BY event_time ASC";
}
