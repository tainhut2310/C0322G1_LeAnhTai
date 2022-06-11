package model;

import java.time.LocalDate;

public class DaiHan extends SoTietKiem {
    private String kyHan;
    private String uuDai;

    public DaiHan() {
    }

    public DaiHan(String maSoSo, String maKhachHang, LocalDate ngayMoSo, LocalDate thoiGianBatDau, double soTienGui, String laSuat, String kyHan, String uuDai) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laSuat);
        this.kyHan = kyHan;
        this.uuDai = uuDai;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                getMaSoSo(),
                getMaKhachHang(),
                getNgayMoSo(),
                getThoiGianBatDau(),
                getSoTienGui(),
                getLaiSuat(),
                getKyHan(),
                getUuDai() + "\n");

    }

    @Override
    public String toString() {
        return "DaiHan{" + super.toString() +
                "kyHan='" + kyHan + '\'' +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }
}
