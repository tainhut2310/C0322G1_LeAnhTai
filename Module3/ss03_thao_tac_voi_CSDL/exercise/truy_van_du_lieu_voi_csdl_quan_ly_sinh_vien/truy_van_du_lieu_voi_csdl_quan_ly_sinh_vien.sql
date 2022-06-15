use quan_ly_sinh_vien;
select student_name from student 
where student_name like 'h%';

select * from class
where month(start_date) = 12;

select * from `subject`
where credit >= 3 and credit <= 5;

update student
set class_id = 2
where student_name = 'Hung';

select student.student_name, `subject`.sub_name, mark from mark
inner join student on mark.student_id = student.student_id
inner join `subject` on mark.sub_id = `subject`.sub_id
order by mark desc, student.student_name;