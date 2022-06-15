use quan_ly_ban_hang;
insert into customer (customer_id, customer_name, age)
value (1, 'Minh Quan', 10), (2, 'Ngoc Oanh', 20), (3, 'Hong Ha', 50);

insert into `order` (order_id, order_date, total_price, customer_id)
value (1, '2006/03/21', null, 1), (2, '2006/03/23', null, 2), (3, '2006/03/16', null, 1);

insert into product (product_id, product_name, product_price)
value (1, 'May Giat', 3), (2, 'Tu Lanh', 5), (3, 'Dieu Hoa', 7), (4, 'Quat', 1), (5, 'Bep Dien', 2);

insert order_detail (order_id, product_id, quantity_order)
value (1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);

select order_id, order_date, total_price from `order`;

select customer_name, product_name from customer
join `order` on customer.customer_id = `order`.customer_id
join order_detail on order_detail.order_id = `order`.order_id
join product on product.product_id = order_detail.product_id;

select customer.customer_id, customer.customer_name, count(customer.customer_id) as so_lan_mua 
from  `order` right join customer on `order`.customer_id = customer.customer_id
group by `order`.order_id
having so_lan_mua = 0;

select `order`.order_id, order_date, sum(product_price * quantity_order) from `order`
join order_detail on `order`.order_id = order_detail.order_id
join product on order_detail.product_id = product.product_id
group by `order`.order_id;
