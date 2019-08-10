CREATE TABLE `article`
(
    `id`                BIGINT(10)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `title`             VARCHAR(50) NOT NULL,
    `author_id`         BIGINT(20),
    `content`           TEXT                 DEFAULT NULL,
    `view_count`        BIGINT(8),
    `comments_count`    BIGINT(8),
    `like_count`        BIGINT(8),
    `creation_time`     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modification_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `tags`
(
    `id`                BIGINT(10)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `tag_name`          VARCHAR(50) NOT NULL,
    `creation_time`     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modification_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


CREATE TABLE `article_tag`
(
    `id`         BIGINT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `article_id` BIGINT(10) NOT NULL,
    `tag_id`     BIGINT(10)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
