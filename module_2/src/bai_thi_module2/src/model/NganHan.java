package model;

import java.time.LocalDate;

public abstract class NganHan extends SoTietKiem {
    public NganHan() {
    }

    public NganHan(String maSoSo, String maKhachHang, LocalDate ngayMoSo, LocalDate thoiGianBatDau, double soTienGui, String laSuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laSuat);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
