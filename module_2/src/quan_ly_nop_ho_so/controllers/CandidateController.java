package quan_ly_nop_ho_so.controllers;

import quan_ly_person.exception.CheckException;

public class CandidateController {
    public static void displayMenu() {
        int choose;
        do {
            System.out.println("-CHƯƠNG TRÌNH QUẢN NỘP HỒ SƠ-");
            System.out.println("1.\tDisplay list");
            System.out.println("2.\tAdd new");
            System.out.println("3.\tDelete");
            System.out.println("4.\tSort");
            System.out.println("5.\tExit");
            System.out.print("Choose Option: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:

                    break;

                case 5:
                    System.exit(0);
                default:
                    System.out.print("Không có lựa chọn trên! Xin vui lòng chọn lại");
            }
        } while (true);
    }
}
