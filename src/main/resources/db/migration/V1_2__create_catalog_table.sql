CREATE TABLE `catalog`
(
    `id`                BIGINT(10)  NOT NULL AUTO_INCREMENT,
    `catalog_name`      VARCHAR(20) NOT NULL,
    `creation_time`     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`catalog_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;