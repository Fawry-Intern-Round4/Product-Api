DROP TABLE IF EXISTS products;
CREATE TABLE products
(
    id          INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    code        VARCHAR(255) UNIQUE NOT NULL,
    name        VARCHAR(255)        NOT NULL,
    price       DECIMAL(10, 2)      NOT NULL,
    description TEXT                NOT NULL,
    image       TEXT                NOT NULL
);