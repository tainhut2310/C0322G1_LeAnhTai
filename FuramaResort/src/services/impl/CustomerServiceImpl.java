package services.impl;

import models.Customer;
import services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customerList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer item : customerList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        System.out.print("Nhập id: ");
        int idCustomer = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên khách hàng: ");
        String nameCustomer = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int ageCustomer = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập giới tính: ");
        String genderCustomer = scanner.nextLine();
        System.out.print("Nhập CMND: ");
        String idCardCustomer = scanner.nextLine();
        System.out.print("Nhập phone number: ");
        String phoneNumberCustomer = scanner.nextLine();
        System.out.print("Nhập Email: ");
        String emailCustomer = scanner.nextLine();
        System.out.print("Nhập loại khách hàng: ");
        String typeCustomer = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String addressCustomer = scanner.nextLine();
        Customer customer = new Customer(idCustomer, nameCustomer, ageCustomer, genderCustomer, idCardCustomer, phoneNumberCustomer,
                emailCustomer, typeCustomer, addressCustomer);
        customerList.add(customer);
        System.out.println("Đã thêm mới thành công!");
    }

    @Override
    public void edit() {
        System.out.print("Nhập id bạn muốn edit: ");
        int placeEdit = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == placeEdit) {
                check = true;
                System.out.print("Nhập id: ");
                int idCustomer = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập tên khách hàng: ");
                String nameCustomer = scanner.nextLine();
                System.out.print("Nhập tuổi: ");
                int ageCustomer = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập giới tính: ");
                String genderCustomer = scanner.nextLine();
                System.out.print("Nhập CMND: ");
                String idCardCustomer = scanner.nextLine();
                System.out.print("Nhập phone number: ");
                String phoneNumberCustomer = scanner.nextLine();
                System.out.print("Nhập Email: ");
                String emailCustomer = scanner.nextLine();
                System.out.print("Nhập loại khách hàng: ");
                String typeCustomer = scanner.nextLine();
                System.out.print("Nhập địa chỉ: ");
                String addressCustomer = scanner.nextLine();
                customerList.get(i).setId(idCustomer);
                customerList.get(i).setName(nameCustomer);
                customerList.get(i).setAge(ageCustomer);
                customerList.get(i).setGender(genderCustomer);
                customerList.get(i).setIdCard(idCardCustomer);
                customerList.get(i).setPhoneNumber(phoneNumberCustomer);
                customerList.get(i).setEmail(emailCustomer);
                customerList.get(i).setTypeOfCustomer(typeCustomer);
                customerList.get(i).setAddress(addressCustomer);
                System.out.println("Đã edit thành công!");
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
