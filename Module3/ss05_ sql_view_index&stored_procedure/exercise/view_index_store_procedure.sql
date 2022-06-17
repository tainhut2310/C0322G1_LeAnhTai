-- Bước 1: Tạo cơ sở dữ liệu demo
create database demo;
use demo;
create table products(
id int auto_increment primary key,
product_code varchar(20),
product_name varchar(20),
product_price double,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);
-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) 
value ('I123','iPhone 10', 10000000, 50, 'Gold', 'Ngừng sản xuất'), 
 ('I456', 'iPhone 11', 12000000, 100, 'Green', 'Còn hàng'), 
 ('S123', 'Samsung A10', 7000000, 150, 'Red', 'Còn hàng'), 
 ('N123', 'Nokia N10', 6000000, 200, 'Black', 'Ngừng sản xuất'), 
 ('I678', 'iPhone 12', 15000000, 180, 'White', 'Còn hàng');
 -- Bước 3:
 select * from products where product_code = 'S123'; 
 
 explain select * from products where product_code = 'S123';
 
 -- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
 create index product_code_key on products (product_code);
 
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
  explain select * from products where product_code = 'S123';
 
 -- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
 create index composite_index on products (product_name, product_price);
 
 explain select * from products where product_name = 'Nokia N10';
 -- So sánh câu truy vấn trước và sau khi tạo index
 explain select * from products where product_name = 'Samsung A10' or product_price = 7000000;
 
 -- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
 create view product_information as
 select product_code, product_name, product_price, product_status from products;
 
 select * from product_information;
 
--  Tiến hành sửa đổi view
  update product_information 
  set product_status = 'Ngừng sản xuất'
  where product_code = 'S123';
  
--   Tiến hành xoá view
drop view product_information;

-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_information ()
begin 
select * from products;
end //
delimiter ;
call get_information();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_new_product ()
begin 
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status)
value ('I1314', 'iPhone 13', 25000000, 100, 'Gold', 'Còn hàng');
end //
delimiter ; 
call add_new_product();
  
--   Tạo store procedure sửa thông tin sản phẩm theo id
  delimiter //
create procedure edit_product (in key_name int)
begin 
update products set product_code = 'S1080', product_name =  'Samsung A3', 
product_price = 5000000, product_amount = 50, product_description = 'Green', product_status = 'Còn hàng'
where id = key_name;
end //
delimiter ; 
call edit_product(6);

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure remove_product (in key_name int)
begin 
delete from products
where id = key_name;
end //
delimiter ; 
call remove_product(6);



