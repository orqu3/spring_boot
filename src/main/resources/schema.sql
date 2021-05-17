CREATE SCHEMA IF NOT EXISTS `spring_boot_db`;

DROP TABLE IF EXISTS `spring_boot_db`.`products`;

CREATE TABLE `spring_boot_db`.`products`
(
    `id`    BIGINT       NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(128) NOT NULL UNIQUE,
    `price` INT          NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `spring_boot_db`.`users`;

CREATE TABLE `spring_boot_db`.`users`
(
    `id`       BIGINT          NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(128) NULL,
    `password` VARCHAR(100) NOT NULL,
    `enabled`  TINYINT(1)   NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `spring_boot_db`.`products_users`;

CREATE TABLE `spring_boot_db`.`products_users`
(
    `product_id` BIGINT NOT NULL,
    `user_id`    BIGINT NOT NULL,
    INDEX `fk_product_id_idx` (`product_id` ASC) VISIBLE,
    INDEX `fk_user_id_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_product_id`
        FOREIGN KEY (`product_id`)
            REFERENCES `spring_boot_db`.`products` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_user_id`
        FOREIGN KEY (`user_id`)
            REFERENCES `spring_boot_db`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS `spring_boot_db`.`roles`;

CREATE TABLE `spring_boot_db`.`roles`
(
    `id`   BIGINT       NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `spring_boot_db`.`roles_users`;

CREATE TABLE `spring_boot_db`.`roles_users`
(
    `role_id` BIGINT NOT NULL,
    `user_id`    BIGINT NOT NULL,
    INDEX `fk_roleID_idx` (`role_id` ASC) VISIBLE,
    INDEX `fk_userID_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_roleID`
        FOREIGN KEY (`role_id`)
            REFERENCES `spring_boot_db`.`roles` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_userID`
        FOREIGN KEY (`user_id`)
            REFERENCES `spring_boot_db`.`users` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);