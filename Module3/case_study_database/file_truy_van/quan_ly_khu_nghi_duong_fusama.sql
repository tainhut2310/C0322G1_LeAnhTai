use quan_ly_khu_nghi_duong_fusama;
-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.

insert into vi_tri (ten_vi_tri) value ('Quản Lý'), ('Nhân Viên');

insert into trinh_do (ten_trinh_do) value ('Trung Cấp'), ('Cao Đẳng'), ('Đại Học'), ('Sau Đại Học');

insert into bo_phan (ten_bo_phan) value ('Sale-Marketing'), ('Hành chính'), ('Phục vụ'), ('Quản lý');

insert into nhan_vien (ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan)
value (1, 'Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1),
(2, 'Lê Văn Bình',	'1997-04-09', '654231234',	7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2,	2),
(3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000,	'0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai',	1, 3, 2),
(4, 'Võ Công Toản', '1980-04-04', '123231365',	17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
(5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng',	2, 1, 1),
(6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000,	'0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
(7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
(8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '064212311',	'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội',	2, 4, 4),
(9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
(10, 'Nguyễn Công Đạo',	'1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai',	2, 3, 2);

insert into loai_khach (ten_loai_khach) value ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');

insert into khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach) value
('Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 5),
('Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 3),
('Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 1),
('Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 1),
('Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 4),
('Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 4),
('Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 1),
('Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 3),
('Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 1),
('Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 2);

insert into kieu_thue (ten_kieu_thue) value ('year'), ('month'), ('day'), ('hour');

insert into loai_dich_vu (ten_loai_dich_vu) value ('Villa'), ('House'), ('Room');

insert into dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang, ma_kieu_thue, ma_loai_dich_vu) 
value ('Beach Front', 25000, 10000000, 10, 'vip', 'Có hồ bơi',	500, 4, 3, 1),
('House Princess 01', 14000, 5000000, 7, 'vip', 'Có thêm bếp nướng', null, 3, 2, 2),
('Room Twin 01', 5000, 1000000, 2, 'normal', 'Có tivi', null, null,	4, 3),
('Villa No Beach Front', 22000, 9000000, 8, 'normal', 'Có hồ bơi', 300, 3, 3, 1),
('House Princess 02', 10000, 4000000, 5, 'normal', 'Có thêm bếp nướng', null, 2, 3, 2),
('Room Twin 02', 3000, 900000, 2, 'normal', 'Có tivi', null, null, 4, 3);

insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai) 
value ('Karaoke', 10000, 'giờ' , 'tiện nghi hiện tại'),
('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');

insert into hop_dong (ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu) 
value ('2020-12-08', '2020-12-08', 0, 3, 1, 3),
('2020-07-14', '2020-07-21', 200000, 7,	3, 1),
('2021-03-15', '2021-03-17', 50000, 3, 4, 2),
('2021-01-14', '2021-01-18', 100000, 7,	5, 5),
('2021-07-14', '2021-07-15', 0,	7, 2, 6),
('2021-06-01', '2021-06-03', 0, 7, 7, 6),
('2021-09-02', '2021-09-05', 100000, 7, 4, 4),
('2021-06-17', '2021-06-18', 150000, 3, 4, 1),
('2020-11-19', '2020-11-19', 0, 3, 4, 3),
('2021-04-12', '2021-04-14', 0, 10, 3, 5),
('2021-04-25', '2021-04-25', 0, 2, 2, 1),
('2021-05-25', '2021-05-27', 0, 7, 10, 1);

insert into hop_dong_chi_tiet (so_luong, ma_hop_dong, ma_dich_vu_di_kem) 
value (5 ,2 , 4), (8, 2, 5), (15, 2, 6), (1, 3, 1), (11, 3, 2), (1, 1, 3), (2, 1, 2), (2, 12, 2);

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select n.* from nhan_vien n
where (n.ho_ten like "h%" or n.ho_ten like "t%" or n.ho_ten like "k%") and char_length(n.ho_ten) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select k.* from khach_hang k
where ((datediff(curdate(), k.ngay_sinh) / 365) between 18 and 50) and (k.dia_chi like '%Đà Nẵng' or k.dia_chi like '%Quảng Trị'); 

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select k.ma_khach_hang, k.ho_ten, count(h.ma_hop_dong) so_lan_dat_phong from khach_hang k
join hop_dong h on k.ma_khach_hang = h.ma_khach_hang
join loai_khach l on k.ma_loai_khach = l.ma_loai_khach
where l.ten_loai_khach = 'Diamond'
group by k.ma_khach_hang
order by so_lan_dat_phong;

-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select k.ma_khach_hang, k.ho_ten, l.ten_loai_khach, h.ma_hop_dong, d.ten_dich_vu,
h.ngay_lam_hop_dong, h.ngay_ket_thuc, (d.chi_phi_thue + ifnull(t.so_luong * dk.gia,0)) tong_tien from khach_hang k
left join hop_dong h on k.ma_khach_hang = h.ma_khach_hang
left join loai_khach l on k.ma_loai_khach = l.ma_loai_khach
left join dich_vu d on h.ma_dich_vu = d.ma_dich_vu
left join hop_dong_chi_tiet t on h.ma_hop_dong = t.ma_hop_dong
left join dich_vu_di_kem dk on t.ma_dich_vu_di_kem = dk.ma_dich_vu_di_kem
group by k.ma_khach_hang;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select d.ma_dich_vu, d.ten_dich_vu, d.dien_tich, d.chi_phi_thue, l.ten_loai_dich_vu from dich_vu d 
join hop_dong hd on d.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu l on d.ma_loai_dich_vu = l.ma_loai_dich_vu
where d.ma_dich_vu not in (select hd.ma_dich_vu from hop_dong hd 
join dich_vu d on hd.ma_dich_vu = d.ma_dich_vu
where (datediff('2021-03-30', hd.ngay_lam_hop_dong) between 0 and 90) and year(hd.ngay_lam_hop_dong) = '2021')
group by hd.ma_dich_vu
order by d.chi_phi_thue desc;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
select d.ma_dich_vu, d.ten_dich_vu, d.dien_tich, d.so_nguoi_toi_da, d.chi_phi_thue, l.ten_loai_dich_vu from dich_vu d 
join hop_dong hd on d.ma_dich_vu =  hd.ma_dich_vu
join loai_dich_vu l on d.ma_loai_dich_vu = l.ma_loai_dich_vu
where year(hd.ngay_lam_hop_dong) = '2020' and hd.ma_dich_vu not in (select hd.ma_dich_vu from hop_dong hd
join dich_vu d on hd.ma_dich_vu = d.ma_dich_vu
where year(hd.ngay_lam_hop_dong) = '2021')
group by d.ma_dich_vu;
 
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Cách 1:
select distinct kh.ho_ten from khach_hang kh;

-- Cách 2:
select kh.ho_ten from khach_hang kh
group by kh.ho_ten;

-- Cách 3
select kh.ho_ten from khach_hang kh
union
select kh.ho_ten from khach_hang kh;

-- 9.	Thực hiện thống kê doanh thu theo tháng, 
-- nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hop_dong.ngay_lam_hop_dong) as thang, count(hop_dong.ngay_lam_hop_dong) as so_luong_khach_hang from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = "2021"
group by month(hop_dong.ngay_lam_hop_dong)
order by month(hop_dong.ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
--  (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select h.ma_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc, ifnull(sum(ct.so_luong),0) as so_luong_dich_vu_di_kem from hop_dong h
left join hop_dong_chi_tiet ct on h.ma_hop_dong = ct.ma_hop_dong
left join dich_vu_di_kem dk on ct.ma_dich_vu_di_kem = dk.ma_dich_vu_di_kem
group by h.ma_hop_dong
order by h.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng 
-- bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select dk.ma_dich_vu_di_kem, dk.ten_dich_vu_di_kem from dich_vu_di_kem dk
join hop_dong_chi_tiet ct on dk.ma_dich_vu_di_kem = ct.ma_dich_vu_di_kem
join hop_dong h on ct.ma_hop_dong = h.ma_hop_dong
join khach_hang kh on h.ma_khach_hang = kh.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi like '%Vinh' or kh.dia_chi like '%Quảng Ngãi');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong, nv.ho_ten as ho_ten_nhan_vien, kh.ho_ten as ho_ten_khach_hang, 
kh.so_dien_thoai as so_dien_thoai_khach_hang, dv.ma_dich_vu, dv.ten_dich_vu, 
sum(ct.so_luong) as so_luong_dich_vu_di_kem, hd.tien_dat_coc from hop_dong_chi_tiet ct
join hop_dong hd on ct.ma_hop_dong = hd.ma_hop_dong
join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join dich_vu_di_kem dk on ct.ma_dich_vu_di_kem = dk.ma_dich_vu_di_kem
where ((datediff('2020-12-31', hd.ngay_lam_hop_dong) between 0 and 90) and year(hd.ngay_lam_hop_dong) = '2020')
and hd.ma_hop_dong not in (select hd.ma_hop_dong from hop_dong hd
where (datediff('2021-06-30', hd.ngay_lam_hop_dong) between 0 and 180) and year(hd.ngay_lam_hop_dong) = '2021')
group by hd.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất 
-- bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dk.ma_dich_vu_di_kem, dk.ten_dich_vu_di_kem, sum(ct.so_luong) as so_luong_dich_vu_di_kem from dich_vu_di_kem dk 
join hop_dong_chi_tiet ct on dk.ma_dich_vu_di_kem = ct.ma_dich_vu_di_kem
group by ct.ma_dich_vu_di_kem
having sum(ct.so_luong) >= all (select sum(ct.so_luong) from hop_dong_chi_tiet ct group by ct.ma_dich_vu_di_kem);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dk.ten_dich_vu_di_kem, count(dk.ma_dich_vu_di_kem) as so_lan_su_dung from dich_vu_di_kem dk
join hop_dong_chi_tiet ct on dk.ma_dich_vu_di_kem = ct.ma_dich_vu_di_kem
join hop_dong hd on ct.ma_hop_dong = hd.ma_hop_dong
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
group by ct.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by hd.ma_hop_dong;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm
--  ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
--  mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien, nv.ho_ten, tr.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
join trinh_do tr on nv.ma_trinh_do = tr.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
group by hd.ma_nhan_vien
having count(hd.ma_nhan_vien) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
update nhan_vien set statuses = 1 where nhan_vien.ma_nhan_vien in (select * from (select nv.ma_nhan_vien from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_hop_dong
where nv.ma_nhan_vien not in (select hd.ma_nhan_vien from hop_dong hd)) as cap_nhat);
select nv.ma_nhan_vien, nv.ho_ten from nhan_vien nv 
where nv.statuses = 0;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang set ma_loai_khach = 1
where khach_hang.ma_khach_hang = (
select * from (select kh.ma_khach_hang from khach_hang kh
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet ct on hd.ma_hop_dong = ct.ma_hop_dong
join dich_vu_di_kem dk on ct.ma_dich_vu_di_kem = dk.ma_dich_vu_di_kem
where (lk.ten_loai_khach = 'Platinium' and year(hd.ngay_lam_hop_dong) = '2021') and (dv.chi_phi_thue + ct.so_luong * dk.gia) >= 10000000) as cap_nhat);

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
update khach_hang set statuses = 1 where khach_hang.ma_khach_hang in (select * from (select kh.ma_khach_hang from khach_hang kh
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) < '2021') as cap_nhat);
select kh.ma_khach_hang, kh.ho_ten from khach_hang kh
where kh.statuses = 0;

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem set gia = gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem = (
select * from (select dk.ma_dich_vu_di_kem from dich_vu_di_kem dk 
join hop_dong_chi_tiet ct on dk.ma_dich_vu_di_kem = ct.ma_dich_vu_di_kem
join hop_dong hd on ct.ma_hop_dong = hd.ma_hop_dong
where year(hd.ngay_lam_hop_dong) = '2020' and ct.so_luong > 10) as cap_nhat);

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
--  thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select nv.ma_nhan_vien, nv.ho_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi from nhan_vien nv
union all
select kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi from khach_hang kh;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả 
-- các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một 
-- hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
create view v_nhan_vien as 
select nv.* from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where nv.dia_chi like '%Đà Nẵng' and hd.ngay_lam_hop_dong = '2021-04-25';
select * from v_nhan_vien;

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
update v_nhan_vien set v_nhan_vien.dia_chi = 'Hội An';

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng 
-- nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
-- Cách 1: Xóa logic
delimiter //
create procedure sp_xoa_khach_hang(in key_ma_khach_hang int)
begin 
update khach_hang set statuses = 1 where khach_hang.ma_khach_hang = key_ma_khach_hang;
end //
delimiter ;
call sp_xoa_khach_hang(10);

-- Cách 2: Xóa vĩnh viễn
delimiter //
create procedure sp_xoa_hop_dong_vinh_vien(in key_ma_hop_dong int)
begin 
delete hop_dong.* from hop_dong where hop_dong.ma_hop_dong = key_ma_hop_dong;
end //
delimiter ;
call sp_xoa_hop_dong_vinh_vien(13);
-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong
--  với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
--  với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
delimiter //
create procedure sp_them_moi_hop_dong(ma_hop_dong int,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
statuses int)
 begin 
 insert into hop_dong value (ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu, statuses);
 end //
 delimiter ;
 call sp_them_moi_hop_dong(13,'2022-02-22', '2022-03-23', 15000000, 1, 2, 3, 0)

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì 
-- hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

