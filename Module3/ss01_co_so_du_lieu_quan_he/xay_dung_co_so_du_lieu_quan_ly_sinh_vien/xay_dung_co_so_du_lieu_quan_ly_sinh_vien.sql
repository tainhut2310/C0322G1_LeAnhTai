use `student-management`;
create table class(
id int not null primary key,
name varchar(50)
);	
create table teacher(
id int not null primary key,
`name` varchar(50),
age int not null,
country varchar(50) not null
);