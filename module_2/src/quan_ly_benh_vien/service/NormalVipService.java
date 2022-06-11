package quan_ly_benh_vien.service;

import quan_ly_benh_vien.controllers.MedicalRecordController;
import quan_ly_benh_vien.exception.CheckException;
import quan_ly_benh_vien.exception.StringException;
import quan_ly_benh_vien.model.MedicalRecord;
import quan_ly_benh_vien.model.Normal;
import quan_ly_benh_vien.model.Vip;
import quan_ly_benh_vien.util.ReadWriteFile;
import quan_ly_benh_vien.util.RegexData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NormalVipService implements IMedicalRecord {
    public static final String REGEX_ID_PATIENT = "(BN)[-][\\d]{3}";
    public static final String REGEX_ID_MEDICAL = "(BA)[-][\\d]{3}";
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static Scanner scanner = new Scanner(System.in);
    public static List<MedicalRecord> listMedical = new LinkedList<>();

    @Override
    public void add() {
        System.out.println("Chọn loại bệnh án: ");
        System.out.println("1.\tBệnh án thường");
        System.out.println("2.\tBệnh án vip");
        System.out.print("Chọn chức năng: ");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                inputNormal();
                break;
            case "2":
                inputVip();
                break;
        }
    }

    @Override
    public void delete() {
        display();
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String deleteCode;
        boolean check = true;
        int choose;
        listMedical = readFile();
        do {
            deleteCode = RegexData.regexMedical(scanner.nextLine(), REGEX_ID_MEDICAL);
            for (MedicalRecord item : listMedical) {
                if (deleteCode.equals(item.getMedicalRecordCode())) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            listMedical.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFile();
                            display();
                            break;
                        case 2:
                            MedicalRecordController.menu();
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
        listMedical = readFile();
        for (MedicalRecord item : listMedical) {
            System.out.println(item);
        }
    }

    public void inputNormal() {
        int numericalOrder = getNumericalOrder();

        System.out.print("Nhập mã bệnh án: ");
        String diseaseCodeVip = RegexData.regexMedical(scanner.nextLine(), REGEX_ID_MEDICAL);

        System.out.print("Nhập mã bệnh nhân: ");
        String idPatient = RegexData.regexPatient(scanner.nextLine(), REGEX_ID_PATIENT);

        System.out.print("Nhập tên bệnh nhân: ");
        String namePatient = scanner.nextLine();

        System.out.print("Nhập ngày nhập viện: ");
        String dateIn = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);

        System.out.print("Nhập ngày ra viện: ");
        String tempDate = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
        String dateOut = inputDate(dateIn, tempDate);

        System.out.print("Nhập lý do nhập viện: ");
        String reasonForAdmission = scanner.nextLine();

        System.out.print("Nhập phí nằm viện: ");
        double hospitalizationExpenses = CheckException.checkParseDouble();

        Normal normal = new Normal(numericalOrder, diseaseCodeVip, idPatient, namePatient, dateIn, dateOut, reasonForAdmission, hospitalizationExpenses);
        listMedical.add(normal);
        System.out.println("Đã thêm mới thành công");
        writeFile();
    }
    
    public int getNumericalOrder() {
        listMedical = readFile();
        int numericalOrder;
        int max = 0;
        if (listMedical.size() == 0) {
            numericalOrder = 1;
        } else {
            for (MedicalRecord medicalRecord : listMedical) {
                if (max < medicalRecord.getNumericalOrder()) {
                    max = medicalRecord.getNumericalOrder();
                }
            }
            numericalOrder = max + 1;
        }
        return numericalOrder;
    }


    public void inputVip() {
        int numericalOrder = getNumericalOrder();

        System.out.print("Nhập mã bệnh án vip: ");
        String medicalRecordCode = RegexData.regexMedical(scanner.nextLine(), REGEX_ID_MEDICAL);

        System.out.print("Nhập mã bệnh nhân: ");
        String idPatient = RegexData.regexPatient(scanner.nextLine(), REGEX_ID_PATIENT);

        System.out.print("Nhập tên bệnh nhân: ");
        String namePatient = scanner.nextLine();

        System.out.print("Nhập ngày nhập viện: ");
        String dateIn = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);

        System.out.print("Nhập ngày ra viện: ");
        String tempDate = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
        String dateOut = inputDate(dateIn, tempDate);

        System.out.print("Nhập lý do nhập viện: ");
        String reasonForAdmission = scanner.nextLine();

        System.out.println("Nhập loại VIP: ");
        String vipType = inputTypeVip();

        System.out.print("Nhập thời hạn vip: ");
        String vipDuration = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
        Vip vip = new Vip(numericalOrder, medicalRecordCode, idPatient, namePatient, dateIn, dateOut, reasonForAdmission, vipType, vipDuration);
        System.out.println("Đã thêm mới thành công");
        listMedical.add(vip);
        writeFile();
    }

    public void writeFile() {
        StringBuilder line = new StringBuilder();
        for (MedicalRecord item : listMedical) {
            line.append(item.getInfo());
        }
        ReadWriteFile.writeFile("src\\quan_ly_benh_vien\\data\\medical_records.csv", line.toString());
    }

    public List<MedicalRecord> readFile() {
        List<String[]> list = ReadWriteFile.readFile("src\\quan_ly_benh_vien\\data\\medical_records.csv");
        listMedical.clear();
        for (String[] item : list) {
            if (item.length == 8) {
                Normal normal = new Normal(Integer.parseInt(item[0]),
                        item[1],
                        item[2],
                        item[3],
                        item[4],
                        item[5],
                        item[6],
                        Double.parseDouble(item[7]));
                listMedical.add(normal);
            } else {
                Vip vip = new Vip(Integer.parseInt(item[0]),
                        item[1],
                        item[2],
                        item[3],
                        item[4],
                        item[5],
                        item[6],
                        item[7],
                        item[8]);
                listMedical.add(vip);
            }
        }
        return listMedical;
    }

    public String inputTypeVip() {
        System.out.println("1.\tVIP I:");
        System.out.println("2.\tVIP II:");
        System.out.println("3.\tVIP III:");
        System.out.print("Chọn loại VIP: ");
        int choose;
        do {
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    return "VIP 1";
                case 2:
                    return "VIP 2";
                case 3:
                    return "VIP 3";
                default:
                    System.out.print("Không có lựa chọn trên!Xin nhập lại: ");
            }
        } while (true);
    }

    public String inputDate(String dateIn, String dateOut) {
        boolean check = true;
        while (check) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateStart = LocalDate.parse(dateIn, formatter);
                LocalDate dateEnd = LocalDate.parse(dateOut, formatter);
                int current = Period.between(dateStart, dateEnd).getDays();
                if (current > 0) {
                    check = false;
                } else {
                    throw new StringException("Ngày ra viện phải lớn hơn ngày nhập viện! Xin vui lòng nhập lại: ");
                }
            } catch (StringException e) {
                System.out.print(e.getMessage());
                dateOut = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
            }
        }
        return dateOut;
    }
}
