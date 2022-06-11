package service.impl;

import controllers.SotTietKiemController;
import exception.CheckException;
import model.CoThoiHan;
import model.DaiHan;
import model.NganHan;
import model.VoThoiHan;
import service.IService;
import util.ReadAndWriteFile;
import util.RegexData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SoTietKiemImpl implements IService {
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static Scanner scanner = new Scanner(System.in);
    List<NganHan> nganHanList = new LinkedList<>();
    List<DaiHan> daiHanList = new LinkedList<>();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    @Override
    public void display() {
        nganHanList = readFileNganHan();
        daiHanList = readFileDaiHan();
        for (DaiHan item : daiHanList) {
            System.out.println(item);
        }
        for (NganHan item : nganHanList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        int choose;
        do {
            System.out.println("1.\tThêm mới so dài hạn");
            System.out.println("2.\tThêm mới ngắn hạn");
            System.out.println("3.\tExit");
            System.out.print("Chọn: ");
            choose = CheckException.checkParseInt();
            switch (choose) {
                case 1:
                    inputDaiHan();
                    break;
                case 2:
                    do {
                        System.out.println("1.\tThêm mới sổ tiết kiệm vô thời hạn");
                        System.out.println("2.\tThêm mới sổ tiết kiệm có thời hạn");
                        System.out.println("3.\tExit");
                        System.out.print("Chọn: ");
                        choose = CheckException.checkParseInt();
                        switch (choose) {
                            case 1:
                                inputSoVoThoiHan();
                                break;
                            case 2:
                                inputSoCoThoiHan();
                                break;
                            case 3:
                                return;
                            default:
                                System.out.println("Không có trong lựa chọn! Xin vui lòng chọn lại");
                        }
                    } while (true);
                case 3:
                    return;
                default:
                    System.out.println("Không có trong lựa chọn! Xin vui lòng chọn lại");
            }
        } while (true);
    }

    @Override
    public void delete() {
        deleteSoDaiHan();
    }

    public List<DaiHan> readFileDaiHan() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\data\\longTerm.csv");
        daiHanList.clear();
        for (String[] item : list) {
            DaiHan daiHan = new DaiHan(item[0],
                    item[1],
                    LocalDate.parse(item[2]),
                    LocalDate.parse(item[3]),
                    Double.parseDouble(item[4]),
                    item[5],
                    item[6],
                    item[7]);
            daiHanList.add(daiHan);
        }
        return daiHanList;
    }

    public void writeFileDaiHan() {
        StringBuilder line = new StringBuilder();
        for (DaiHan item : daiHanList) {
            line.append(item.getInfo());
        }
        ReadAndWriteFile.writeFile("src\\data\\longTerm.csv", line.toString());
    }

    public void writeFileNganHan() {
        StringBuilder line = new StringBuilder();
        for (NganHan item : nganHanList) {
            line.append(item.getInfo());
        }
        ReadAndWriteFile.writeFile("src\\data\\shortTerm.csv", line.toString());
    }

    public List<NganHan> readFileNganHan() {
        List<String[]> list = ReadAndWriteFile.readFile("src\\data\\shortTerm.csv");
        nganHanList.clear();
        for (String[] item : list) {
            if (item.length == 7) {
                CoThoiHan coThoiHan = new CoThoiHan(item[0],
                        item[1],
                        LocalDate.parse(item[2]),
                        LocalDate.parse(item[3]),
                        Double.parseDouble(item[4]),
                        item[5],
                        item[6]);
                nganHanList.add(coThoiHan);
            } else {
                VoThoiHan voThoiHan = new VoThoiHan(item[0],
                        item[1],
                        LocalDate.parse(item[2]),
                        LocalDate.parse(item[3]),
                        Double.parseDouble(item[4]),
                        item[5]);
                nganHanList.add(voThoiHan);
            }
        }
        return nganHanList;
    }

    public void inputDaiHan() {
        readFileDaiHan();
        System.out.print("Nhập ma so: ");
        String maSoSo = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập khach hang: ");
        String maKhachHang = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập ngay mo so: ");
        LocalDate ngayMoSo = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập thoi gian bat dau: ");
        LocalDate thoiGianBatDau = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập so tien gui: ");
        double soTienGui = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập lai suat: ");
        String laiSuat = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập ky han: ");
        String kyHan = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập uu dai: ");
        String uuDai = CheckException.checkString(scanner.nextLine());

        DaiHan daiHan = new DaiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laiSuat, kyHan, uuDai);
        daiHanList.add(daiHan);
        System.out.println("Đã thêm mới thành công!");
        writeFileDaiHan();
    }

    public void inputSoVoThoiHan() {
        readFileNganHan();
        System.out.print("Nhập ma so: ");
        String maSoSo = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập khach hang: ");
        String maKhachHang = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập ngay mo so: ");
        LocalDate ngayMoSo = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập thoi gian bat dau: ");
        LocalDate thoiGianBatDau = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập so tien gui: ");
        double soTienGui = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập lai suat: ");
        String laiSuat = CheckException.checkString(scanner.nextLine());

        VoThoiHan voThoiHan = new VoThoiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laiSuat);
        nganHanList.add(voThoiHan);
        System.out.println("Đã thêm mới thành công!");
        writeFileNganHan();
    }

    public void inputSoCoThoiHan() {
        readFileNganHan();
        System.out.print("Nhập ma so: ");
        String maSoSo = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập khach hang: ");
        String maKhachHang = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập ngay mo so: ");
        LocalDate ngayMoSo = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập thoi gian bat dau: ");
        LocalDate thoiGianBatDau = LocalDate.parse(RegexData.regexStr(scanner.nextLine(), REGEX_DATE, "Nhập sai định dạng! Xin vui lòng nhập lại: "), formatter);

        System.out.print("Nhập so tien gui: ");
        double soTienGui = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập lai suat: ");
        String laiSuat = CheckException.checkString(scanner.nextLine());

        System.out.print("Nhập kỳ han: ");
        String kyHan = CheckException.checkString(scanner.nextLine());

        CoThoiHan coThoiHan = new CoThoiHan(maSoSo, maKhachHang, ngayMoSo, thoiGianBatDau, soTienGui, laiSuat, kyHan);
        nganHanList.add(coThoiHan);
        System.out.println("Đã thêm mới thành công!");
        writeFileNganHan();
    }

    public void deleteSoDaiHan() {
        System.out.print("Nhập mã số cần xóa: ");
        String deleteCode;
        boolean check = true;
        int choose;
        daiHanList = readFileDaiHan();
        do {
            deleteCode = CheckException.checkString(scanner.nextLine());
            for (DaiHan item : daiHanList) {
                if (deleteCode.equals(item.getMaSoSo())) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            daiHanList.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFileDaiHan();
                            display();
                            break;
                        case 2:
                            SotTietKiemController.displayMenu();
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

    public void deleteSoCoThoiHan() {
        System.out.print("Nhập mã học viên cần xóa: ");
        String deleteCode;
        boolean check = true;
        int choose;
        nganHanList = readFileNganHan();
        do {
            deleteCode = CheckException.checkString(scanner.nextLine());
            for (NganHan item : nganHanList) {
                if (deleteCode.equals(item.getMaSoSo())) {
                    check = false;
                    System.out.println("Bạn có chắc chắn muốn xóa!");
                    System.out.println("1.\tYes");
                    System.out.println("2.\tNo");
                    System.out.print("Chọn: ");
                    choose = CheckException.checkParseInt();
                    switch (choose) {
                        case 1:
                            daiHanList.remove(item);
                            System.out.println("Đã xóa thành công!");
                            writeFileDaiHan();
                            display();
                            break;
                        case 2:
                            SotTietKiemController.displayMenu();
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
}
