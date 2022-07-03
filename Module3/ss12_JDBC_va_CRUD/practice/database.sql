create database demo;
use demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;

create table permision(

id int(11) primary key,

name varchar(50)

);


create table user_permision(

permision_id int(11),

user_id int(11)

);

insert into permision(id, name) values(1, 'add');

insert into permision(id, name) values(2, 'edit');

insert into permision(id, name) values(3, 'delete');

insert into permision(id, name) values(4, 'view');

delimiter //
create procedure show_list()
begin 
select * from users;
end //
delimiter ;

delimiter //
create procedure update_user(in paramester_id int, paramester_name varchar(20), paramester_email varchar(20), paramester_country varchar(20))
begin 
update users set id = paramester_id, `name` = paramester_name, email = paramester_email, country = paramester_country
where id = paramester_id;
end //
delimiter ;

delimiter //
create procedure remove_user (in key_id int)
begin 
delete from users
where id = key_id;
end //
delimiter ; 
call remove_product(6);