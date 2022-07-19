DROP DATABASE IF EXISTS demo_ss05;
-- Bước 1: Tạo cơ sở dữ liệu demo
CREATE DATABASE IF NOT EXISTS demo_ss05;

USE demo_ss05;

-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_code VARCHAR(20) NOT NULL,
    product_name VARCHAR(45),
    product_price DOUBLE,
    product_amount INT,
    product_description VARCHAR(45),
    product_status VARCHAR(45)
);

INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status) 
VALUE ('I123','iPhone 10', 10000000, 50, 'Hàng chính hãng', 'Hết hàng'), 
 ('I456', 'iPhone 11', 12000000, 100, 'Hàng 99%', 'Còn hàng'), 
 ('S123', 'Samsung A10', 7000000, 150, 'Hàng xách tay', 'Còn hàng'), 
 ('N123', 'Nokia N10', 6000000, 200, 'Hàng chính hãng', 'Hết hàng'), 
 ('I678', 'iPhone 12', 15000000, 180, 'Hàng cũ', 'Còn hàng');
 
--  Bước 3:
EXPLAIN SELECT * FROM products WHERE product_code = 'S123';
    
    -- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
CREATE INDEX product_code_index ON products (product_code);

EXPLAIN SELECT * FROM products WHERE product_code = 'S123';

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
CREATE INDEX product_composite_index ON products (product_name, product_price);

EXPLAIN SELECT * FROM products WHERE product_name = 'Samsung A10' OR product_price = 7000000;
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW product_view AS
    SELECT product_code, product_name, product_price, product_status
    FROM products;
        
SELECT *
FROM product_view; 
    
-- Tiến hành sửa đổi view
UPDATE product_view 
SET product_status = 'Hết hàng'
WHERE product_code = 'S123';

-- Tiến hành xoá view
DROP VIEW product_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE select_all_product()
BEGIN 
SELECT products.* FROM products;
END // 
DELIMITER ;

CALL select_all_product();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE add_product (product_code VARCHAR(20), 
product_name VARCHAR(45),
product_price DOUBLE,
product_amount INT,
product_description VARCHAR(45),
product_status VARCHAR(45))
BEGIN 
INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUE (product_code, product_name, product_price, product_amount, product_description, product_status);
END //
DELIMITER ;

CALL add_product('IP13PRO', 'iPhone 13 Pro Max', 30000000, 50, 'Hàng chính hãng', 'Còn hàng');

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
CREATE PROCEDURE edit_product(id_update INT, product_code VARCHAR(20), 
product_name VARCHAR(45),
product_price DOUBLE,
product_amount INT,
product_description VARCHAR(45),
product_status VARCHAR(45))
BEGIN
UPDATE products set product_code = product_code, product_name = product_name, product_price = product_price, 
product_amount = product_amount, product_description = product_description, product_status = product_status
WHERE id = id_update;
END //
DELIMITER ;

CALL edit_product(4, 'IP8PLUS', 'iPhone 8 Plus', 30000000, 50, 'Hàng chính hãng', 'Hết hàng');

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
CREATE PROCEDURE delete_product(id_delete int)
BEGIN 
DELETE FROM products
WHERE id = id_delete;
END // 
DELIMITER ;

CALL delete_product(6);
