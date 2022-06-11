package services.impl;

import exception.CheckException;
import models.Employee;
import services.EmployeeService;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    static List<Employee> employeeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        employeeList = readFile();
        for (Employee item : employeeList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        employeeList = readFile();
        System.out.print("Nhập id: ");
        String idEmployee = checkId();

        System.out.print("Nhập tên nhân viên: ");
        String nameEmployee = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập ngày sinh: ");
        String ageEmployee = RegexData.regexAge(scanner.nextLine(), REGEX_DATE);

        System.out.println("Nhập giới tính: ");
        String genderEmployee = inputGender();

        System.out.print("Nhập CMND: ");
        String idCardEmployee = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập phone number: ");
        String phoneNumberEmployee = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập Email: ");
        String emailEmployee = CheckException.checkString(scanner.nextLine());

        System.out.println("Nhập trình độ: ");
        String levelEmployee = levelEmployee();

        System.out.println("Nhập vị trí: ");
        String workingPositionEmployee = placeEmployee();

        System.out.print("Nhập lương: ");
        double salaryEmployee = CheckException.checkParseDouble();

        Employee employee = new Employee(idEmployee, nameEmployee, ageEmployee, genderEmployee, idCardEmployee, phoneNumberEmployee,
                emailEmployee, levelEmployee, workingPositionEmployee, salaryEmployee);
        employeeList.add(employee);
        System.out.println("Đã thêm mới thành công!");
        writeFile();
    }

    public String levelEmployee() {
        String choose;
            System.out.println("1. Trung Cấp");
            System.out.println("2. Cao Đẳng");
            System.out.println("3. Đại Học");
            System.out.println("4. Sau đại học");
            System.out.print("Choose: ");
        do {
           choose = CheckException.checkString(scanner.nextLine());
            switch (choose) {
                case "1":
                    return "Trung Cấp";
                case "2":
                    return "Cao Đẳng";
                case "3":
                    return "Đại Học";
                case "4":
                    return "Sau đại học";
                default:
                    System.out.println("Nhập sai! Xin nhập lại:");
            }
        } while (true);
    }

    public String placeEmployee() {
        String choose;
            System.out.println("1. Lễ tân");
            System.out.println("2. Phục vụ");
            System.out.println("3. Chuyên viên");
            System.out.println("4. Giám sát");
            System.out.println("5. Quản lý");
            System.out.println("6. Giám đốc");
            System.out.print("Choose: ");
        do {
            choose = CheckException.checkString(scanner.nextLine());
            switch (choose) {
                case "1":
                    return "Lễ tân";
                case "2":
                    return "Phục vụ";
                case "3":
                    return "Chuyên viên";
                case "4":
                    return "Giám sát";
                case "5":
                    return "Quản lý";
                case "6":
                    return "Giám đốc";
                default:
                    System.out.println("Nhập sai! Xin nhập lại:");
            }
        } while (true);
    }

    public String inputGender() {
        String choose;
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.println("3. Giới tính thứ 3");
            System.out.print("Choose: ");
        do {
            choose = CheckException.checkString(scanner.nextLine());
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

    @Override
    public void edit() {
        employeeList = readFile();
        System.out.print("Nhập id bạn muốn edit: ");
        String placeEdit;
        boolean check = false;
        do {
            placeEdit = scanner.nextLine();
            for (Employee employee : employeeList) {
                if (placeEdit.equals(employee.getId())) {
                    check = true;
                    System.out.print("Nhập new id: ");
                    String idEmployee = checkId();
                    employee.setId(idEmployee);

                    System.out.print("Nhập tên nhân viên: ");
                    String nameEmployee = CheckException.checkString(scanner.nextLine());
                    employee.setName(nameEmployee);

                    System.out.print("Nhập ngày sinh: ");
                    String ageEmployee = RegexData.regexAge(scanner.nextLine(), REGEX_DATE);
                    employee.setDateOfBirth(ageEmployee);


                    System.out.println("Nhập giới tính");
                    String genderEmployee = inputGender();
                    employee.setGender(genderEmployee);

                    System.out.print("Nhập CMND: ");
                    String idCardEmployee = CheckException.checkString(scanner.nextLine());
                    employee.setIdCard(idCardEmployee);

                    System.out.print("Nhập phone number: ");
                    String phoneNumberEmployee = CheckException.checkString(scanner.nextLine());
                    employee.setPhoneNumber(phoneNumberEmployee);


                    System.out.print("Nhập Email: ");
                    String emailEmployee = CheckException.checkString(scanner.nextLine());
                    employee.setEmail(emailEmployee);

                    System.out.println("Nhập trình độ: ");
                    String levelEmployee = levelEmployee();
                    employee.setLevel(levelEmployee);

                    System.out.println("Nhập vị trí: ");
                    String workingPositionEmployee = placeEmployee();
                    employee.setWorkingPosition(workingPositionEmployee);

                    System.out.print("Nhập lương: ");
                    double salaryEmployee = CheckException.checkParseDouble();
                    employee.setSalary(salaryEmployee);

                    System.out.println("Đã edit thành công!");
                    break;
                }
            }
            if (!check) {
                System.out.print("Id bạn muốn edit không tồn tại! Xin vui lòng nhập lại: ");
            }
        } while (!check);
        writeFile();
    }

    public void writeFile() {
        StringBuilder line = new StringBuilder();
        for (Employee item : employeeList) {
            line.append(item.getInfo());
        }
        ReadAndWrite.writeFile("src\\data\\employee.csv", line.toString());
    }

    public List<Employee> readFile() {
        List<String[]> listStr = ReadAndWrite.readFile("src\\data\\employee.csv");
        employeeList.clear();
        for (String[] item : listStr) {
            Employee employee = new Employee(item[0],
                    item[1],
                    item[2],
                    item[3],
                    item[4],
                    item[5],
                    item[6],
                    item[7],
                    item[8],
                    Double.parseDouble(item[9]));
            employeeList.add(employee);
        }
        return employeeList;
    }

    public String checkId() {
        employeeList = readFile();
        String temp;
        boolean check = true;
        if (employeeList.isEmpty()) {
            temp = CheckException.checkString(scanner.nextLine());
            return temp;
        } else {
            do {
                check = false;
                temp = CheckException.checkString(scanner.nextLine());
                for (Employee item : employeeList) {
                    if (temp.equals(item.getId())) {
                        System.out.print("ID đã tồn tại! Xin vui lòng nhập lại: ");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    return temp;
                }
            } while (true);
        }
    }
}
