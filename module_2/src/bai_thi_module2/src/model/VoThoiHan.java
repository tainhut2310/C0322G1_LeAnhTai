package model;

import java.time.LocalDate;

public class VoThoiHan extends NganHan {

    public VoThoiHan() {
    }

    public VoThoiHan(String maSoSo, String maKhachHang, LocalDate ngayMoSo, LocalDate thoiGianBatDau, double soTienGui, String laSuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laSuat);
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",
                getMaSoSo(),
                getMaKhachHang(),
                getNgayMoSo(),
                getThoiGianBatDau(),
                getSoTienGui(),
                getLaiSuat() + "\n");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
