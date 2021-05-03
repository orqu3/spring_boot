CREATE SCHEMA `spring_boot_db` ;

CREATE TABLE `spring_boot_db`.`products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(128) NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `spring_boot_db`.`products` (`title`, `price`) VALUES ('milk', '115');
INSERT INTO `spring_boot_db`.`products` (`title`, `price`) VALUES ('bread', '50');
INSERT INTO `spring_boot_db`.`products` (`title`, `price`) VALUES ('butter', '90');

CREATE TABLE `spring_boot_db`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `spring_boot_db`.`users` (`name`) VALUES ('John');
INSERT INTO `spring_boot_db`.`users` (`name`) VALUES ('Bob');
INSERT INTO `spring_boot_db`.`users` (`name`) VALUES ('Anna');

CREATE TABLE `spring_boot_db`.`products_users` (
  `product_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
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
    ON UPDATE NO ACTION);
    
INSERT INTO products_users (product_id, user_id) VALUES 
(1,1),(2,1),(3,1),(3,2),(1,3),(2,3);
  