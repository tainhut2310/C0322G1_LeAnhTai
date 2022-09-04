insert into customer_type (`name`) values ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');


insert into customer value
(1, '23 Nguyễn Hoàng, Đà Nẵng', '1970-11-07', 'thihao07@gmail.com', 0, '643431213', 'Nguyễn Thị Hào', '0945423362', 5),
(2, 'K77/22 Thái Phiên, Quảng Trị', '1992-08-08', 'xuandieu92@gmail.com', 0, '865342123', 'Phạm Xuân Diệu', '0954333333', 3),
(3, 'K323/12 Ông Ích Khiêm, Vinh', '1990-02-27', 'nghenhan2702@gmail.com', 1, '488645199', 'Trương Đình Nghệ', '0373213122', 1),
(4, 'K453/12 Lê Lợi, Đà Nẵng',  '1981-07-08', 'duongquan@gmail.com',  1, '543432111', 'Dương Văn Quan', '0490039241', 1),
(5, '224 Lý Thái Tổ, Gia Lai', '1995-12-09', 'nhinhi123@gmail.com', 0, '795453345', 'Hoàng Trần Nhi Nhi', '0312345678', 4),
(6, '37 Yên Thế, Đà Nẵng',  '2005-12-06', 'tonnuchau@gmail.com', 0, '732434215', 'Tôn Nữ Mộc Châu', '0988888844', 4),
(7, 'K123/45 Lê Lợi, Hồ Chí Minh', '1984-04-08', 'kimcuong84@gmail.com', 0, '856453123', 'Nguyễn Mỹ Kim', '0912345698', 1),
(8, '55 Nguyễn Văn Linh, Kon Tum', '1999-04-08',  'haohao99@gmail.com', 0, '965656433', 'Nguyễn Thị Hào', '0763212345', 3),
(9, '24 Lý Thường Kiệt, Quảng Ngãi', '1994-07-01', 'danhhai99@gmail.com', 1, '432341235', 'Trần Đại Danh', '0643343433', 1),
(10, '22 Ngô Quyền, Đà Nẵng', '1989-07-01', 'dactam@gmail.com', 1, '344343432', 'Nguyễn Tâm Đắc', '0987654321', 2);

insert into rent_type (`name`) values ('year'), ('month'), ('day'), ('hour');

insert into facility_type (`name`) values ('Villa'), ('House'), ('Room');

insert into facility values (1, 25000, 10000000, 'Có hồ bơi', null, 10, 'Beach Front', 4, 500, 'vip', 1, 4),
(2, 14000, 5000000, 'Có thêm bếp nướng', null, 7, 'House Princess 01', 3, null, 'vip', 2, 2),
(3, 5000, 1000000, 'Có tivi', 'Ăn sáng', 2, 'Room Twin 01', null, null, 'normal', 3, 3),
(4, 22000, 9000000, 'Có hồ bơi', null, 8, 'Villa No Beach Front', 3, 300, 'normal', 1, 1),
(5, 10000, 4000000, 'Có thêm bếp nướng', null, 5, 'House Princess 02', 2, null, 'normal', 2, 3),
(6, 3000, 900000, 'Có tivi', 'Ăn tối', 2, 'Room Twin 02', null, null, 'normal', 3, 2);

insert into `user` (username, `password`) value ('annguyen@gmail.com', '0901234121'), ('binhlv@gmail.com', '0934212314') , 
('thiyen@gmail.com', '0412352315') , ('toan0404@gmail.com', '0374443232') , ('phatphat@gmail.com','0902341231') , ('annghi20@gmail.com','0978653213') ,
 ('nhh0101@gmail.com', '0941234553') , ('donghanguyen@gmail.com', '064212311') , ('hoangtong@gmail.com', '0245144444') , ('nguyencongdao12@gmail.com', '0988767111');
 
 insert into `position` (`name`) values ('Quản Lý'), ('Nhân Viên');

insert into education_degree (`name`) values ('Trung Cấp'), ('Cao Đẳng'), ('Đại Học'), ('Sau Đại Học');

insert into division (`name`) values ('Sale-Marketing'), ('Hành chính'), ('Phục vụ'), ('Quản lý');

insert into employee 
values (1, '295 Nguyễn Tất Thành, Đà Nẵng', '1970-11-07', 'annguyen@gmail.com', '456231786', 'Nguyễn Văn An', '0901234121', 10000000, 1, 3, 1, 'annguyen@gmail.com'),
(2, '22 Yên Bái, Đà Nẵng', '1997-04-09', 'binhlv@gmail.com', '654231234', 'Lê Văn Bình', '0934212314', 7000000, 2, 2, 1, 'binhlv@gmail.com' ),
(3, 'K234/11 Điện Biên Phủ, Gia Lai', '1995-12-12', 'thiyen@gmail.com', '999231723', 'Hồ Thị Yến', '0412352315', 14000000, 2, 3, 1, 'thiyen@gmail.com'),
(4, '77 Hoàng Diệu, Quảng Trị', '1980-04-04', 'toan0404@gmail.com', '123231365', 'Võ Công Toản', '0374443232', 17000000, 4, 4, 1, 'toan0404@gmail.com'),
(5, '43 Yên Bái, Đà Nẵng', '1999-12-09', 'phatphat@gmail.com', '454363232', 'Nguyễn Bỉnh Phát', '0902341231', 6000000,	1, 1, 2, 'phatphat@gmail.com'),
(6, '294 Nguyễn Tất Thành, Đà Nẵng', '2000-11-08', 'annghi20@gmail.com', '964542311', 'Khúc Nguyễn An Nghi', '0978653213', 7000000, 3, 2, 2, 'annghi20@gmail.com'),
(7, '4 Nguyễn Chí Thanh, Huế', '1993-01-01', 'nhh0101@gmail.com', '534323231', 'Nguyễn Hữu Hà', '0941234553', 8000000, 2, 3, 2, 'nhh0101@gmail.com'),
(8, '111 Hùng Vương, Hà Nội', '1989-09-03', 'donghanguyen@gmail.com', '234414123', 'Nguyễn Hà Đông', '064212311', 9000000,	4, 4, 2, 'donghanguyen@gmail.com'),
(9, '213 Hàm Nghi, Đà Nẵng', '1982-09-03', 'hoangtong@gmail.com', '256781231', 'Tòng Hoang', 6000000, '0245144444', 4, 4, 2, 'hoangtong@gmail.com'),
(10, '6 Hoà Khánh, Đồng Nai', '1994-01-08', 'nguyencongdao12@gmail.com', '755434343', 'Nguyễn Công Đạo', '0988767111', 8000000,	2, 3, 2, 'nguyencongdao12@gmail.com');

insert into contract (deposit, end_date, start_date, customer_id, employee_id, facility_id) 
values (0, '2020-12-08', '2020-12-08', 1, 3, 3),
(200000, '2020-07-21', '2020-07-14', 3,	5, 1),
(50000, '2021-03-17', '2021-03-15', 4, 3, 2),
(100000, '2021-01-18', '2021-01-14', 5,	2, 5),
(0, '2021-07-15', '2021-07-14', 2, 1, 6),
(0, '2021-06-03', '2021-06-01', 4, 2, 6);

insert into attach_facility (cost, `name`, `status`, unit) 
values (10000, 'Karaoke', 'tiện nghi hiện tại', 'giờ'),
(10000, 'Thuê xe máy', 'hỏng 1 xe', 'chiếc'),
(20000, 'Thuê xe đạp', 'tốt', 'chiếc'),	
(15000, 'Buffet buổi sáng', 'đầy đủ đồ ăn, tráng miệng', 'suất'),
(90000, 'Buffet buổi trưa', 'đầy đủ đồ ăn, tráng miệng', 'suất'),
(16000, 'Buffet buổi tối', 'đầy đủ đồ ăn, tráng miệng', 'suất');

insert into contract_detail (quantity , attach_facility_id, contract_id) 
values (5, 4, 2), (8, 5, 2), (15, 6, 2), (1, 1, 3), (11, 2, 3), (1, 3, 1), (2, 2, 1), (2, 2, 5);
