package services.impl;

import exception.CheckException;
import models.Customer;
import services.CustomerService;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    private List<Customer> customerList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        customerList = readFile();
        for (Customer item : customerList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        customerList = readFile();
        System.out.print("Nhập id: ");
        String idCustomer = checkId();

        System.out.print("Nhập tên khách hàng: ");
        String nameCustomer = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập ngày sinh: ");
        String ageCustomer = RegexData.regexAge(scanner.nextLine(), REGEX_DATE);

        System.out.println("Nhập giới tính: ");
        String genderCustomer = inputGender();

        System.out.print("Nhập CMND: ");
        String idCardCustomer = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập phone number: ");
        String phoneNumberCustomer = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập Email: ");
        String emailCustomer = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập loại khách hàng: ");
        String typeCustomer = inputTypeCustomer();

        System.out.print("Nhập địa chỉ: ");
        String addressCustomer = CheckException.checkString(scanner.nextLine());

        Customer customer = new Customer(idCustomer, nameCustomer, ageCustomer, genderCustomer, idCardCustomer,
                phoneNumberCustomer, emailCustomer, typeCustomer, addressCustomer);
        customerList.add(customer);
        System.out.println("Đã thêm mới thành công!");
        writeFile();
    }

    @Override
    public void edit() {
        customerList = readFile();
        System.out.print("Nhập id bạn muốn edit: ");
        String placeEdit;
        boolean check = false;
        do {
            placeEdit = scanner.nextLine();
            for (int i = 0; i < customerList.size(); i++) {
                if (placeEdit.equals(customerList.get(i).getId())) {
                    check = true;
                    System.out.print("Nhập new id: ");
                    String idCustomer = checkId();
                    customerList.get(i).setId(idCustomer);

                    System.out.print("Nhập tên khách hàng: ");
                    String nameCustomer = CheckException.checkString(scanner.nextLine());
                    customerList.get(i).setName(nameCustomer);

                    System.out.print("Nhập ngày sinh: ");
                    String ageCustomer = RegexData.regexAge(scanner.nextLine(),REGEX_DATE);
                    customerList.get(i).setDateOfBirth(ageCustomer);

                    System.out.println("Nhập giới tính: ");
                    String genderCustomer = inputGender();
                    customerList.get(i).setGender(genderCustomer);

                    System.out.print("Nhập CMND: ");
                    String idCardCustomer = CheckException.checkString(scanner.nextLine());
                    customerList.get(i).setIdCard(idCardCustomer);

                    System.out.print("Nhập phone number: ");
                    String phoneNumberCustomer = CheckException.checkString(scanner.nextLine());
                    customerList.get(i).setPhoneNumber(phoneNumberCustomer);

                    System.out.print("Nhập Email: ");
                    String emailCustomer = CheckException.checkString(scanner.nextLine());
                    customerList.get(i).setEmail(emailCustomer);

                    System.out.print("Nhập loại khách hàng: ");
                    String typeCustomer = inputTypeCustomer();
                    customerList.get(i).setTypeOfCustomer(typeCustomer);

                    System.out.print("Nhập địa chỉ: ");
                    String addressCustomer = CheckException.checkString(scanner.nextLine());
                    customerList.get(i).setAddress(addressCustomer);

                    System.out.println("Đã edit thành công!");
                    break;
                }
            }
            if (!check) {
                System.out.print("Id bạn muốn edit không tồn tại! Xin nhập lại: ");
            }
        } while (!check);
        writeFile();
    }

    public String inputGender() {
        String choose;
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            System.out.println("3. Giới tính thứ 3");
            System.out.print("Chọn giới tính: ");
        while (true) {
             choose = CheckException.checkString(scanner.nextLine());
            switch (choose) {
                case "1":
                    return "Nam";
                case "2":
                    return "Nữ";
                case "3":
                    return "Giới tính thứ 3";
                default:
                    System.out.print("Nhập sai! Xin nhập lại");
            }
        }
    }

    public String inputTypeCustomer() {
        String choose;
        System.out.println("1. Platinium");
        System.out.println("2. Gold");
        System.out.println("3. Silver");
        System.out.println("4. Member");
        System.out.print("Chọn loại khách hàng: ");
        do {
            choose = CheckException.checkString(scanner.nextLine());
            switch (choose) {
                case "1":
                    return "Diamond";
                case "2":
                    return "Gold";
                case "3":
                    return "Silver";
                case "4":
                    return "Member";
                default:
                    System.out.print("Nhập sai! Xin nhập lại");
            }
        } while (true);
    }

    public List<Customer> readFile() {
        List<String[]> listStr = ReadAndWrite.readFile("src\\data\\customer.csv");
        customerList.clear();
        for (String[] item : listStr) {
            Customer customer = new Customer(item[0],
                    item[1],
                    item[2],
                    item[3],
                    item[4],
                    item[5],
                    item[6],
                    item[7],
                    item[8]);
            customerList.add(customer);
        }
        return customerList;
    }

    public void writeFile() {
        String line = "";
        for (Customer item : customerList) {
            line += item.getInfo();
        }
        ReadAndWrite.writeFile("src\\data\\customer.csv", line);
    }

    public String checkId() {
        customerList = readFile();
        String temp;
        boolean check = true;
        if (customerList.isEmpty()) {
            temp = CheckException.checkString(scanner.nextLine());
            return temp;
        } else {
            do {
                check =false;
                temp = CheckException.checkString(scanner.nextLine());
                for (Customer item : customerList) {
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
