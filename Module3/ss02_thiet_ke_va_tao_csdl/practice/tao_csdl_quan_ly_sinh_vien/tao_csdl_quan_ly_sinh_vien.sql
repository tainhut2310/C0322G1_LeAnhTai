DROP DATABASE IF EXISTS quan_ly_sinh_vien;

CREATE DATABASE IF NOT EXISTS quan_ly_sinh_vien;

USE quan_ly_sinh_vien;

CREATE TABLE class (
    class_id INT AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME NOT NULL,
    `status` BIT
);

CREATE TABLE student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    address VARCHAR(20),
    phone VARCHAR(20),
    `status` BIT,
    class_id INT NOT NULL,
    FOREIGN KEY (class_id)
        REFERENCES class (class_id)
);

CREATE TABLE `subject` (
    sub_id INT AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit TINYINT NOT NULL DEFAULT 1 CHECK (credit >= 1),
    `status` BIT
);

CREATE TABLE mark (
    mark_id INT AUTO_INCREMENT PRIMARY KEY,
    sub_id INT NOT NULL,
    student_id INT NOT NULL,
    mark FLOAT DEFAULT 0 CHECK (mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (mark_id , student_id),
    FOREIGN KEY (sub_id)
        REFERENCES `subject` (sub_id),
    FOREIGN KEY (student_id)
        REFERENCES student (student_id)
);

insert into class
value (1, 'A1', '2008-12-20', 1);

insert into class
value (2, 'A2', '2008-12-20', 1);

insert into class
value (3, 'B3', current_date, 0);

INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);

INSERT INTO student (student_name, address, status, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);

INSERT INTO student (student_name, address, phone, status, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO Mark (sub_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
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
    student_name LIKE '%h';

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






