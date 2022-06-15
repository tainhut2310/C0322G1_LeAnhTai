create database quan_ly_nha_cung_cap_vat_tu;
use quan_ly_nha_cung_cap_vat_tu;
create table vat_tu(
ma_vtu int auto_increment primary key,
ten_vtu varchar(50) not null
);
create table phieu_nhap(
so_pn int auto_increment primary key,
ngay_nhap date not null
);
create table phieu_xuat(
so_px int auto_increment primary key,
ngay_xuat date not null
);
create table don_dh(
so_dh int auto_increment primary key,
ngay_dh date not null
);
create table nha_cc(
ma_ncc int auto_increment primary key,
ten_ncc varchar(20) not null,
dia_chi varchar(50)
);
create table chi_tiet_px(
ma_vtu int,
so_px int,
primary key (ma_vtu, so_px),
unique (ma_vtu, so_px),
foreign key (ma_vtu) references vat_tu (ma_vtu),
foreign key (so_px) references phieu_xuat (so_px),
don_gia_xuat double not null,
so_luong_xuat int not null
);
create table chi_tiet_pn(
ma_vtu int,
so_pn int,
primary key (ma_vtu, so_pn),
unique (ma_vtu, so_pn),
foreign key (ma_vtu) references vat_tu (ma_vtu),
foreign key (so_pn) references phieu_nhap (so_pn),
don_gia_nhap double not null,
so_luong_nhap int not null
);
create table chi_tiet_ddh(
ma_vtu int,
so_dh int,
primary key (ma_vtu, so_dh),
unique (ma_vtu, so_dh),
foreign key (ma_vtu) references vat_tu (ma_vtu),
foreign key (so_dh) references don_dh (so_dh),
ngay_dh date not null,
ma_ncc int not null,
foreign key (ma_ncc) references nha_cc (ma_ncc)
);
create table nha_cc_sdt(
ma_ncc int auto_increment,
sdt varchar(20),
primary key (ma_ncc, sdt),
foreign key (ma_ncc) references nha_cc (ma_ncc)
);


