package quan_ly_cong_ty_abc.service;

import quan_ly_cong_ty_abc.controller.CompanyController;
import quan_ly_cong_ty_abc.exception.CheckException;
import quan_ly_cong_ty_abc.model.ProductionStaff;
import quan_ly_cong_ty_abc.model.Staff;
import quan_ly_cong_ty_abc.model.ManagementStaff;
import quan_ly_cong_ty_abc.util.ReadAndWriteFile;
import quan_ly_cong_ty_abc.util.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StaffImpl implements IStaff {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Staff> managementList = new LinkedList<>();
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String REGEX_ID_MANAGEMENT_STAFF = "(NVQL)[-][\\d]{3}";
    public static final String REGEX_ID_PRODUCTION_STAFF = "(NVSX)[-][\\d]{3}";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";

    @Override
    public void display() {
        managementList = readFile();
        for (Staff item : managementList) {
            System.out.println(item);
        }

    }

    @Override
    public void add() {
        System.out.println("Chọn loại nhân viên: ");
        System.out.println("1.\tNhân viên quản lý");
        System.out.println("2.\tNhân viên sản xuất");
        System.out.print("Chọn chức năng: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                inputManagementStaff();
                break;
            case "2":
                inputProductionStaff();
                break;
        }
    }

    @Override
    public void delete() {
        display();
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String deleteCode;
        boolean check = true;
        int choose;
        managementList = readFile();
        do {
            deleteCode = scanner.nextLine();
            for (Staff item : managementList) {
                if (deleteCode.equals(item.getIdStaff())) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            managementList.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFile();
                            display();
                            break;
                        case 2:
                            CompanyController.displayMenu();
                            break;
                    }
                    break;
                }
            }
            if (check) {
                System.out.print("Không tìm mã phù hợp! Xin vui lòng chọn lại: ");
            }
        } while (check);
        writeFile();
    }

    @Override
    public void search() {
        System.out.print("Nhập mã nhân viên hoặc họ tên hoặc ngày sinh hoặc địa chỉ cần tìm: ");
        String typeSearch = scanner.nextLine();
        boolean check = true;
        managementList = readFile();
        for (int i = 0; i < managementList.size(); i++) {
            if (typeSearch.contains(managementList.get(i).getIdStaff()) ||
                    typeSearch.contains(managementList.get(i).getName()) ||
                    typeSearch.contains(managementList.get(i).getBirthdayDate()) ||
                    typeSearch.contains(managementList.get(i).getAddress())) {
                check = false;
                System.out.println("Đã tìm thấy nhân viên cần tìm");
                System.out.println(managementList.get(i));
                break;
            }
        }
        if(check) {
            System.out.println("Không tìm thấy nhân viên muốn tìm!");
        }
    }

    public List<Staff> readFile() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\company_abc\\data\\management.csv");
        managementList.clear();
        for (String[] item : list) {
            if (item[1].contains("NVQL")) {
                ManagementStaff managementStaff = new ManagementStaff(Integer.parseInt(item[0]),
                        item[1],
                        item[2],
                        item[3],
                        item[4],
                        item[5],
                        item[6]);
                managementList.add(managementStaff);
            } else {
                ProductionStaff productionStaff = new ProductionStaff(Integer.parseInt(item[0]),
                        item[1],
                        item[2],
                        item[3],
                        item[4],
                        item[5],
                        item[6]);
                managementList.add(productionStaff);
            }
        }
        return managementList;
    }

    public void writeFile() {
        StringBuilder line = new StringBuilder();
        for (Staff item : managementList) {
            line.append(item.getInfo());
        }
        ReadAndWriteFile.writeFile("src\\company_abc\\data\\management.csv", line.toString());
    }

    public void inputManagementStaff() {
        int idManagementStaff;
        int max = 0;
        if (managementList.size() == 0) {
            idManagementStaff = 1;
        } else {
            for (int i = 0; i < managementList.size(); i++) {
                if (max < managementList.get(i).getId()) {
                    max = managementList.get(i).getId();
                }
            }
            idManagementStaff = max + 1;
        }
        System.out.print("Nhập mã nhân viên: ");
        String idStaff = RegexData.regexIdManagementStaff(scanner.nextLine(), REGEX_ID_MANAGEMENT_STAFF);

        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String birthdayDate = RegexData.regexAge(scanner.nextLine(), REGEX_DATE);

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Nhập lương cơ bản: ");
        String basicSalary = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.print("Nhập hệ số lương: ");
        String coefficientsSalary = RegexData.regexInt(scanner.nextLine(), REGEX_INT);
        ManagementStaff managementStaff = new ManagementStaff(idManagementStaff, idStaff, name, birthdayDate, address, basicSalary, coefficientsSalary);
        managementList.add(managementStaff);
        System.out.println("Đã thêm mới thành công!");
        writeFile();
    }

    public void inputProductionStaff() {
        managementList = readFile();
        int idProductionStaff;
        int max = 0;
        if (managementList.size() == 0) {
            idProductionStaff = 1;
        } else {
            for (int i = 0; i < managementList.size(); i++) {
                if (max < managementList.get(i).getId()) {
                    max = managementList.get(i).getId();
                }
            }
            idProductionStaff = max + 1;
        }
        System.out.print("Nhập mã nhân viên: ");
        String idStaff = RegexData.regexIdManagementStaff(scanner.nextLine(), REGEX_ID_PRODUCTION_STAFF);

        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String birthdayDate = RegexData.regexAge(scanner.nextLine(), REGEX_DATE);

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Nhập số sản phẩm: ");
        String productNumber = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.print("Nhập giá mỗi sản phẩm: ");
        String pricePerProduct = RegexData.regexInt(scanner.nextLine(), REGEX_INT);
        ProductionStaff productionStaff = new ProductionStaff(idProductionStaff, idStaff, name, birthdayDate, address, productNumber, pricePerProduct);
        managementList.add(productionStaff);
        System.out.println("Đã thêm mới thành công!");
        writeFile();
    }
}
