drop database if exists demo_ss12;

create database if not exists demo_ss12;

use demo_ss12;

create table users(
id int(3) not null auto_increment primary key,
`name` varchar(120) not null,
email varchar(120) not null,
country varchar(120)
);

create table permision(
id int(11) primary key,
`name` varchar(50)
);

create table user_permision(
permision_id int(11),
user_id int(11),
foreign key (permision_id) references permision (id),
foreign key (user_id) references users (id)
);

-- create table employee(
-- id serial primary key,
-- `name` varchar(100) not null,
-- salary numeric(15, 2) not null,
-- created_date timestamp
-- );

insert into users(`name`, email, country) 
values('Minh','minh@codegym.vn','Viet Nam'),
('Kante','kante@che.uk','Kenia');

insert into Permision(id, name) values(1, 'add');
insert into Permision(id, name) values(2, 'edit');
insert into Permision(id, name) values(3, 'delete');
insert into Permision(id, name) values(4, 'view');

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
    INSERT INTO users(`name`, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE select_users()
BEGIN
    SELECT *
    FROM users;
    END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE update_user(
IN id_update int,
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    UPDATE users SET `name` = user_name, email = user_email, country = user_country
    WHERE id = id_update;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_user_by_id(IN user_id INT)
BEGIN
    DELETE FROM users
    WHERE users.id = user_id;
    END$$
DELIMITER ;


