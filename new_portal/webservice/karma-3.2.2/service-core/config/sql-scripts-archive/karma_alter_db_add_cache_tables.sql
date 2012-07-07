-- ------------------------------------------------------------------
-- AlterDB script to create two cache tables to the Karma DB tables:
-- (cache_workflow_graph and cache_provenance_history_graph). This script
-- can also be used to empty the cache tables.
--
-- Revision:
--          May. 25, 2011
--
-- Deployment syntax: mysql -u <username> -p <database> < karma_alter_db_add_cache_tables.sql
--
--
-- Author:  
--			You-Wei Cheah (yocheah@cs.indiana.edu)
-- ------------------------------------------------------------------
--
-- ================================ cache level tables ===================================
DROP TABLE IF EXISTS cache_workflow_graph;
CREATE TABLE cache_workflow_graph (
   graph_id                     BIGINT NOT NULL AUTO_INCREMENT,						-- internal ID
   graph_context_wf_uri         VARCHAR(375) NULL,									-- graph workflow uri
   graph_content                MEDIUMBLOB,											-- opm graph
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
   graph_content                MEDIUMBLOB,											-- opm graph
   query_date                   DATETIME NOT NULL,                                  -- time the query took place
   time_range                   BIGINT,                                             -- query timerange
   generation_time              BIGINT,                                             -- graph generation time
   dirty                        BOOLEAN default false,								-- dirty bit to mark if updates to graph occur
   detailed                     BOOLEAN default true,                               -- bit to mark if graph is detail graph
   
   PRIMARY KEY (graph_id),
   INDEX (data_product_id)
) ENGINE=InnoDB;