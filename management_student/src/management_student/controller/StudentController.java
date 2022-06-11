package management_student.controller;

import management_student.model.Student;
import management_student.service.StudentService;
import management_student.service.StudentServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class StudentController {

    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
    //      DI
     StudentService studentService = new StudentServiceImpl();


        int choose = -1;
        while (choose != 5) {
            System.out.println(" Quản lý học sinh");
            System.out.println(" 1.Danh sách học sinh");
            System.out.println(" 2.Thêm học sinh");
            System.out.println(" 3.Xóa học sinh");
            System.out.println(" 4.Tìm kiếm học sinh");
            System.out.println(" 5.Thoát chương trình");
            System.out.println("Chọn option: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    studentService.displayListStudent();
                    break;
                case 2:
                    studentService.addNewStudent();
                    break;
                case 3:
                    studentService.removeStudent();
                    menu();
                    break;
            }
        }

    }
}
