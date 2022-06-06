package quan_ly_cong_ty_abc.controller;

import quan_ly_cong_ty_abc.exception.CheckException;
import quan_ly_cong_ty_abc.service.StaffImpl;

import java.util.Scanner;

public class CompanyController {
    public static Scanner scanner = new Scanner(System.in);
    public static StaffImpl staff = new StaffImpl();

    public static void displayMenu() {
        int choose;
        do {
            System.out.println("-QUẢN LÝ NHÂN VIÊN CÔNG TY ABC-");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1.\tHiển thị danh sách");
            System.out.println("2.\tThêm mới nhân viên");
            System.out.println("3.\tXóa");
            System.out.println("4.\tTìm kiếm nhân viên");
            System.out.println("5.\tThoát");
            System.out.print("Chọn chức năng: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    staff.display();
                    break;
                case 2:
                    staff.add();
                    break;
                case 3:
                    staff.delete();
                    break;
                case 4:
                    staff.search();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Chọn chức năng không có trong danh sách! Xin vui lòng chọn lại!");
            }
        } while (true);
    }
}
