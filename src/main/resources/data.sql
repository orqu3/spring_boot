INSERT INTO `spring_boot_db`.`products` (`title`, `price`)
VALUES ('garlic', '115'),
       ('rice', '70'),
       ('corn', '70'),
       ('apple', '40'),
       ('sausage', '90'),
       ('banana', '60'),
       ('egg', '100'),
       ('cream', '130'),
       ('carrot', '40'),
       ('chicken', '300'),
       ('salt', '40'),
       ('water', '85'),
       ('pear', '60'),
       ('tomato', '50'),
       ('oat', '20'),
       ('cucumber', '49'),
       ('sugar', '50'),
       ('parsley', '34'),
       ('onion', '30'),
       ('seasoning', '45');

INSERT INTO `spring_boot_db`.`users` (`username`, 'password', 'enabled')
VALUES ('John', 12345, 1),
       ('Bob', 12345, 1),
       ('Anna', 12345, 1);

INSERT INTO products_users (product_id, user_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (3, 2),
       (1, 3),
       (2, 3);

INSERT INTO `spring_boot_db`.`authorities` (authority, user_id)
VALUES ('ADMIN', 1),
       ('MANAGER', 2),
       ('USER', 3);