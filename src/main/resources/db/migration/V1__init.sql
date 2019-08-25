start transaction ;
CREATE table addresses
(
    id        bigint(20)  NOT NULL AUTO_INCREMENT,
    country   VARCHAR(40) NOT NULL,
    city      VARCHAR(40) NOT NULL,
    street    VARCHAR(40) NOT NULL,
    post_code VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);
start transaction ;
CREATE table category(
    id bigint (20) NOT NULL AUTO_INCREMENT,
    types_of_category enum('BOOK', 'EBOOK', 'AUDIOBOOK', 'PRESS', 'OTHER') NOT NULL,
    PRIMARY KEY (id)
);
start transaction ;
CREATE table roles
(
    id   bigint(20)  NOT NULL AUTO_INCREMENT,
    role VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);
start transaction ;
CREATE TABLE users
(
    id         bigint(20)  NOT NULL AUTO_INCREMENT,
    login      VARCHAR(40) NOT NULL,
    password   VARCHAR(40) NOT NULL,
    address_id bigint(20)  NOT NULL,
    e_mail VARCHAR(60) NOT NULL,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    avatar_url VARCHAR(400),
    role_id bigint (20),
    PRIMARY KEY (id),
    FOREIGN KEY (address_id) REFERENCES addresses (id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);
start transaction ;
CREATE TABLE authors
(
    id         bigint(20)  NOT NULL AUTO_INCREMENT,
    name varchar(40) NOT NULL,
    PRIMARY KEY (id)
);
start transaction ;
CREATE TABLE products
(
    id           bigint(20)  NOT NULL AUTO_INCREMENT,
    name         VARCHAR(40) NOT NULL,
    stock_amount INTEGER (40) NOT NULL,
    picture_url VARCHAR (400) NOT NULL,
    description  VARCHAR(40) NOT NULL,
    price        double      NOT NULL,
    product_type enum('FANTASY', 'CRIMINAL', 'BIOGRAPHY', 'ENTERTAINMENT', 'HISTORY', 'COMICS', 'OTHER')
        NOT NULL,
    author_id    bigint(20)  NOT NULL,
    category_id bigint(20) NOT NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);
start transaction ;
CREATE table order_lines
(
    id         bigint(20) NOT NULL AUTO_INCREMENT,
    product_id bigint(20) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (id),
    PRIMARY KEY (id)
);
start transaction ;
CREATE table orders
(
    id               bigint(20)   NOT NULL AUTO_INCREMENT,
    total_cost       int(20)      NOT NULL,
    delivery_address VARCHAR(40)  NOT NULL,
    date_of_order    DATETIME NOT NULL,
    order_lines_id   bigint(40)   NOT NULL,
    users_id         bigint(20)   NOT NULL,
    status           enum ('OCZEKUJACE', 'WYSLANE') NOT NULL,
    primary key (id),
    FOREIGN KEY (order_lines_id) REFERENCES order_lines (id),
    FOREIGN KEY (users_id) REFERENCES users (id)
);
start transaction ;
CREATE table cart(
    order_lines_id bigint(20) NOT NULL,
    FOREIGN KEY (order_lines_id) REFERENCES order_lines(id)
);
