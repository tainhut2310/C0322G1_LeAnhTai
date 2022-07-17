USE quan_ly_sinh_vien;

SELECT 
    *
FROM
    student
WHERE
    student_name LIKE 'h%';

SELECT 
    *
FROM
    class
WHERE
    DATEDIFF('2008-12-31', start_date) BETWEEN 1 AND 30;

SELECT 
    *
FROM
    `subject`
WHERE
    credit BETWEEN 3 AND 5;

UPDATE student 
SET 
    class_id = 2
WHERE
    student_name LIKE '% Hung %';

SELECT 
    st.student_name, s.sub_name, m.mark
FROM
    student st
        JOIN
    mark m ON st.student_id = m.student_id
        JOIN
    `subject` s ON s.sub_id = m.sub_id
ORDER BY mark DESC , st.student_name;