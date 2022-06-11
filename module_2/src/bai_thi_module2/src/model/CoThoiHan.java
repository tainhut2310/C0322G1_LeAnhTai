package model;

import java.time.LocalDate;

public class CoThoiHan extends NganHan {
    private String kyHan;

    public CoThoiHan() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getMaSoSo(),
                getMaKhachHang(),
                getNgayMoSo(),
                getThoiGianBatDau(),
                getSoTienGui(),
                getLaiSuat(),
                getKyHan() + "\n");
    }

    public CoThoiHan(String maSoSo, String maKhachHang, LocalDate ngayMoSo, LocalDate thoiGianBatDau, double soTienGui, String laSuat, String kyHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laSuat);
        this.kyHan = kyHan;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "CoThoiHan{" + super.toString() +
                "kyHan='" + kyHan + '\'' +
                '}';
    }
}
