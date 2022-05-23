package bai_tap_tong_hop.service;

import bai_tap_tong_hop.model.CongNhat;
import bai_tap_tong_hop.model.NhanVien;
import bai_tap_tong_hop.model.QuanLy;
import bai_tap_tong_hop.model.SanXuat;
import bai_tap_tong_hop.until.PersonNameComparator;
import bai_tap_tong_hop.until.PersonSalaryComparator;
import bai_tap_tong_hop.until.PersonSalaryComparatorAscending;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonServiceLinkedList {
    public static LinkedList<NhanVien> nhanVienLinkedList = new LinkedList<>();
    public static Scanner scanner = new Scanner(System.in);
    //Giả sử công ty ABC thay đổi nhân sự liên tục (xóa và thêm nhân viên) thì nên sử dụng LinkedList? Lý do?
    // Vì LinkedList hoạt động dựa trên cơ chế liên kết giữa các Node nên khi xóa hoặc thêm phần tử
    // chỉ cần ngắt hoặc thêm kết nối giữa hai node trước và sau phần tử muốn xóa, thêm
    // Ưu điểm của arrayList: Truy xuất phần tử nhanh hơn, sử dụng cho lưu trữ danh sách ít thay đổi thường xuyên tìm kiếm
    // Nhược điểm arrayList: tốc độ chèn xóa chậm hơn linkedlist
    //Ưu điểm của linkedlist: chèn xóa nhanh hơn, sử dụng cho lưu trữ danh sách thường xuyên thay đổi phần tử
    // Nhược điểm arrayList: tốc độ truy xuất phần tử chậm hơn linkedlist

    static {
        NhanVien nhanVien1 = new QuanLy("Tran Van Hung", 32, "Da Nang", 7000000, 4.4);
        NhanVien nhanVien2 = new CongNhat("Le Thi Linh", 28, "Da Nang", 22);
        NhanVien nhanVien3 = new SanXuat("Nguyen Phi Long", 32, "Da Nang", 700);
        NhanVien nhanVien4 = new CongNhat("Nguyen Thi Hong", 25, "Ha Noi", 20);
        NhanVien nhanVien5 = new SanXuat("Nguyen Thi Hoa", 25, "Ha Noi", 400);
        NhanVien nhanVien6 = new QuanLy("Nguyen Van Tung ", 25, "Ha Noi", 9000000, 4.5);
        nhanVienLinkedList.add(nhanVien1);
        nhanVienLinkedList.add(nhanVien2);
        nhanVienLinkedList.add(nhanVien3);
        nhanVienLinkedList.add(nhanVien4);
        nhanVienLinkedList.add(nhanVien5);
        nhanVienLinkedList.add(nhanVien6);
    }

    public void displayList() {
        for (NhanVien item : nhanVienLinkedList) {
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
                Collections.sort(nhanVienLinkedList, new PersonSalaryComparatorAscending());
                break;
            case 2:
                Collections.sort(nhanVienLinkedList, new PersonNameComparator());
            default:
                System.out.println("Không có lựa chọn trên!");
        }
    }
}
