package quan_ly_person.controllers;

import quan_ly_person.exception.CheckException;
import quan_ly_person.service.StudentTeacherImpl;

import java.util.Scanner;

public class PersonController {
    public static Scanner scanner = new Scanner(System.in);
    public static StudentTeacherImpl studentTeacher = new StudentTeacherImpl();

    public static void displayMenu() {
        int choose;
        do {
            System.out.println("-CHƯƠNG TRÌNH QUẢN LÝ GIÁO VIÊN VÀ SINH VIÊN-");
            System.out.println("1.\tDisplay list");
            System.out.println("2.\tAdd new");
            System.out.println("3.\tDelete");
            System.out.println("4.\tSort");
            System.out.println("5.\tEdit");
            System.out.println("6.\tExit");
            System.out.print("Choose Option: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    studentTeacher.display();
                    break;
                case 2:
                    studentTeacher.addNew();
                    break;
                case 3:
                    studentTeacher.delete();
                    break;
                case 4:
                    studentTeacher.sort();
                    break;
                case 5:
                    studentTeacher.edit();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.print("Không có lựa chọn trên! Xin vui lòng chọn lại");
            }
        } while (true);
    }
}
