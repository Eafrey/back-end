CREATE TABLE `article`
(
    `id`                BIGINT(10)  NOT NULL AUTO_INCREMENT,
    `title`             VARCHAR(50) NOT NULL,
    `user_id`           BIGINT(10),
    `user_name`         VARCHAR(20),
    `catalog_id`        BIGINT(10),
    `content`           TEXT        DEFAULT NULL,
    `view_count`        BIGINT(8),
    `comments_count`    BIGINT(8),
    `like_count`        BIGINT(8),
    `tags`              VARCHAR(50),
    `creation_time`     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modification_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY (`user_id`),
    UNIQUE KEY (`title`),
    FOREIGN KEY (`catalog_id`) references `catalog`(`id`),
    FOREIGN KEY (`user_id`) references `user`(`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

