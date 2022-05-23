package bai_tap_tong_hop.model;

import bai_tap_tong_hop.service.IPersonService;

public class QuanLy extends NhanVien implements IPersonService {
    private double luongCoBan;
    private double heSoLuonng;

    public QuanLy() {
    }

    @Override
    public double employeeSalaryCalculation() {
        return luongCoBan * heSoLuonng;
    } // Đa hình ở runtime khi phương thức ghi đè cùng tên cùng tham số cùng kiểu dữ liệu trả về

    public QuanLy(String name, int age, String address, double luongCoBan, double heSoLuonng) {
        super(name, age, address);
        this.luongCoBan = luongCoBan;
        this.heSoLuonng = heSoLuonng;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getHeSoLuonng() {
        return heSoLuonng;
    }

    public void setHeSoLuonng(double heSoLuonng) {
        this.heSoLuonng = heSoLuonng;
    }

    @Override
    public String toString() {
        return "QuanLy{" + super.toString() +
                ", luongCoBan=" + luongCoBan +
                ", heSoLuonng=" + heSoLuonng +
                ", luong= " + employeeSalaryCalculation() +
                '}';
    }

    @Override
    public void timeKeeping() {
        System.out.println("Thank you!");
    }
}
