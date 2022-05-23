package bai_tap_tong_hop.model;

import bai_tap_tong_hop.service.IPersonService;

public class CongNhat extends NhanVien implements IPersonService {
    private int soNgayCong;

    public CongNhat() { // Đa hình lúc compile thể hiện ở constructor khi 2 constructor khác tham số
    }

    public CongNhat(String name, int age, String address, int soNgayCong) {
        super(name, age, address);
        this.soNgayCong = soNgayCong;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    @Override
    public String toString() {
        return "CongNhat{" + super.toString() +
                ", soNgayCong=" + soNgayCong +
                ", luong= " + employeeSalaryCalculation() +
                '}';
    }

    @Override
    public double employeeSalaryCalculation() {
        return soNgayCong * 120000;
    }

    @Override
    public void timeKeeping() {
    }
}
