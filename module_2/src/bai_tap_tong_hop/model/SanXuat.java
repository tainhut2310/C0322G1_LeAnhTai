package bai_tap_tong_hop.model;

import bai_tap_tong_hop.service.IPersonService;

public class SanXuat extends NhanVien implements IPersonService {
    private int soSanPham;
    private static double timeKeeping;

    public SanXuat() {
    }

    public SanXuat(String name, int age, String address, int soSanPham) {
        super(name, age, address);
        this.soSanPham = soSanPham;
    }

    public int getSoSanPham() {
        return soSanPham;
    }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }

    @Override
    public String toString() {
        return "SanXuat{" + super.toString() +
                " soSanPham=" + soSanPham +
                " luong=" + employeeSalaryCalculation() +
                '}';
    }

    @Override
    public void timeKeeping() {
        System.out.println("Thank you");
    }

    @Override
    public double employeeSalaryCalculation() {
        return soSanPham * 50000;
    }
}
