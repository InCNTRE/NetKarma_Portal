-- ------------------------------------------------------------------
-- AlterDB script to modify data-type/size of annotation_value 
-- column in exe_*_annotation and reg_*_annotation tables.
--
--
-- Revision:
--          Feb. 17, 2011
--
-- Authors:
--			Beth Plale (plale@cs.indiana.edu)    
--			Devarshi Ghoshal (dghoshal@indiana.edu)
--          Yiming Sun (yimsun@cs.indiana.edu)
--
-- ------------------------------------------------------------------

alter table exe_invocation_annotation change annotation_value annotation_value TEXT NOT NULL;
alter table exe_data_lifecycle_annotation change annotation_value annotation_value TEXT NOT NULL;
alter table exe_data_object_annotation change annotation_value annotation_value TEXT NOT NULL;
alter table exe_data_transfer_annotation change annotation_value annotation_value TEXT NOT NULL;
alter table exe_data_transform_annotation change annotation_value annotation_value TEXT NOT NULL;
alter table exe_entity_annotation change annotation_value annotation_value TEXT NOT NULL;

alter table reg_manifest_annotation change annotation_value annotation_value TEXT NOT NULL;
alter table reg_entity_annotation change annotation_value annotation_value TEXT NOT NULL;