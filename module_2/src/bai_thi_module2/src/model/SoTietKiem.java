package model;

import java.time.LocalDate;

public abstract class SoTietKiem {
    private String maSoSo;
    private String maKhachHang;
    private LocalDate ngayMoSo;
    private LocalDate thoiGianBatDau;
    private double soTienGui;
    private String laiSuat;

    public SoTietKiem() {
    }

    public SoTietKiem(String maSoSo, String maKhachHang, LocalDate ngayMoSo, LocalDate thoiGianBatDau, double soTienGui, String laiSuat) {
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatDau = thoiGianBatDau;
        this.soTienGui = soTienGui;
        this.laiSuat = laiSuat;
    }

    public String getMaSoSo() {
        return maSoSo;
    }

    public void setMaSoSo(String maSoSo) {
        this.maSoSo = maSoSo;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public LocalDate getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(LocalDate ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public LocalDate getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo=" + ngayMoSo +
                ", thoiGianBatDau=" + thoiGianBatDau +
                ", soTienGui=" + soTienGui +
                ", laiSuat='" + laiSuat + '\'' +
                '}';
    }
}
