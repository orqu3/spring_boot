CREATE SCHEMA IF NOT EXISTS `spring_boot_db` ;

CREATE TABLE IF NOT EXISTS `spring_boot_db`.`products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(128) NOT NULL UNIQUE,
  `price` INT NOT NULL ,
  PRIMARY KEY (`id`));
