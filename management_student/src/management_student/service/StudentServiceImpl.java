package management_student.service;

import management_student.model.Student;

import java.util.*;

public class StudentServiceImpl implements StudentService {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Student> listStudent = new ArrayList<>();
    public static int count;



    static {
        listStudent.add(new Student("Hiếu", 20, false, 1100));
        listStudent.add(new Student("Hiếu", 20, false, 1200));
        listStudent.add(new Student("Hiếu", 20, false, 1300));
        listStudent.add(new Student("Hiếu", 20, false, 100));
        listStudent.add(new Student("Hiếu", 20, false, 500));

//    Đếm xem trong mảng có bao nhiều phần tử.
        count = 5;
    }

    @Override
    public void displayListStudent() {

        for (Student item : listStudent) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void addNewStudent() {
        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Chọn giới tính: 1. Nam ;  2. Nữ ");
        int isGender = Integer.parseInt(scanner.nextLine());
        boolean gender = false;
        boolean checkGender = isGender == 1;
        if (checkGender) {
            gender = false;
        } else {
            gender = true;
        }
        System.out.println("Nhập Điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        Student student = new Student(name, age, gender, point);
        listStudent.set(count, student);
        count++;
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void removeStudent() {
//        System.out.println("Nhập Tên cần xóa: ");
//        String name = scanner.nextLine();
//        for (int i = 0; i < count; i++) {
//            if (name.equals(listStudent[i].getName())) {
//                System.out.println("Đã tìm thấy");
//            }
//        }
    }
}
