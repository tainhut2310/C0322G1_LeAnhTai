USE quan_ly_sinh_vien;

SELECT 
    *
FROM
    student;   
    
SELECT 
    *
FROM
    student
WHERE
    status = TRUE;

SELECT 
    *
FROM
    `subject`
WHERE
    credit < 10;

SELECT 
    s.student_id, s.student_name, c.class_name
FROM
    student s
        JOIN
    class c ON s.class_id = c.class_id;

SELECT 
    s.student_id, s.student_name, c.class_name
FROM
    student s
        JOIN
    class c ON s.class_id = c.class_id
WHERE
    c.class_name = 'A1';

SELECT 
    s.student_id, s.student_name, sub.sub_name, m.mark
FROM
    student s
        JOIN
    mark m ON s.student_id = m.student_id
        JOIN
    subject sub ON m.sub_id = sub.sub_id
WHERE
    sub.sub_name = 'CF';

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
    credit BETWEEN 2 AND 5;

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

SELECT 
    address, COUNT(student_id) AS so_luong_hoc_vien
FROM
    student
GROUP BY address;

SELECT 
    s.student_id, s.student_name, AVG(mark) AS diem_trung_binh
FROM
    student s
        JOIN
    mark m ON s.student_id = m.student_id
GROUP BY s.student_id , s.student_name
HAVING diem_trung_binh > 15;

SELECT 
    s.student_id, s.student_name, AVG(m.mark) AS diem_trung_binh
FROM
    student s
        JOIN
    mark m ON s.student_id = m.student_id
GROUP BY s.student_id , s.student_name
HAVING diem_trung_binh > ALL (SELECT 
        AVG(mark)
    FROM
        mark
    GROUP BY mark.student_id);
    
    -- BÀI TẬP
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT 
    *
FROM
    `subject`
HAVING credit >= ALL (SELECT 
        MAX(credit)
    FROM
        `subject`);
        
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT 
    `subject`.*
FROM
    `subject`
        JOIN
    mark ON `subject`.sub_id = mark.sub_id
WHERE
    mark.mark >= ALL (SELECT 
            MAX(mark)
        FROM
            mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

SELECT 
    s.*, AVG(m.mark) AS diem_trung_binh
FROM
    student s
        JOIN
    mark m ON s.student_id = m.student_id
GROUP BY s.student_id
ORDER BY diem_trung_binh DESC;