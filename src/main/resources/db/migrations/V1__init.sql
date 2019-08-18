CREATE table addresses
(
    id        bigint(20)  NOT NULL AUTO_INCREMENT,
    country   VARCHAR(40) NOT NULL,
    city      VARCHAR(40) NOT NULL,
    street    VARCHAR(40) NOT NULL,
    post_code VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE users
(
    id         bigint(20)  NOT NULL AUTO_INCREMENT,
    login      VARCHAR(40) NOT NULL,
    password   VARCHAR(40) NOT NULL,
    address_id bigint(20)  NOT NULL,
    e_mail VARCHAR(60) NOT NULL,
    avatar_url VARCHAR(40),
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id)
);
CREATE TABLE authors
(
    id         bigint(20)  NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name  VARCHAR(40) NOT NULL
);
CREATE TABLE products
(
    id           bigint(20)  NOT NULL AUTO_INCREMENT,
    name         VARCHAR(40) NOT NULL,
    description  VARCHAR(40) NOT NULL,
    category     VARCHAR(40) NOT NULL,
    price        int         NOT NULL,
    product_type VARCHAR(40) NOT NULL,
    author_id    bigint(20)  NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);
CREATE table order_lines
(
    id         bigint(20) NOT NULL AUTO_INCREMENT,
    product_id bigint(20) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (id),
    PRIMARY KEY (id)
);
CREATE table orders
(
    id               bigint(20)   NOT NULL AUTO_INCREMENT,
    total_cost       int(20)      NOT NULL,
    delivery_address VARCHAR(40)  NOT NULL,
    date_of_order    DATETIME(40) NOT NULL,
    order_lines_id   bigint(40)   NOT NULL,
    users_id         bigint(20)   NOT NULL,
    status           VARCHAR(40)  NOT NULL,
    primary key (id),
    FOREIGN KEY (order_lines_id) REFERENCES order_lines (id),
    FOREIGN KEY (users_id) REFERENCES users (id)
);
CREATE table roles
(
    id   bigint(20)  NOT NULL AUTO_INCREMENT,
    role VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);
CREATE table cart(
    order_lines_id bigint(20) NOT NULL,
    FOREIGN KEY (order_lines_id) REFERENCES order_lines(id)
);
CREATE table category(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    types_of_category varchar (40) NOT NULL
);
