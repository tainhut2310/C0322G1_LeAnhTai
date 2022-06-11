package quan_ly_benh_vien.controllers;

import quan_ly_benh_vien.exception.CheckException;
import quan_ly_benh_vien.service.NormalVipService;

import java.util.Scanner;

public class MedicalRecordController {
    public static Scanner scanner = new Scanner(System.in);
    public static NormalVipService normalVipService = new NormalVipService();

    public static void menu() {
        int choose;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1.\tThêm mới");
            System.out.println("2.\tXóa");
            System.out.println("3.\tXem danh sách các bệnh án");
            System.out.println("4.\tThoát");
            System.out.print("Chọn chức năng: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    normalVipService.add();
                    break;
                case 2:
                    normalVipService.delete();
                    break;
                case 3:
                    normalVipService.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Chọn chức năng không có trong danh sách! Xin vui lòng chọn lại: ");
            }
        } while (true);
    }
}
