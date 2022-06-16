use `student-management`;
create table class(
id int primary key,
name varchar(50)
);	
create table teacher(
id int primary key,
`name` varchar(50),
age int not null,
country varchar(50) not null
);