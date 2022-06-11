package quan_ly_person.service;

import quan_ly_person.controllers.PersonController;
import quan_ly_person.exception.CheckException;
import quan_ly_person.model.Person;
import quan_ly_person.model.Student;
import quan_ly_person.model.Teacher;
import quan_ly_person.util.ReadAndWriteFile;
import quan_ly_person.util.RegexData;
import quan_ly_person.util.SortByDateComparator;
import quan_ly_person.util.SortByNameComparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentTeacherImpl implements IStudentTeacher {
    public static Scanner scanner = new Scanner(System.in);
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_INT = "[1-9][0-9]*";
    public static final String REGEX_DOUBLE = "^[0-9]{1,2}[.][0-9]{1}$";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static List<Student> studentList = new LinkedList<>();
    public static List<Teacher> teacherList = new LinkedList<>();

    @Override
    public void display() {
        studentList = readFileStudent();
        teacherList = readFileTeacher();
        if (studentList.isEmpty() && teacherList.isEmpty()) {
            System.out.println("Danh sách đang trống! Vui lòng thêm mới");
        }
        for (Student item : studentList) {
            System.out.println(item);
        }
        for (Teacher item : teacherList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        int choose;
        do {
            System.out.println("1.\tThêm mới học sinh");
            System.out.println("2.\tThêm mới giáo viên");
            System.out.println("3.\tExit");
            System.out.print("Chọn: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    inputStudent();
                    break;
                case 2:
                    inputTeacher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng chọn lại");
            }
        } while (true);
    }

    @Override
    public void delete() {
        display();
        int choose;
        do {
            System.out.println("1.\tDelete học viên");
            System.out.println("2.\tDelete giáo viên");
            System.out.println("3.\tExit");
            System.out.print("Chọn: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    deleteStudent();
                    break;
                case 2:
                    deleteTeacher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public void sort() {
        studentList = readFileStudent();
        teacherList = readFileTeacher();
        List<Person> personList = new ArrayList<>(studentList);
        personList.addAll(teacherList);
        int choose;
        do {
            System.out.println("1.\tSắp xếp theo tên");
            System.out.println("2.\tSắp xếp theo ngày sinh");
            System.out.println("3.\tExit");
            System.out.print("Chọn: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    personList.sort(new SortByNameComparator());
                    for (Person item : personList) {
                        System.out.println(item);
                    }
                    break;
                case 2:
                    personList.sort(new SortByDateComparator());
                    for (Person item : personList) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Không có lựa chọn trên! Xin vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public void edit() {
        display();
        int choose;
        do {
            System.out.println("1.\tEdit học viên");
            System.out.println("2.\tEdit giáo viên");
            System.out.println("3.\tExit");
            System.out.print("Chọn: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    editStudent();
                case 2:
                    editTeacher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng nhập lại");
            }
        } while (true);
    }

    //Hàm đọc ghi File put vào list----------------------------------------------------------------------------------------------
    public List<Student> readFileStudent() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\quan_ly_person\\data\\student.csv");
        studentList.clear();
        for (String[] item : list) {
            Student student = new Student(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    LocalDate.parse(item[3]),
                    item[4],
                    item[5],
                    Double.parseDouble(item[6]));
            studentList.add(student);
        }
        return studentList;
    }

    public void writeFileStudent() {
        StringBuilder line = new StringBuilder();
        for (Student item : studentList) {
            line.append(item.getInfo());
        }
        ReadAndWriteFile.writeFile("src\\quan_ly_person\\data\\student.csv", line.toString());
    }

    public List<Teacher> readFileTeacher() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\quan_ly_person\\data\\teacher.csv");
        teacherList.clear();
        for (String[] item : list) {
            Teacher teacher = new Teacher(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    LocalDate.parse(item[3]),
                    item[4],
                    item[5],
                    Double.parseDouble(item[6]),
                    Double.parseDouble(item[7]));
            teacherList.add(teacher);
        }
        return teacherList;
    }

    public void writeFileTeacher() {
        StringBuilder line = new StringBuilder();
        for (Teacher item : teacherList) {
            line.append(item.getInfo());
        }
        ReadAndWriteFile.writeFile("src\\quan_ly_person\\data\\teacher.csv", line.toString());
    }

    //Hàm input thông số và add vào file---------------------------------------------------------------------------------------
    public void inputStudent() {
        studentList = readFileStudent();
        System.out.print("Nhập ID: ");
        int id = CheckException.checkParseInt();

        System.out.print("Nhập tên: ");
        String name = CheckException.checkString(scanner.nextLine());

        System.out.println("Nhập giới tính: ");
        String gender = inputGender();

        System.out.print("Nhập ngày sinh: ");
        LocalDate birthday = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập địa chỉ: ");
        String address = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập mã sinh viên:");
        String studentCode = checkIdStudent();

        System.out.print("Nhập điểm trung bình: ");
        double dtb;
        boolean check = true;
        do {
            dtb = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_DOUBLE, "Nhập sai định dạng! Xin vui lòng nhập lại: "));
            if (dtb > 10) {
                check = false;
                System.out.print("Nhập điểm sai! Xin vui lòng nhập lại: ");
            } else {
                check = true;
            }
        } while (!check);


        Student student = new Student(id, name, gender, birthday, address, studentCode, dtb);
        studentList.add(student);
        System.out.println("Đã thêm mới thành công!");
        writeFileStudent();
    }

    public void inputTeacher() {
        teacherList = readFileTeacher();
        System.out.print("Nhập ID:");
        int id = quan_ly_person.exception.CheckException.checkParseInt();

        System.out.print("Nhập tên: ");
        String name = CheckException.checkString(scanner.nextLine());

        System.out.println("Nhập giói tính: ");
        String gender = inputGender();

        System.out.print("Nhập ngày sinh: ");
        LocalDate birthday = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập địa chỉ: ");
        String address = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập tên lớp dạy: ");
        String lopDay = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập lương một giờ dạy: ");
        double luongMotGio = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_INT, "Số nhập vào phải là số dương! Xin vui lòng nhập lại:"));

        System.out.print("Nhập số giờ dạy trong tháng: ");
        double soGioTrongThang = Double.parseDouble(RegexData.regexStr(scanner.nextLine(), REGEX_INT, "Số nhập vào phải là số dương! Xin vui lòng nhập lại:"));

        Teacher teacher = new Teacher(id, name, gender, birthday, address, lopDay, luongMotGio, soGioTrongThang);
        teacherList.add(teacher);
        System.out.println("Đã thêm mới thành công!");
        writeFileTeacher();
    }

    //Hàm delete------------------------------------------------------------------------------------------------------------
    public void deleteStudent() {
        System.out.print("Nhập mã học viên cần xóa: ");
        int deleteCode;
        boolean check = true;
        int choose;
        studentList = readFileStudent();
        do {
            deleteCode = CheckException.checkParseInt();
            for (Student item : studentList) {
                if (deleteCode == item.getId()) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            studentList.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFileStudent();
                            display();
                            break;
                        case 2:
                            PersonController.displayMenu();
                            break;
                    }
                    break;
                }
            }
            if (check) {
                System.out.print("Không tìm mã phù hợp! Xin vui lòng chọn lại: ");
            }
        } while (check);
    }

    public void deleteTeacher() {
        System.out.print("Nhập mã giáo viên cần xóa: ");
        int deleteCode;
        boolean check = true;
        int choose;
        teacherList = readFileTeacher();
        do {
            deleteCode = CheckException.checkParseInt();
            for (Teacher item : teacherList) {
                if (deleteCode == item.getId()) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            teacherList.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFileTeacher();
                            display();
                            break;
                        case 2:
                            PersonController.displayMenu();
                            break;
                    }
                    break;
                }
            }
            if (check) {
                System.out.print("Không tìm mã phù hợp! Xin vui lòng chọn lại: ");
            }
        } while (check);
    }

    //Hàm edit--------------------------------------------------------------------------------------------------------
    public void editStudent() {
        display();
        System.out.print("Nhập mã cần edit: ");
        int deleteCode;
        boolean check = true;
        studentList = readFileStudent();
        do {
            deleteCode = CheckException.checkParseInt();
            for (Student student : studentList) {
                if (deleteCode == student.getId()) {
                    check = false;
                    System.out.print("Nhập new ID :");
                    int id = CheckException.checkParseInt();
                    student.setId(id);

                    System.out.print("Nhập tên: ");
                    String name = CheckException.checkString(scanner.nextLine());
                    student.setName(name);

                    System.out.println("Nhập giới tính: ");
                    String gender = inputGender();
                    student.setGender(gender);

                    System.out.print("Nhập ngày sinh: ");
                    LocalDate birthday = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);
                    student.setBirthday(birthday);

                    System.out.print("Nhập địa chỉ: ");
                    String address = CheckException.checkString(scanner.nextLine());
                    student.setAddress(address);

                    System.out.print("Nhập mã sinh viên:");
                    String studentCode = CheckException.checkString(scanner.nextLine());
                    student.setStudentCode(studentCode);

                    System.out.print("Nhập điểm trung bình: ");
                    double dtb = CheckException.checkParseInt();
                    student.setDtb(dtb);

                    System.out.println("Đã edit thành công!");
                    writeFileStudent();
                    break;
                }
            }
            if (check) {
                System.out.print("Id bạn muốn edit không tồn tại! Xin nhập lại: ");
            }
        } while (true);
    }

    public void editTeacher() {
        display();
        System.out.print("Nhập mã cần edit: ");
        int deleteCode;
        boolean check = true;
        teacherList = readFileTeacher();
        do {
            deleteCode = CheckException.checkParseInt();
            for (Teacher teacher : teacherList)
                if (deleteCode == teacher.getId()) {
                    check = false;
                    System.out.print("Nhập new ID:");
                    int id = CheckException.checkParseInt();
                    teacher.setId(id);

                    System.out.print("Nhập tên: ");
                    String name = CheckException.checkString(scanner.nextLine());
                    teacher.setName(name);

                    System.out.println("Nhập giói tính: ");
                    String gender = inputGender();
                    teacher.setGender(gender);

                    System.out.print("Nhập ngày sinh: ");
                    LocalDate birthday = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);
                    teacher.setBirthday(birthday);

                    System.out.print("Nhập địa chỉ: ");
                    String address = CheckException.checkString(scanner.nextLine());
                    teacher.setAddress(address);

                    System.out.print("Nhập tên lớp dạy:");
                    String lopDay = CheckException.checkString(scanner.nextLine());
                    teacher.setLopDay(lopDay);

                    System.out.print("Nhập lương một giờ dạy");
                    double luongMotGio = CheckException.checkParseInt();
                    teacher.setLuongMotGio(luongMotGio);

                    System.out.print("Nhập số giờ dạy trong tháng:");
                    double soGioTrongThang = CheckException.checkParseInt();
                    teacher.setSoGioTrongThang(soGioTrongThang);
                    break;
                }
            if (check) {
                System.out.print("Id bạn muốn edit không tồn tại! Xin nhập lại: ");
            }
        } while (true);
    }

    //Hàm kiểm tra ID------------------------------------------------------------------------------------------------------
    public String checkIdStudent() {
        String temp;
        studentList = readFileStudent();
        boolean check = true;
        if (studentList.isEmpty()) {
            temp = CheckException.checkString(scanner.nextLine());
            return temp;
        } else {
            do {
                check = false;
                temp = CheckException.checkString(scanner.nextLine());
                for (Student item : studentList) {
                    if (temp.equals(item.getStudentCode())) {
                        System.out.print("ID đã tồn tại! Xin vui lòng nhập lại: ");
                        check = true;
                        break;
                    }
                }
            } while (check);
        }
        return temp;
    }

    //Hàm input giới tính----------------------------------------------------------------------------------------
    public String inputGender() {
        String choose;
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Giới tính thứ 3");
        System.out.print("Choose: ");
        do {
            choose = quan_ly_cong_ty_abc.exception.CheckException.checkString(scanner.nextLine());
            switch (choose) {
                case "1":
                    return "Nam";
                case "2":
                    return "Nữ";
                case "3":
                    return "Giới tính thứ 3";
                default:
                    System.out.println("Nhập sai! Xin nhập lại");
            }
        } while (true);
    }
}
