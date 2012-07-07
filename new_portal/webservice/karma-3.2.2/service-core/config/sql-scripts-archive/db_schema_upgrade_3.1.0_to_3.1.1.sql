SET foreign_key_checks=0;

ALTER TABLE exe_entity DROP INDEX entity_uri;
ALTER TABLE exe_entity DROP INDEX entity_type;
ALTER TABLE exe_entity DROP INDEX entity_subtype;
ALTER TABLE exe_entity ADD INDEX (entity_uri(127), entity_type, entity_subtype, context_workflow_uri(127), context_wf_node_id_token, timestep, context_service_uri(127));

ALTER TABLE exe_invocation DROP INDEX invocation_status;
ALTER TABLE exe_invocation DROP INDEX execution_status;
ALTER TABLE exe_invocation DROP INDEX invocation_type;
ALTER TABLE exe_invocation DROP INDEX certainty;
ALTER TABLE exe_invocation DROP INDEX certainty_source;
ALTER TABLE exe_invocation ADD INDEX (invoker_id, invokee_id, invocation_type);

ALTER TABLE exe_file DROP INDEX file_name;
ALTER TABLE exe_file DROP INDEX md5_checksum;

ALTER TABLE exe_data_collection_membership ADD INDEX (collection_id, member_id);

ALTER TABLE exe_invocation_data DROP INDEX role;
ALTER TABLE exe_invocation_data ADD INDEX (invocation_id, block_id, role);

ALTER TABLE exe_data_transfer DROP INDEX certainty;
ALTER TABLE exe_data_transfer DROP INDEX certainty_source;
ALTER TABLE exe_data_transfer DROP INDEX transfer_status;
ALTER TABLE exe_data_transfer ADD INDEX (sender_id, receiver_id, data_id);


DROP TABLE IF EXISTS schema_version;
CREATE TABLE schema_version (
  version                      VARCHAR(63) NOT NULL
) ENGINE=InnoDB;

INSERT INTO schema_version(version) VALUES ("3.1.1");


SET foreign_key_checks=1;
