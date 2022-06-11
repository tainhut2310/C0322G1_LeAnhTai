package controllers;

import exception.CheckException;
import service.impl.SoTietKiemImpl;

import java.util.Scanner;

public class SotTietKiemController {
    public static Scanner scanner = new Scanner(System.in);
    public static SoTietKiemImpl soTietKiem = new SoTietKiemImpl();

    public static void displayMenu() {
        int choose;
        do {
            System.out.println("-CHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM-");
            System.out.println("1.\tAdd new");
            System.out.println("2.\tDelete");
            System.out.println("3.\tDisplay list");
            System.out.println("4.\tExit");
            System.out.print("Choose Option: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                   soTietKiem.addNew();
                    break;
                case 2:
                  soTietKiem.delete();
                    break;
                case 3:
                    soTietKiem.display();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.print("Không có lựa chọn trên! Xin vui lòng chọn lại");
            }
        } while (true);
    }
}
