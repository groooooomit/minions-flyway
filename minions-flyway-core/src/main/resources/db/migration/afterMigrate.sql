# noinspection SqlResolveForFile, SqlNoDataSourceInspectionForFile
INSERT IGNORE INTO `flyway_demo`.`person`
  (`name`, `age`)
VALUES ('小A', 20),
       ('小B', 21),
       ('小C', 22),
       ('小D', 23),
       ('小E', 24);