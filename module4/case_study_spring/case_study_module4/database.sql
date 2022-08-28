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
