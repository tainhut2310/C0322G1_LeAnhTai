package bai_tap_tong_hop.service;

import bai_tap_tong_hop.model.CongNhat;
import bai_tap_tong_hop.model.NhanVien;
import bai_tap_tong_hop.model.QuanLy;
import bai_tap_tong_hop.model.SanXuat;
import bai_tap_tong_hop.until.PersonNameComparator;
import bai_tap_tong_hop.until.PersonSalaryComparator;
import bai_tap_tong_hop.until.PersonSalaryComparatorAscending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PersonServiceArrayList {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<NhanVien> nhanVienList = new ArrayList<>();
    // Kích thước của arrayList có thể thay đổi được nên không cần khởi tạo 1000 phần tử trước
    // Nếu công ty có 1001 thì không có vấn đề gì vì kích thước của arrayList có thể thay đổi khi
    // kích thước vượt quá hệ thống tự động nhân kích thước lên 150%
    //Ưu điểm của arrayList so với array: Kích thước có thể thay đổi, cung cấp nhiều phương thức để thao tác
    // Nhược điểm: Chậm hơn array, chỉ có thể lưu trữ kiểu dữ liệu đối tượng

    static {
        NhanVien nhanVien1 = new QuanLy("Tran Van Hung", 32, "Da Nang", 7000000, 4.4);
        NhanVien nhanVien2 = new CongNhat("Le Thi Linh", 28, "Da Nang", 22);
        NhanVien nhanVien3 = new SanXuat("Nguyen Phi Long", 32, "Da Nang", 700);
        NhanVien nhanVien4 = new CongNhat("Nguyen Thi Hong", 25, "Ha Noi", 20);
        NhanVien nhanVien5 = new SanXuat("Nguyen Thi Hoa", 25, "Ha Noi", 400);
        NhanVien nhanVien6 = new QuanLy("Nguyen Van Tung ", 25, "Ha Noi", 7000000, 4.4);
        nhanVienList.add(nhanVien1);
        nhanVienList.add(nhanVien2);
        nhanVienList.add(nhanVien3);
        nhanVienList.add(nhanVien4);
        nhanVienList.add(nhanVien5);
        nhanVienList.add(nhanVien6);
    }

    public void displayList() {
        for (NhanVien item : nhanVienList) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public void sortPerson() {
        System.out.println("1. Sắp xếp theo lương tăng dần");
        System.out.println("2. Sắp xếp theo tên tăng dần");
        System.out.print("Choose options: ");
        int choose1 = Integer.parseInt(scanner.nextLine());
        switch (choose1) {
            case 1:
                Collections.sort(nhanVienList, new PersonSalaryComparatorAscending());
                break;
            case 2:
                Collections.sort(nhanVienList, new PersonNameComparator());
            default:
                System.out.println("Không có lựa chọn trên!");
        }

    }
}
