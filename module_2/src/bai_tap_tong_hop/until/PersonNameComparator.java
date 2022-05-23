package bai_tap_tong_hop.until;

import bai_tap_tong_hop.model.NhanVien;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<NhanVien> {
    //Muốn sử dụng comparator thì tạo 1 class và implement Comparator rồi override method compare
    //Muốn sử dụng comparable thì implement Comparable trên chính lớp muốn triển khai và override method compareTo
    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else if (o1.getName().compareTo(o2.getName()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
