use quan_ly_sinh_vien;
select `subject`.* from `subject`
where credit in (select max(`subject`.credit) as max_credit from `subject`);

select `subject`.* from `subject`
join mark on `subject`.sub_id = mark.sub_id
where mark in (select max(mark.mark) from mark);

select student.*, avg(mark.mark) as DTB from student 
join mark on student.student_id = mark.student_id
group by (student.student_id)
order by DTB;