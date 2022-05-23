package bai_tap_tong_hop.service;

import bai_tap_tong_hop.model.CongNhat;
import bai_tap_tong_hop.model.NhanVien;
import bai_tap_tong_hop.model.QuanLy;
import bai_tap_tong_hop.model.SanXuat;

import java.util.Map;
import java.util.TreeMap;

public class PersonServiceMap {
    public static Map<Integer, NhanVien> nhanVienMap = new TreeMap<>();

    static {
        nhanVienMap.put(1, new QuanLy("Tran Van Hung", 32, "Da Nang", 7000000, 4.4));
        nhanVienMap.put(3, new CongNhat("Le Thi Linh", 28, "Da Nang", 22));
        nhanVienMap.put(2, new SanXuat("Nguyen Phi Long", 32, "Da Nang", 700));
        nhanVienMap.put(6, new CongNhat("Nguyen Thi Hong", 25, "Ha Noi", 20));
        nhanVienMap.put(5, new SanXuat("Nguyen Thi Hoa", 25, "Ha Noi", 400));
        nhanVienMap.put(4, new QuanLy("Nguyen Van Tung ", 25, "Ha Noi", 7000000, 4.4));
    }

    public void displayListMap() {
        for (Integer item : nhanVienMap.keySet()) {
            if (nhanVienMap.containsKey(item)) {
                System.out.println(nhanVienMap.get(item));
            }
        }
    }
}
