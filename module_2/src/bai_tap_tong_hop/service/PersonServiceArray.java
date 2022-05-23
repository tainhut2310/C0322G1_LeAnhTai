package bai_tap_tong_hop.service;

import bai_tap_tong_hop.model.CongNhat;
import bai_tap_tong_hop.model.NhanVien;
import bai_tap_tong_hop.model.QuanLy;
import bai_tap_tong_hop.model.SanXuat;

import java.util.*;

public class PersonServiceArray {
    public static NhanVien[] nhanViens = new NhanVien[1000];
    public static int count;
    public static Scanner scanner = new Scanner(System.in);

    static {
        nhanViens[0] = new QuanLy("Nguyen Van Teo", 30, "Ha Noi", 8000000, 4.0);
        nhanViens[1] = new CongNhat("Nguyen Van Ti", 28, "Ha Noi", 25);
        nhanViens[3] = new SanXuat("Nguyen Thi Tuyet", 25, "Ha Noi", 500);
        nhanViens[4] = new CongNhat("Nguyen Thi Hong", 25, "Ha Noi", 20);
        nhanViens[5] = new SanXuat("Nguyen Thi Hoa", 25, "Ha Noi", 400);
        nhanViens[2] = new QuanLy("Nguyen Van Tung ", 25, "Ha Noi", 9000000, 4.5);
        count = 6;
    }

    public void displayList() {
        for (NhanVien item : nhanViens) { // instanceof kiểm tra xem kiểu dữ liệu in ra có đúng với kiểu thực tế hay không,
            if (item instanceof QuanLy) { // nếu đúng trả về true ngược lại sai trả về false, đồng thòi sẽ kiểm tra những đối
                System.out.println(item); // tượng bị null thì sẽ không hiển thị
            }
        }
        for (NhanVien item : nhanViens) { //  nếu có 1001 nhân viên trong công ty thì bộ nhớ không đủ để chứa dẫn đến chương trình bị lỗi
            if (item instanceof CongNhat) {
                System.out.println(item);
            }
        }
        for (NhanVien item : nhanViens) {
            if (item instanceof SanXuat) {
                System.out.println(item);
            }
        }
    }
}
