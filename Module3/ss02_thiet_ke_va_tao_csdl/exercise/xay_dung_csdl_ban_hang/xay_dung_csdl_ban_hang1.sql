drop database if exists quan_ly_ban_hang1;

create database if not exists quan_ly_ban_hang1;

use quan_ly_ban_hang1;

CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(20),
    customer_age INT
);

CREATE TABLE `order` (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE,
    order_total_price DOUBLE,
    customer_id INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
);

CREATE TABLE product (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50),
    product_price DOUBLE
);

CREATE TABLE order_detail (
    order_id INT,
    product_id INT,
    PRIMARY KEY (order_id , product_id),
	quantity_order INT,
    FOREIGN KEY (order_id)
        REFERENCES `order` (order_id),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);