USE quan_ly_ban_hang1;

INSERT INTO customer (customer_name, customer_age)
VALUE ('Minh Quan', 10), 
('Ngoc Oanh', 20), 
('Hong Ha', 50);

INSERT INTO `order` (order_id, order_date, order_total_price, customer_id)
VALUE (1, '2006/03/21', null, 1), 
(2, '2006/03/23', null, 2), 
(3, '2006/03/16', null, 1);

INSERT INTO product (product_id, product_name, product_price)
VALUE (1, 'May Giat', 3), 
(2, 'Tu Lanh', 5), 
(3, 'Dieu Hoa', 7), 
(4, 'Quat', 1), 
(5, 'Bep Dien', 2);

INSERT INTO order_detail (order_id, product_id, quantity_order)
VALUE (1, 1, 3), 
(1, 3, 7), 
(1, 4, 2), 
(2, 1, 1), 
(3, 1, 8), 
(2, 5, 4), 
(2, 3, 3);

SELECT 
    o.order_id, o.order_date, o.order_total_price
FROM
    `order` o;

SELECT 
    c.*, p.*
FROM
    customer c
        JOIN
    `order` o ON c.customer_id = o.customer_id
        JOIN
    order_detail od ON o.order_id = od.order_id
        JOIN
    product p ON od.product_id = p.product_id;

SELECT 
    c.*, COUNT(o.customer_id) so_lan_mua
FROM
    customer c
        LEFT JOIN
    `order` o ON c.customer_id = o.customer_id
GROUP BY o.customer_id
HAVING so_lan_mua = 0;

SELECT 
    o.order_id,
    o.order_date,
    SUM((od.quantity_order * p.product_price)) AS total_order_price
FROM
    `order` o
        JOIN
    order_detail od ON o.order_id = od.order_id
        JOIN
    product p ON od.product_id = p.product_id
GROUP BY o.order_id;