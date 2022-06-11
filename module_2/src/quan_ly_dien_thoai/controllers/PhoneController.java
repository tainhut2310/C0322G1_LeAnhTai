package quan_ly_dien_thoai.controllers;

import quan_ly_benh_vien.exception.CheckException;
import quan_ly_dien_thoai.service.impl.PhoneImpl;

import java.util.Scanner;

public class PhoneController {
    public static Scanner scanner = new Scanner(System.in);
    public static PhoneImpl phone = new PhoneImpl();
    public static void displayMenu() {
        int choose;
        do {
        System.out.println("-CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI –");
        System.out.println("Chọn chức năng theo số (để tiếp tục);");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách điện thoại");
        System.out.println("4. Thoát");
        System.out.print("Chọn chức năng: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    phone.add();
                    break;
                case 2:
                    phone.delete();
                    break;
                case 3:
                    phone.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng nhập lại");
            }
        } while (true);
    }
}
