create database quan_ly_ban_hang;
use `quan_ly_ban_hang`;
create table customer (
customer_id int not null auto_increment primary key,
customer_name varchar(20) not null,
phone VARCHAR(20),
age int not null
);
create table `order`(
order_id int not null auto_increment primary key,
buy_date DATETIME NOT NULL,
price_product float,
customer_id int not null,
foreign key (customer_id) references customer (customer_id)
);
create table product(
product_id int not null auto_increment primary key,
product_name varchar(50) not null,
product_price float
);
create table order_detail(
order_id int not null,
product_id int not null,
primary key (order_id, product_id),
foreign key (order_id) references `order` (order_id),
foreign key (product_id) references product (product_id),
quantity_order int
);


