create database quan_ly_khu_nghi_duong_fusama;
use quan_ly_khu_nghi_duong_fusama;
create table vi_tri(
ma_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45) not null
);
create table trinh_do(
ma_trinh_do int auto_increment primary key,
ten_trinh_do varchar(45) not null
);
create table bo_phan(
ma_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45) not null
);
create table nhan_vien(
ma_nhan_vien int auto_increment primary key,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
unique (ma_vi_tri, ma_trinh_do, ma_bo_phan),
foreign key (ma_vi_tri) references vi_tri (ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do (ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan (ma_bo_phan)
);
create table loai_khach(
ma_loai_khach int auto_increment primary key,
ten_loai_khach varchar(45) not null
);
create table khach_hang(
ma_khach_hang int auto_increment primary key,
ma_loai_khach int not null,
foreign key (ma_loai_khach) references loai_khach (ma_loai_khach),
ho_ten varchar(45) not null,
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45)
);
create table kieu_thue(
ma_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45) not null
);
create table loai_dich_vu(
ma_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45) not null
);
create table dich_vu(
ma_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45) not null,
dien_tich int not null,
chi_phi_thue double not null,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
unique (ma_kieu_thue, ma_loai_dich_vu),
foreign key (ma_kieu_thue) references kieu_thue (ma_kieu_thue),
foreign key (ma_loai_dich_vu) references loai_dich_vu (ma_loai_dich_vu),
tieu_chuan_phong varchar(45) not null,
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double not null,
so_tang int not null
);
create table hop_dong(
ma_hop_dong int auto_increment primary key,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int not null,
ma_khach_hang int not null,
ma_dich_vu int not null,
unique (ma_nhan_vien, ma_khach_hang, ma_dich_vu),
foreign key (ma_nhan_vien) references nhan_vien (ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang (ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu (ma_dich_vu)
);
create table dich_vu_di_kem (
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia double not null,
trang_thai varchar(45)
);
create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment primary key,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
foreign key (ma_hop_dong) references hop_dong (ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem (ma_dich_vu_di_kem),
so_luong int
);



