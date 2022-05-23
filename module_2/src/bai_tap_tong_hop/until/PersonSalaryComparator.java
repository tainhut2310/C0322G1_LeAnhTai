package bai_tap_tong_hop.until;

import bai_tap_tong_hop.model.NhanVien;

import java.util.Comparator;

public class PersonSalaryComparator implements Comparator<NhanVien> {
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (o1.employeeSalaryCalculation() > o2.employeeSalaryCalculation()) {
            return 1;
        } else if (o1.employeeSalaryCalculation() < o2.employeeSalaryCalculation()) {
            return -1;
        } else {
            if (o1.getName().compareTo(o2.getName()) > 0) {
                return -1;
            } else if (o1.getName().compareTo(o2.getName()) < 0) {
                return 1;
            } else {
                return 1;
            }
        }
    }
}
