SET foreign_key_checks=0;

TRUNCATE TABLE reg_personnel;
TRUNCATE TABLE reg_entity;
TRUNCATE TABLE reg_entity_membership;
TRUNCATE TABLE reg_entity_authorship;
TRUNCATE TABLE reg_data_object;
TRUNCATE TABLE reg_data_object_membership;
TRUNCATE TABLE reg_data_object_lifecycle;
TRUNCATE TABLE reg_invocation;
TRUNCATE TABLE reg_data_transform;
TRUNCATE TABLE reg_entity_manifest;


TRUNCATE TABLE exe_entity;
TRUNCATE TABLE exe_behalf;
TRUNCATE TABLE exe_invocation;
TRUNCATE TABLE exe_data_object;
TRUNCATE TABLE exe_file;
TRUNCATE TABLE exe_block;
TRUNCATE TABLE exe_data_collection;
TRUNCATE TABLE exe_data_collection_membership;
TRUNCATE TABLE exe_data_lifecycle;
TRUNCATE TABLE exe_invocation_data;
TRUNCATE TABLE exe_data_transfer;
TRUNCATE TABLE exe_data_transform;

TRUNCATE TABLE reg_entity_annotation;
TRUNCATE TABLE reg_manifest_annotation;

TRUNCATE TABLE exe_data_object_annotation;
TRUNCATE TABLE exe_entity_annotation;
TRUNCATE TABLE exe_invocation_annotation;
TRUNCATE TABLE exe_data_lifecycle_annotation;
TRUNCATE TABLE exe_data_transform_annotation;
TRUNCATE TABLE exe_data_transfer_annotation;

TRUNCATE TABLE raw_notification;
TRUNCATE TABLE raw_notification_history;

TRUNCATE TABLE cache_workflow_graph;
TRUNCATE TABLE cache_provenance_history_graph;

SET foreign_key_checks=1;


