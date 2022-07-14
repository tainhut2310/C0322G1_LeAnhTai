drop database if exists quan_ly_nha_cung_cap_vat_tu;

create database if not exists quan_ly_nha_cung_cap_vat_tu;

use quan_ly_nha_cung_cap_vat_tu;

CREATE TABLE vat_tu (
    ma_vtu INT AUTO_INCREMENT PRIMARY KEY,
    ten_vtu VARCHAR(50) NOT NULL
);

CREATE TABLE phieu_nhap (
    so_pn INT AUTO_INCREMENT PRIMARY KEY,
    ngay_nhap DATE NOT NULL
);

CREATE TABLE phieu_xuat (
    so_px INT AUTO_INCREMENT PRIMARY KEY,
    ngay_xuat DATE NOT NULL
);

CREATE TABLE don_dat_hang (
    so_dh INT AUTO_INCREMENT PRIMARY KEY,
    ngay_dh DATE NOT NULL
);

CREATE TABLE nha_cung_cap (
    ma_ncc INT AUTO_INCREMENT PRIMARY KEY,
    ten_ncc VARCHAR(20) NOT NULL,
    dia_chi VARCHAR(50)
);

CREATE TABLE chi_tiet_phieu_xuat (
    ma_vtu INT,
    so_px INT,
    PRIMARY KEY (ma_vtu , so_px),
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px),
    dg_xuat DOUBLE NOT NULL,
    sl_xuat INT NOT NULL
);

CREATE TABLE chi_tiet_phieu_nhap (
    ma_vtu INT,
    so_pn INT,
    PRIMARY KEY (ma_vtu , so_pn),
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_pn),
    dg_nhap DOUBLE NOT NULL,
    sl_nhap INT NOT NULL
);

CREATE TABLE chi_tiet_don_dat_hang (
    ma_vtu INT,
    so_dh INT,
    PRIMARY KEY (ma_vtu , so_dh),
    FOREIGN KEY (ma_vtu)
        REFERENCES vat_tu (ma_vtu),
    FOREIGN KEY (so_dh)
        REFERENCES don_dat_hang (so_dh)
);

CREATE TABLE so_dien_thoai_ncc (
    ma_sdt INT PRIMARY KEY AUTO_INCREMENT,
    sdt VARCHAR(20),
    ma_ncc INT,
    FOREIGN KEY (ma_ncc)
        REFERENCES nha_cung_cap (ma_ncc)
);



