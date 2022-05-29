package services.impl;

import models.Employee;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee item : employeeList) {
            System.out.println(item.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.print("Nhập id: ");
        int idEmployee = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên nhân viên: ");
        String nameEmployee = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int ageEmployee = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giới tính");
        String genderEmployee = scanner.nextLine();
        System.out.print("Nhập CMND: ");
        String idCardEmployee = scanner.nextLine();
        System.out.print("Nhập phone number: ");
        String phoneNumberEmployee = scanner.nextLine();
        System.out.print("Nhập Email: ");
        String emailEmployee = scanner.nextLine();
        System.out.print("Nhập chức vụ: ");
        String levelEmployee = scanner.nextLine();
        System.out.print("Nhập vị trí: ");
        String workingPositionEmployee = scanner.nextLine();
        System.out.print("Nhập lương: ");
        double salaryEmployee = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(idEmployee, nameEmployee, ageEmployee, genderEmployee, idCardEmployee, phoneNumberEmployee,
                emailEmployee, levelEmployee, workingPositionEmployee, salaryEmployee);
        employeeList.add(employee);
        System.out.println("Đã thêm mới thành công!");
    }

    @Override
    public void edit() {
        System.out.print("Nhập id bạn muốn edit: ");
        int placeEdit = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == placeEdit) {
                check = true;
                System.out.print("Nhập id: ");
                int idEmployee = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập tên nhân viên: ");
                String nameEmployee = scanner.nextLine();
                System.out.print("Nhập tuổi: ");
                int ageEmployee = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập giới tính");
                String genderEmployee = scanner.nextLine();
                System.out.print("Nhập CMND: ");
                String idCardEmployee = scanner.nextLine();
                System.out.print("Nhập phone number: ");
                String phoneNumberEmployee = scanner.nextLine();
                System.out.print("Nhập Email: ");
                String emailEmployee = scanner.nextLine();
                System.out.print("Nhập chức vụ: ");
                String levelEmployee = scanner.nextLine();
                System.out.print("Nhập vị trí: ");
                String workingPositionEmployee = scanner.nextLine();
                System.out.print("Nhập lương: ");
                double salaryEmployee = Double.parseDouble(scanner.nextLine());
                employeeList.get(i).setId(idEmployee);
                employeeList.get(i).setName(nameEmployee);
                employeeList.get(i).setAge(ageEmployee);
                employeeList.get(i).setGender(genderEmployee);
                employeeList.get(i).setIdCard(idCardEmployee);
                employeeList.get(i).setPhoneNumber(phoneNumberEmployee);
                employeeList.get(i).setEmail(emailEmployee);
                employeeList.get(i).setLevel(levelEmployee);
                employeeList.get(i).setWorkingPosition(workingPositionEmployee);
                employeeList.get(i).setSalary(salaryEmployee);
            }
        }
        if (!check) {
            System.out.println("Id bạn muốn edit không tồn tại!");
        }
    }

    @Override
    public void delete() {

    }
}
