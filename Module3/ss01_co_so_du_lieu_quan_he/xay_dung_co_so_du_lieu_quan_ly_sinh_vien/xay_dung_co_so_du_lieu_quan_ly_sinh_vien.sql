create database `student-management`;

use `student-management`;

CREATE TABLE class (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);	

CREATE TABLE teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    age INT NOT NULL,
    country VARCHAR(50) NOT NULL
);

