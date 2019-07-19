# noinspection SqlNoDataSourceInspectionForFile
CREATE TABLE `flyway_demo`.`person`
(
  `id`                 BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `creator_id`         BIGINT(20)   NULL DEFAULT NULL,
  `creator_name`       VARCHAR(255) NULL DEFAULT NULL,
  `create_time`        BIGINT(20)   NULL DEFAULT NULL,
  `last_editor_id`     BIGINT(20)   NULL DEFAULT NULL,
  `last_editor_name`   VARCHAR(255) NULL DEFAULT NULL,
  `last_modified_time` BIGINT(20)   NULL DEFAULT NULL,
  `optimistic`         BIGINT(20)   NULL DEFAULT NULL,
  `age`                INT(11)      NULL DEFAULT NULL,
  `name`               VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8