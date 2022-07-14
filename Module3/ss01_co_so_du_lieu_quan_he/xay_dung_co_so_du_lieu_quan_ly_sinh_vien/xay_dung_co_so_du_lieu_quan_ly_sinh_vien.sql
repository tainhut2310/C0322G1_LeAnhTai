drop database if exists `student-management`;

create database `student-management`;

use `student-management`;

CREATE TABLE class (
    id INT,
    `name` VARCHAR(50)
);	

CREATE TABLE teacher (
    id INT,
    `name` VARCHAR(50),
    age INT NOT NULL,
    country VARCHAR(50) NOT NULL
);

