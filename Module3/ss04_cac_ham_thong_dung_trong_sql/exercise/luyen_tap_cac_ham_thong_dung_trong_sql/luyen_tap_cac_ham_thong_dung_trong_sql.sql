use quan_ly_sinh_vien;
select `subject`.*, max(`subject`.credit) as max_credit from `subject`;

select `subject`.*, max(mark.mark) as max_mark from `subject`
join mark on `subject`.sub_id = mark.sub_id;

select student.*, avg(mark.mark) as DTB from student 
join mark on student.student_id = mark.student_id
group by (student.student_id)
order by DTB;