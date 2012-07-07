-- ------------------------------------------------------------------
-- MySQL Database Schema for Karma 3
--
--
-- Version:
--          3.2.1
--
-- Revision:
--          Jan. 5, 2012
--
-- Authors:
--          Yiming Sun (yimsun@cs.indiana.edu)
--          Beth Plale (plale@cs.indiana.edu)
--          Prajakta Purohit (pppurohi@indiana.edu)
--          Devarshi Ghoshal (dghoshal@indiana.edu)
--          You-Wei Cheah (yocheah@cs.indiana.edu)
--
-- Modification History:
-- Stored procedure to add synchronization based on the object
-- being added to the Karma DB. This adds support for multi-service,
-- single-DB model to Karma. 
--
-- Revision:
--          Apr. 07, 2011
--
-- Parameters:
--
-- 	lockOp		: Lock Operation, 1 = acquire, 0 = release 
-- 	lockTimeOut	: Lock Time-out
-- 	p_entity_id	: Unique identifier of the object, to create the lock
-- 	status		: Output status of the lock operation
--
-- Authors:
--			Beth Plale (plale@cs.indiana.edu)  
--			Scott Jensen (scjensen@indiana.edu)  
--			Devarshi Ghoshal (dghoshal@indiana.edu)
-- ------------------------------------------------------------------

SET foreign_key_checks=0;

DROP TABLE IF EXISTS schema_version;
CREATE TABLE schema_version (
  version                      VARCHAR(63) NOT NULL
) ENGINE=InnoDB;

INSERT INTO schema_version(version) VALUES ("3.2.1");


-- ======================================= registry level tables below ========================
DROP TABLE IF EXISTS reg_personnel;
CREATE TABLE reg_personnel (
   personnel_id                 BIGINT NOT NULL AUTO_INCREMENT,                   -- internal ID
   name                         VARCHAR(127) NULL,                                -- name of the person/organization
--   personnel_type               VARCHAR(31) NOT NULL,                             -- ORGANIZATION or PERSON
   dn                           VARCHAR(256) NOT NULL,                            -- a DN identifying the person or the organization
   affiliation                  VARCHAR(31) NULL,                                 -- optional affiliation
   email                        VARCHAR(63) NULL,                                 -- optional email                       

   PRIMARY KEY (personnel_id),
   INDEX (name),
--   INDEX (personnel_type),
   INDEX (dn)
--   INDEX (affiliation)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_entity;
CREATE TABLE reg_entity (
  entity_id                            BIGINT NOT NULL AUTO_INCREMENT,            -- internal ID of this entity
  entity_type                          VARCHAR(15) NOT NULL,                      -- type of the entity: WORKFLOW, SERVICE, METHOD, USER
  entity_subtype                       VARCHAR(15) NOT NULL,                      -- subtype of the entity: 
  name                                 VARCHAR(375) NOT NULL,                     -- a name of the entity, e.g. URI
  version                              VARCHAR(31) NULL,                          -- optional version information for the entity
  creation_time                        DATETIME NOT NULL,                         -- time the entity was created

  PRIMARY KEY (entity_id),
  INDEX (entity_type),
  INDEX (entity_subtype),
  INDEX (name),
  INDEX (version)
  
) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_entity_membership;
CREATE TABLE reg_entity_membership (
  membership_id                        BIGINT NOT NULL AUTO_INCREMENT,            -- internal ID of the membership
  aggregation_id                       BIGINT NOT NULL,                           -- foreign key to reg_entity.entity_id
  member_id                            BIGINT NOT NULL,                           -- foreign key to reg_entity.entity_id
  membership_type                      VARCHAR(31) NOT NULL,                      -- type of membership, e.g. COLLECTION_CONSTITUENT, METHOD_OF_PROCESS
  
  PRIMARY KEY (membership_id),
  FOREIGN KEY (aggregation_id) REFERENCES reg_entity(entity_id),
  FOREIGN KEY (member_id) REFERENCES reg_entity(entity_id),
  INDEX (membership_type)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS reg_entity_authorship;
CREATE TABLE reg_entity_authorship (
  authorship_id                       BIGINT NOT NULL AUTO_INCREMENT,            -- authorship internal ID
  author_id                           BIGINT NOT NULL,                           -- foreign key to reg_personnel.personnel_id
  entity_id                           BIGINT NOT NULL,                           -- foreign key to reg_entity.entity_id
  role                                VARCHAR(15) NOT NULL,                      -- one of AUTHOR, CONTRIBUTOR, OWNER
  
  PRIMARY KEY (authorship_id),
  INDEX (role),
  FOREIGN KEY (author_id) REFERENCES reg_personnel(personnel_id),
  FOREIGN KEY (entity_id) REFERENCES reg_entity(entity_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS reg_data_object;
CREATE TABLE reg_data_object (
  object_id                           BIGINT NOT NULL AUTO_INCREMENT,             -- internal ID of the data object
  object_name                         VARCHAR(375) NOT NULL,
  object_type                         VARCHAR(15) NOT NULL,                       -- FILE, BLOCK, COLLECTION
--  object_collection_internal_id       BIGINT NULL,
  PRIMARY KEY (object_id),
  INDEX (object_name),
  INDEX (object_type)
--  FOREIGN KEY object_collection_internal_id REFERENCES reg_data_object(object_internal_id)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_data_object_membership;
CREATE TABLE reg_data_object_membership (
  membership_id                      BIGINT NOT NULL AUTO_INCREMENT,             -- internal ID of the data membership
  aggregation_id                     BIGINT NOT NULL,                            -- foreign key to reg_data_object.object_id
  member_id                          BIGINT NOT NULL,                            -- foriegn key to reg_data_object.object_id
  membership_type                    VARCHAR(31) NOT NULL,                       -- membership type, e.g. PARAMETER_GROUP
  
  PRIMARY KEY (membership_id),
  FOREIGN KEY (aggregation_id) REFERENCES reg_data_object(object_id),
  FOREIGN KEY (member_id) REFERENCES reg_data_object(object_id),
  INDEX (membership_type)
) ENGINE=InnoDB;



DROP TABLE IF EXISTS reg_data_object_lifecycle;
CREATE TABLE reg_data_object_lifecycle (
  lifecycle_id                        BIGINT NOT NULL AUTO_INCREMENT,             -- internal ID
  object_id                           BIGINT NOT NULL,                            -- foreign key to reg_data_object.object_id
  entity_id                           BIGINT NOT NULL,                            -- foreign key to reg_entity.entity_id
  role                                VARCHAR(15) NOT NULL,                       -- INPUT, OUTPUT
  description                         VARCHAR(511) NULL,                          -- optional description of the role
  
  PRIMARY KEY (lifecycle_id),
  INDEX (role),
  FOREIGN KEY (object_id) REFERENCES reg_data_object(object_id),
  FOREIGN KEY (entity_id) REFERENCES reg_entity(entity_id)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_invocation;
CREATE TABLE reg_invocation (
  invocation_id                       BIGINT NOT NULL AUTO_INCREMENT,             -- internal ID
  invoker_id                          BIGINT NOT NULL,                            -- foreign key to reg_entity.entity_id
  invokee_id                          BIGINT NOT NULL,                            -- foreign key to reg_entity.entity_id
  invocation_type                     VARCHAR(15) NOT NULL,                       -- CONTROL, INVOKE, THROUGH_DATA
  invocation_data_id                  BIGINT NULL,                                -- optional foreign key to reg_data_object.object_id in case the invocation involves data
  
  PRIMARY KEY (invocation_id),
  FOREIGN KEY (invoker_id) REFERENCES reg_entity(entity_id),
  FOREIGN KEY (invokee_id) REFERENCES reg_entity(entity_id),
  FOREIGN KEY (invocation_data_id) REFERENCES reg_data_object(object_id),
  INDEX (invocation_type)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_data_transform;
CREATE TABLE reg_data_transform (
  transform_id                        BIGINT NOT NULL AUTO_INCREMENT,             -- internal ID of the data transform
  result_data_id                      BIGINT NOT NULL,                            -- foreign key to reg_data_object.object_id
  source_data_id                      BIGINT NOT NULL,                            -- foreign key to reg_data_object.object_id
  transform_description               VARCHAR(511) NULL,                          -- optional description of the transformation
  
  PRIMARY KEY (transform_id),
  FOREIGN KEY (result_data_id) REFERENCES reg_data_object(object_id),
  FOREIGN KEY (source_data_id) REFERENCES reg_data_object(object_id)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_entity_manifest;
CREATE TABLE reg_entity_manifest (
  manifest_id                         BIGINT NOT NULL AUTO_INCREMENT,             -- internal ID of the manifest
  entity_id                           BIGINT NOT NULL,                            -- foreign key to reg_entity.entity_id
  data_object_id                      BIGINT NOT NULL,                            -- foreign key to reg_data_object.object_id
  manifest_type                       VARCHAR(15) NOT NULL,                       -- SCRIPT, SOURCE_CODE, EXECUTABLE, LIBRARY, DEPENDENCY
  march                               VARCHAR(15) NOT NULL,                       -- machine architecture: UNIVERSAL, I386, I686, IA64, X86_64, PPC32, PPC64
  
  PRIMARY KEY (manifest_id),
  FOREIGN KEY (entity_id) REFERENCES reg_entity(entity_id),
  FOREIGN KEY (data_object_id) REFERENCES reg_data_object(object_id),
  INDEX (entity_id, data_object_id),
  INDEX (manifest_type),
  INDEX (march)
) ENGINE=InnoDB;


-- ==============================================  execution level tables below ===========================

DROP TABLE IF EXISTS exe_entity;
CREATE TABLE exe_entity (
  entity_id                          BIGINT NOT NULL AUTO_INCREMENT,              -- internal ID of entity instance
  entity_uri                         VARCHAR(375) NOT NULL,                       -- URI of the entity instance, e.g. an URI of a concrete service
  entity_type                        VARCHAR(15) NOT NULL,                        -- SERVICE, METHOD, WORKFLOW
  entity_subtype                    VARCHAR(15) NULL,                             -- CONTROLLER, HUMAN_PROXY, REGULAR(or NULL means REGULAR)
  context_workflow_uri               VARCHAR(375) NULL,                           -- URI of the context workflow, applicable when the entity is a SERVICE or a METHOD
  context_service_uri                VARCHAR(375) NULL,                           -- URI of the context service, applicable when the entity is a METHOD
  timestep                           INT DEFAULT -1,                              -- workflow timestep, applicable when the entity is a SERVICE or a METHOD
  context_wf_node_id_token           VARCHAR(255) NULL,                           -- workflow node ID, applicable when the entity is a SERVICE or a METHOD
  instance_of                        BIGINT NULL,                                 -- optional pointer to registry level foreign key to reg_entity.entity_id
--  execution_context                  VARCHAR(375) NOT NULL,                       -- entity execution context token, e.g. an URI
--  execution_node                     VARCHAR(375) NULL,                           -- the node on which the instance was run, e.g. a server name, URI, IP, etc.
 
  
  PRIMARY KEY (entity_id),
-- INDEX (entity_uri),
-- INDEX (entity_type), 
-- INDEX (entity_subtype),
 
  INDEX (entity_uri(127), entity_type, entity_subtype, context_workflow_uri(127), context_wf_node_id_token, timestep, context_service_uri(127)),
--  INDEX (execution_context),
--  INDEX (execution_node),
  FOREIGN KEY (instance_of) REFERENCES reg_entity(entity_id)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_behalf;
CREATE TABLE exe_behalf (
  behalf_id                        BIGINT NOT NULL AUTO_INCREMENT,                -- internal ID of behalf instance
  entity_id                        BIGINT NOT NULL,                               -- foreign key to exe_entity.entity_id
  user_id                          BIGINT NOT NULL,                               -- foreign key to reg_personnel.personnel_id
  
  PRIMARY KEY (behalf_id),
  FOREIGN KEY (entity_id) REFERENCES exe_entity(entity_id),
  FOREIGN KEY (user_id) REFERENCES reg_personnel(personnel_id)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_invocation;
CREATE TABLE exe_invocation (
  invocation_id                      BIGINT NOT NULL AUTO_INCREMENT,              -- internal ID of invocation
  invoker_id                         BIGINT NOT NULL,                             -- foreign key to exe_entity.entity_id
  invokee_id                         BIGINT NOT NULL,                             -- foreign key to exe_entity.entity_id
  invocation_start_time              DATETIME NOT NULL,                           -- invocation start time
  execution_end_time                 DATETIME NOT NULL CHECK (execution_end_time>=invocation_start_time),                           -- invocation end time
  invocation_status                  VARCHAR(15) NOT NULL,                        -- status of the invocation, SUCCESS or FAILED
  execution_status                   VARCHAR(15) NOT NULL,                        -- status of the execution, SUCCESS or FAILED
  invocation_type                    VARCHAR(15) NOT NULL,                        -- CONTROL, INVOKE, DATA_TRIGGER
  certainty                          TINYINT NOT NULL CHECK (certainty>=0 AND certainty<=100),                            -- a certainty score [0, 100] where 0==completely uncertain, and 100==completely certain
  certainty_source                   VARCHAR(31) NOT NULL,                        -- source from which the certainty score is determined. e.g. DEDUCTION, NOTIFICATION, CODE_LOGIC
  invocation_status_source           VARCHAR(31) NOT NULL,                        -- source from which the invocation status is determined
  execution_status_source            VARCHAR(31) NOT NULL,                        -- source from which the execution status is determined
  instance_of                        BIGINT NULL,                                 -- optional pointer to registry level foreign key to reg_invocation.invocation_id
  
  PRIMARY KEY (invocation_id),
  INDEX (invoker_id, invokee_id, invocation_type),
-- INDEX (invocation_status, invocation_status_source),
-- INDEX (execution_status, execution_status_source),
-- INDEX (invocation_type),
-- INDEX (certainty),
-- INDEX (certainty_source),
  FOREIGN KEY (invoker_id) REFERENCES exe_entity(entity_id),
  FOREIGN KEY (invokee_id) REFERENCES exe_entity(entity_id),
  FOREIGN KEY (instance_of) REFERENCES reg_invocation(invocation_id)
  
) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_data_object;
CREATE TABLE exe_data_object (
  object_id                         BIGINT NOT NULL AUTO_INCREMENT,               -- internal ID of data object
  object_type                       VARCHAR(31) NOT NULL,                         -- FILE, BLOCK, COLLECTION
  instance_of                       BIGINT NULL,                                  -- foreign key to reg_data_object.object_id
  quality                           TINYINT NOT NULL CHECK (quality>=0 AND quality<=100),                             -- a quality score [0, 100] where 0==lowest quality, and 100==highest quality
  quality_source                    VARCHAR(31) NOT NULL,                         -- source from which the quality score is determined. e.g. INFERRED, QUALITY_ASSESSMENT, UNKNOWN 
  
  PRIMARY KEY (object_id),
  INDEX (object_type),
  INDEX (quality),
  INDEX (quality_source),
  FOREIGN KEY (instance_of) REFERENCES reg_data_object(object_id)

) ENGINE=InnoDB;

DROP TABLE IF EXISTS exe_file;
CREATE TABLE exe_file (
  file_id                          BIGINT NOT NULL,                               -- foreign key to exe_data_object.object_id
  file_uri                         VARCHAR(375) NOT NULL,                         -- a unique filename, e.g. URL or logical name
  owner_id                         BIGINT NULL,                                   -- optional owner of the file, foreign key to reg_personnel.personnel_id
  creation_date                    DATETIME NULL,                                 -- optional creation date of the file
  -- deletion_date                    DATETIME NULL,                                 -- optional deletion date of the file
  size                             BIGINT NULL,                                   -- optional size of the file
  md5_checksum                     VARCHAR(63) NULL,                              -- optional md5 checksum of the file
  file_name                        VARCHAR(127) NULL,                             -- optional short name of the file
  
  INDEX (file_uri),
-- INDEX (file_name),
-- INDEX (md5_checksum),
  FOREIGN KEY (file_id) REFERENCES exe_data_object(object_id),
  FOREIGN KEY (owner_id) REFERENCES reg_personnel(personnel_id)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_block;
CREATE TABLE exe_block (
  block_id                         BIGINT NOT NULL,                               -- foreign key to exe_data_object.object_id
  -- block_name                       VARCHAR(375) NOT NULL,                         -- name of the block
  md5_checksum                     VARCHAR(63) NULL,                              -- md5 checksum of the block
  size                             BIGINT NULL,                                   -- size of the block
  block_content                    BLOB,                                          -- block content
  
 -- INDEX(block_name),
  INDEX(md5_checksum),
  FOREIGN KEY (block_id) REFERENCES exe_data_object(object_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS exe_data_collection;
CREATE TABLE exe_data_collection (
  collection_id                    BIGINT NOT NULL,                               -- foreign key to exe_data_object.object_id
  collection_uri                   VARCHAR(375) NOT NULL,                         -- uri of the collection
  
  INDEX(collection_uri),
  FOREIGN KEY (collection_id) REFERENCES exe_data_object(object_id)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS exe_data_collection_membership;
CREATE TABLE exe_data_collection_membership (
  membership_id                    BIGINT NOT NULL AUTO_INCREMENT,                -- membership internal ID
  collection_id                    BIGINT NOT NULL,                               -- foreign key to exe_data_collection.collection_id
  member_id                        BIGINT NOT NULL,                               -- foreign key to exe_data_object.object_id
  instance_of                      BIGINT NULL,                                   -- optional pointer to regsitry level foreign key to reg_data_object_membership.membership_id 
  
  PRIMARY KEY (membership_id),
  FOREIGN KEY (collection_id) REFERENCES exe_data_collection(collection_id),
  FOREIGN KEY (member_id) REFERENCES exe_data_object(object_id),
  FOREIGN KEY (instance_of) REFERENCES reg_data_object_membership(membership_id),
  INDEX (collection_id, member_id)

) ENGINE=InnoDB;



DROP TABLE IF EXISTS exe_data_lifecycle;
CREATE TABLE exe_data_lifecycle (
  event_id                         BIGINT NOT NULL AUTO_INCREMENT,                -- internal ID of the production/consumption event
  actor_id                         BIGINT NOT NULL,                               -- foreign key to exe_entity.entity_id
  data_id                          BIGINT NOT NULL,                               -- foreign key to exe_data_object.object_id
  instance_of                      BIGINT NULL,                                   -- optional pointer to registry level, foreign key to reg_data_object_lifecycle.lifecycle_id
  event_action                     VARCHAR(15) NOT NULL,                          -- PRODUCED, CONSUMED, UPDATED, DELETED
  role                             VARCHAR(63) NULL,                              -- optional role of the data
  event_time                       DATETIME NOT NULL,                             -- time the event took place
--  additional_action                VARCHAR(15) NULL,                              -- optional additional action: UPDATE or DELETE
--  addtional_action_time            DATETIME NULL,                                 -- time optional additional action occurred
  certainty                        TINYINT NOT NULL CHECK (certainty>=0 AND certainty<=100),                              -- a certainty score [0, 100]
  certainty_source                 VARCHAR(31) NOT NULL,                          -- source from which the certainty score is detertmined
  
  PRIMARY KEY (event_id),
  FOREIGN KEY (actor_id) REFERENCES exe_entity(entity_id),
  FOREIGN KEY (data_id) REFERENCES exe_data_object(object_id),
  FOREIGN KEY (instance_of) REFERENCES reg_data_object_lifecycle(lifecycle_id),
  INDEX (event_action),
 -- INDEX (additional_action),
  INDEX (certainty),
  INDEX (certainty_source)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS exe_invocation_data;
CREATE TABLE exe_invocation_data (
  combination_id                  BIGINT NOT NULL AUTO_INCREMENT,                 -- internal ID
  block_id                        BIGINT NOT NULL,                                -- foreign key to exe_block.block_id
  invocation_id                   BIGINT NOT NULL,                                -- foriegn key to exe_invocation.invocation_id
  role                            VARCHAR(15) NOT NULL,                           -- PARAM, RESULT, FAULT
  
  PRIMARY KEY (combination_id),
  FOREIGN KEY (block_id) REFERENCES exe_block(block_id),
  FOREIGN KEY (invocation_id) REFERENCES exe_invocation(invocation_id),
-- INDEX (role)
   INDEX (invocation_id, block_id, role)
  
) ENGINE=InnoDB;

DROP TABLE IF EXISTS exe_data_transfer;
CREATE TABLE exe_data_transfer (
  transfer_id                    BIGINT NOT NULL AUTO_INCREMENT,                  -- internal ID
  sender_id                      BIGINT NOT NULL,                                 -- foreign key to exe_entity.entity_id
  receiver_id                    BIGINT NOT NULL,                                 -- foreign key to exe_entity.entity_id
  data_id                        BIGINT NOT NULL,                                 -- foriegn key to exe_data_object.object_id
  transfer_start_time            DATETIME NOT NULL,                               -- transfer start time
  transfer_end_time              DATETIME NOT NULL CHECK (transfer_end_time>=transfer_start_time),                               -- transfer end time
  transfer_status                VARCHAR(15) NOT NULL,                            -- SUCCESS or FAILED
  transfer_status_source         VARCHAR(31) NOT NULL,                            -- source from which the transfer status is determined
  certainty                      TINYINT NOT NULL CHECK (certainty>=0 AND certainty <=100),  -- certainty
  certainty_source               VARCHAR(31) NOT NULL,                            -- source from which the certainty is determined

  PRIMARY KEY (transfer_id),
  FOREIGN KEY (sender_id) REFERENCES exe_entity(entity_id),
  FOREIGN KEY (receiver_id) REFERENCES exe_entity(entity_id),
  FOREIGN KEY (data_id) REFERENCES exe_data_object(object_id),
-- INDEX (certainty),
-- INDEX (certainty_source),
-- INDEX (transfer_status, transfer_status_source),
   INDEX (sender_id, receiver_id, data_id)

) ENGINE=InnoDB;

DROP TABLE IF EXISTS exe_data_transform;
CREATE TABLE exe_data_transform (
  transform_id              BIGINT NOT NULL AUTO_INCREMENT,                       -- internal ID of transformation
  result_data_id            BIGINT NOT NULL,                                      -- ID of the transformed data, foreign key to exe_data_object.object_id
  source_data_id            BIGINT NOT NULL,                                      -- ID of the source data, foreign key to exe_data_object.object_id
  transform_description     VARCHAR(511) NULL,                                    -- optional description of the data transformation
  instance_of               BIGINT NULL,                                          -- optional pointer to registry level, foreign key to reg_data_transform.transform_id
  certainty                 TINYINT NOT NULL CHECK (certainty>=0 AND certainty <=100),   -- certainty
  certainty_source          VARCHAR(31) NOT NULL,                                 -- source from which the certainty is determined
  
  PRIMARY KEY (transform_id),
  FOREIGN KEY (result_data_id) REFERENCES exe_data_object(object_id),
  FOREIGN KEY (source_data_id) REFERENCES exe_data_object(object_id),
  FOREIGN KEY (instance_of) REFERENCES reg_data_transform(transform_id),
  INDEX (certainty), 
  INDEX (certainty_source)
) ENGINE=InnoDB;

-- =============================== annotation tables for registry level ==================

DROP TABLE IF EXISTS reg_entity_annotation;
CREATE TABLE reg_entity_annotation (
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,                   -- internal ID
  entity_id                     BIGINT NOT NULL,                                  -- foreign key to reg_entity.entity_id
  annotation_name               VARCHAR(511) NOT NULL,                            -- name part of the name-value pair, could be a URI per OPM v1.1
  annotation_value              TEXT NOT NULL,                            -- value part of the name-value pair.
  annotation_type               VARCHAR(31) NOT NULL,                             -- indicates what type of annotation this is, e.g. OPM_ANNOTATION, KARMA_ANNOTATION, EXTERNAL_SOURCE
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (entity_id) REFERENCES reg_entity(entity_id),
  INDEX (annotation_name),
  INDEX (annotation_type)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS reg_manifest_annotation;
CREATE TABLE reg_manifest_annotation (
  
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,                   -- internal ID
  manifest_id                   BIGINT NOT NULL,                                  -- foreign key to reg_entity_manifest.manifest_id
  annotation_name               VARCHAR(511) NOT NULL,                            -- name part of the name-value pair, could be a URI per OPM v1.1
  annotation_value              TEXT NOT NULL,                            -- value part of the name-value pair.
  annotation_type               VARCHAR(31) NOT NULL,                             -- indicates what type of annotation this is, e.g. OPM_ANNOTATION, KARMA_ANNOTATION, EXTERNAL_SOURCE
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (manifest_id) REFERENCES reg_entity_manifest(manifest_id),
  INDEX (annotation_name),
  INDEX (annotation_type)

) ENGINE=InnoDB;

-- =============================== annotation tables for execution level =================
DROP TABLE IF EXISTS exe_data_object_annotation;
CREATE TABLE exe_data_object_annotation (
  annotation_id                  BIGINT NOT NULL AUTO_INCREMENT,                  -- internal ID
  object_id                      BIGINT NOT NULL,                                 -- foreign key to exe_data_object.object_id
  annotation_name                VARCHAR(511) NOT NULL,                           -- name part of the name-value pair, could be a URI per OPM v1.1
  annotation_value               TEXT NOT NULL,                           -- value part of the name-value pair. 
  annotation_type                VARCHAR(31) NOT NULL,                            -- indicates what type of annotation this is, e.g. OPM_ANNOTATION, KARMA_ANNOTATION, EXTERNAL_SOURCE
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (object_id) REFERENCES exe_data_object(object_id),
  INDEX (annotation_name),
  INDEX (annotation_type)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_entity_annotation;
CREATE TABLE exe_entity_annotation (
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,
  entity_id                     BIGINT NOT NULL,                                   -- foreign key to exe_entity.entity_id
  annotation_name               VARCHAR(511) NOT NULL,
  annotation_value              TEXT NOT NULL,
  annotation_type               VARCHAR(31) NOT NULL,
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (entity_id) REFERENCES exe_entity(entity_id),
  INDEX (annotation_name),
  INDEX (annotation_type)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_invocation_annotation;
CREATE TABLE exe_invocation_annotation (
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,
  invocation_id                 BIGINT NOT NULL,                                   -- foreign key to exe_invocation.invocation_id
  annotation_name               VARCHAR(511) NOT NULL,
  annotation_value              TEXT NOT NULL,
  annotation_type               VARCHAR(31) NOT NULL,
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (invocation_id) REFERENCES exe_invocation(invocation_id),
  INDEX (annotation_name),
  INDEX (annotation_type)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_data_lifecycle_annotation;
CREATE TABLE exe_data_lifecycle_annotation (
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,
  event_id                      BIGINT NOT NULL,                                   -- foreign key to exe_data_lifecycle.event_id
  annotation_name               VARCHAR(511) NOT NULL,
  annotation_value              TEXT NOT NULL,
  annotation_type               VARCHAR(31) NOT NULL,
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (event_id) REFERENCES exe_data_lifecycle(event_id),
  INDEX (annotation_name),
  INDEX (annotation_type)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_data_transform_annotation;
CREATE TABLE exe_data_transform_annotation (
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,
  transform_id                  BIGINT NOT NULL,                                   -- foreign key to exe_data_transform.transform_id
  annotation_name               VARCHAR(511) NOT NULL,
  annotation_value              TEXT NOT NULL,
  annotation_type               VARCHAR(31) NOT NULL,
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (transform_id) REFERENCES exe_data_transform(transform_id),
  INDEX (annotation_name),
  INDEX (annotation_type)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS exe_data_transfer_annotation;
CREATE TABLE exe_data_transfer_annotation (
  annotation_id                 BIGINT NOT NULL AUTO_INCREMENT,
  transfer_id                   BIGINT NOT NULL,                                   -- foreign key to exe_data_transfer.transfer_id
  annotation_name               VARCHAR(511) NOT NULL,
  annotation_value              TEXT NOT NULL,
  annotation_type               VARCHAR(31) NOT NULL,
  
  PRIMARY KEY (annotation_id),
  FOREIGN KEY (transfer_id) REFERENCES exe_data_transfer(transfer_id),
  INDEX (annotation_name),
  INDEX (annotation_type)
) ENGINE=InnoDB;

-- ============================= raw notification table ==========================

DROP TABLE IF EXISTS raw_notification;
CREATE TABLE raw_notification (
  raw_id                       BIGINT NOT NULL AUTO_INCREMENT,
  store_time                   DATETIME NOT NULL,
  notification_type            VARCHAR(63) NOT NULL,
  processing_status            VARCHAR(15) NOT NULL DEFAULT 'RAW',                 -- processing status, can be RAW, PROCESSED, or ERROR
  notification                 MEDIUMTEXT,
  
  PRIMARY KEY (raw_id),
  INDEX (notification_type),
  INDEX (processing_status, notification_type)

) ENGINE=InnoDB;


DROP TABLE IF EXISTS raw_notification_history;
CREATE TABLE raw_notification_history (
  raw_id                       BIGINT NOT NULL AUTO_INCREMENT,
  store_time                   DATETIME NOT NULL,
  notification_type            VARCHAR(63) NOT NULL,
  notification                 MEDIUMTEXT,
  hist_insert_time             DATETIME,
  PRIMARY KEY (raw_id)
) ENGINE=InnoDB;

-- ================================ cache level tables ===================================
DROP TABLE IF EXISTS cache_workflow_graph;
CREATE TABLE cache_workflow_graph (
   graph_id                     BIGINT NOT NULL AUTO_INCREMENT,						-- internal ID
   graph_context_wf_uri         VARCHAR(375) NULL,									-- graph workflow uri
   graph_content                MEDIUMBLOB,												-- opm graph
   query_date                   DATETIME NOT NULL,                                  -- time the query took place
   generation_time              BIGINT,                                             -- graph generation time   
   dirty                        BOOLEAN default false,								-- dirty bit to mark if updates to graph occur
   detailed                     BOOLEAN default true,                               -- bit to mark if graph is detail graph
    
   PRIMARY KEY (graph_id),
   INDEX (graph_context_wf_uri)
) ENGINE=InnoDB;


DROP TABLE IF EXISTS cache_provenance_history_graph;
CREATE TABLE cache_provenance_history_graph (
   graph_id                     BIGINT NOT NULL AUTO_INCREMENT,						-- internal ID
   data_product_id              VARCHAR(375) NULL,									-- data product id
   graph_content                MEDIUMBLOB,												-- opm graph
   query_date                   DATETIME NOT NULL,                                  -- time the query took place
   time_range                   BIGINT,                                             -- query timerange
   generation_time              BIGINT,                                             -- graph generation time
   dirty                        BOOLEAN default false,								-- dirty bit to mark if updates to graph occur
   detailed                     BOOLEAN default true,                               -- bit to mark if graph is detail graph
   
   PRIMARY KEY (graph_id),
   INDEX (data_product_id)
) ENGINE=InnoDB;

SET foreign_key_checks=1;

-- ====================== Procedure PR_OBJECT_LOCK ===============================

DROP PROCEDURE IF EXISTS PR_OBJECT_LOCK;

DELIMITER |

CREATE PROCEDURE PR_OBJECT_LOCK
(IN lockOp INTEGER, IN lockTimeOut INTEGER, 
IN p_object_id VARCHAR(375), OUT status INTEGER)
object_lock: BEGIN
DECLARE lockPrefix VARCHAR(6) DEFAULT "karma.";
DECLARE lockName VARCHAR(255) DEFAULT "";
SET status = 0;
SET lockName = CONCAT(lockPrefix,RIGHT(p_object_id,100)); 
IF lockOp = 1 THEN -- acquire lock
IF lockTimeOut < 1 THEN
SET lockTimeOut = 1;
END IF;
SELECT GET_LOCK(lockName,lockTimeOut) INTO status;
ELSE -- release lock
SELECT RELEASE_LOCK(lockName) INTO status;
END IF;
END object_lock
|

DELIMITER ;