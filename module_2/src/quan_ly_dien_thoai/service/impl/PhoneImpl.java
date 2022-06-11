package quan_ly_dien_thoai.service.impl;

import quan_ly_dien_thoai.controllers.PhoneController;
import quan_ly_dien_thoai.exception.CheckException;
import quan_ly_dien_thoai.model.CellPhone;
import quan_ly_dien_thoai.model.GenuinePhone;
import quan_ly_dien_thoai.model.Phone;
import quan_ly_dien_thoai.service.IPhone;
import quan_ly_dien_thoai.util.ReadAndWriteFile;
import quan_ly_dien_thoai.util.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PhoneImpl implements IPhone {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Phone> phoneList = new LinkedList<>();
    public static final String REGEX_INT = "[1-9][0-9]*";

    @Override
    public void add() {
        String choose;
        do {
            System.out.println("Chọn loại điện thoại muốn thêm: ");
            System.out.println("1.\tĐiện thoại chính hãng");
            System.out.println("2.\tĐiện thoại xách tay");
            System.out.print("Chọn chức năng: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    inputGenuinePhone();
                    break;
                case "2":
                    inputCellPhone();
                    break;
                default:
                    System.out.println("Bạn cần nhập đúng lựa chọn! Xin vui lòng nhập lại:");
            }
        } while (true);
    }

    @Override
    public void delete() {
        display();
        System.out.print("Nhập mã điện thoại cần xóa: ");
        int deleteCode;
        boolean check = true;
        int choose;
        phoneList = readFile();
        do {
            deleteCode = CheckException.checkParseInt();
            for (Phone item : phoneList) {
                if (deleteCode == item.getIdPhone()) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            phoneList.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFile();
                            display();
                            break;
                        case 2:
                            PhoneController.displayMenu();
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
    public void display() {
        phoneList = readFile();
        if (phoneList.isEmpty()) {
            System.out.println("Danh sách đang trống! Vui lòng thêm mới");
        }
        for (Phone item : phoneList) {
            System.out.println(item);
        }
    }

    @Override
    public void search() {

    }

    public void inputGenuinePhone() {
        int idGenuinePhone = inputIdPhone();
        System.out.print("Nhập tên điện thoại: ");
        String namePhone = scanner.nextLine();

        System.out.print("Nhập giá: ");
        String price = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.print("Nhập số lượng: ");
        String amount = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.print("Nhập nhà sản xuất: ");
        String producer = scanner.nextLine();

        System.out.print("Nhập thời gian bảo hành: ");
        String warrantyPeriod = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.println("Nhập phạm vi bảo hành: ");
        String warrantyCoverage = inputWarrantyPeriod();

        GenuinePhone genuinePhone = new GenuinePhone(idGenuinePhone, namePhone, price, amount, producer, warrantyPeriod, warrantyCoverage);
        phoneList.add(genuinePhone);
        System.out.println("Đã thêm mới thành công!");
        writeFile();
    }

    public String inputWarrantyPeriod() {
        int choose;
        do {
            System.out.println("1.\tToàn Quốc: ");
            System.out.println("2.\tQuốc Tế: ");
            System.out.print("Chọn: ");
             choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    return "Toan Quoc";
                case 2:
                    return "Quoc Te";
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputIdPhone() {
        phoneList = readFile();
        int idPhone;
        int max = 0;
        if (phoneList.size() == 0) {
            idPhone = 1;
        } else {
            for (Phone phone : phoneList) {
                if (max < phone.getIdPhone()) {
                    max = phone.getIdPhone();
                }
            }
            idPhone = max + 1;
        }
        return idPhone;
    }

    public void inputCellPhone() {
        int idCellPhone = inputIdPhone();
        System.out.print("Nhập tên điện thoại: ");
        String namePhone = scanner.nextLine();

        System.out.print("Nhập giá: ");
        String price = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.print("Nhập số lượng: ");
        String amount = RegexData.regexInt(scanner.nextLine(), REGEX_INT);

        System.out.print("Nhập nhà sản xuất: ");
        String producer = scanner.nextLine();

        System.out.println("Nhập quốc gia xách tay: ");
        String countryPortable = inputCountryPortable(scanner.nextLine());

        System.out.println("Nhập trạng thái: ");
        String status = inputStatus();

        CellPhone cellPhone = new CellPhone(idCellPhone, namePhone, price, amount, producer, countryPortable, status);
        phoneList.add(cellPhone);
        System.out.println("Đã thêm mới thành công!");
        writeFile();
    }

    public String inputStatus() {
        int choose;
        do {
            System.out.println("1.\tĐã sửa chữa: ");
            System.out.println("2.\tChưa sửa chữa: ");
            System.out.print("Chọn: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    return "Da sua chua";
                case 2:
                    return "Chua sua chua";
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputCountryPortable(String temp) {
        while (true) {
            if (!temp.equals("Viet Nam") && !temp.equals("Việt Nam") ) {
                return temp;
            } else {
                System.out.print("Quốc gia không được là Việt Nam! Xin vui lòng nhập lại: ");
                temp = scanner.nextLine();
            }
        }
    }

    public List<Phone> readFile() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\quan_ly_dien_thoai\\data\\mobiles.csv");
        phoneList.clear();
        for (String[] item : list) {
            if (item[6].equals("Toan Quoc") || item[6].equals("Quoc Te")) {
                GenuinePhone genuinePhone = new GenuinePhone(Integer.parseInt(item[0]),
                        item[1],
                        item[2],
                        item[3],
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(genuinePhone);
            } else {
                CellPhone cellPhone = new CellPhone(Integer.parseInt(item[0]),
                        item[1],
                        item[2],
                        item[3],
                        item[4],
                        item[5],
                        item[6]);
                phoneList.add(cellPhone);
            }
        }
        return phoneList;
    }

    public void writeFile() {
        StringBuilder line = new StringBuilder();
        for (Phone item : phoneList) {
            line.append(item.getInfo());
        }
        quan_ly_cong_ty_abc.util.ReadAndWriteFile.writeFile("src\\quan_ly_dien_thoai\\data\\mobiles.csv", line.toString());
    }
}
