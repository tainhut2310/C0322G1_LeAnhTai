USE quan_ly_sinh_vien;

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