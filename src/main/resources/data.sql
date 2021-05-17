INSERT INTO `spring_boot_db`.`products` (title, price)
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

INSERT INTO `spring_boot_db`.`users` (username, password, enabled)
VALUES ('John', '$2y$04$fHy5/MduEYLuBkT7e1N0bugEAPgdqUQsuZoRyKo7bx/sxVabIHP3S', 1),
       ('Bob', '$2y$04$fHy5/MduEYLuBkT7e1N0bugEAPgdqUQsuZoRyKo7bx/sxVabIHP3S', 1),
       ('Anna', '$2y$04$fHy5/MduEYLuBkT7e1N0bugEAPgdqUQsuZoRyKo7bx/sxVabIHP3S', 1);

INSERT INTO products_users (product_id, user_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (3, 2),
       (1, 3),
       (2, 3);

INSERT INTO `spring_boot_db`.`roles` (id, name)
VALUES (1, 'ADMIN'),
       (2, 'MANAGER'),
       (3, 'USER');

INSERT INTO `spring_boot_db`.`roles_users` (role_id, user_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);