CREATE TABLE `user`
(
    `id`                BIGINT(10)  NOT NULL AUTO_INCREMENT,
    `user_name`         VARCHAR(20) NOT NULL,
    `user_password`     VARCHAR(20) NOT NULL,
    `avatar`            VARCHAR(50) NOT NULL,
    `email`             VARCHAR(50),
    `phone_number`      VARCHAR(20),
    `gender`            SMALLINT NOT NULL,
    `creation_time`     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modification_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;