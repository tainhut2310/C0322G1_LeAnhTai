package quan_ly_cong_ty_abc.util;

import quan_ly_benh_vien.exception.NamePatientException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    public static Scanner scanner = new Scanner(System.in);

//    public static String regexStr(String temp, String regex, String error) {
//        boolean check = true;
//        do {
//            if (temp.matches(regex) && !temp.equals("")) {
//                check = false;
//            } else {
//                System.out.println(error);
//                temp = scanner.nextLine();
//            }
//        } while (check);
//        return temp;
//    }

    public static String regexIdManagementStaff(String temp, String regex) {
        while (true) {
            try {
                if (temp.matches(regex) && !temp.equals("")) {
                    return temp;
                } else {
                    throw new NamePatientException("Bạn đã nhập sai định dạng, mã nhân viên quản lý phải có dạng NVQL-XXX\nXin vui lòng nhập lại: ");
                }
            } catch (NamePatientException e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
    }

    public static String regexIdProductionStaff(String temp, String regex) {
        while (true) {
            try {
                if (temp.matches(regex) && !temp.equals("")) {
                    return temp;
                } else {
                    throw new NamePatientException("Bạn đã nhập sai định dạng, mã nhân viên sản xuất phải có dạng NVSX-XXX\nXin vui lòng nhập lại: ");
                }
            } catch (NamePatientException e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
    }

    public static String regexAge(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current >= 18) {
                        check = false;
                    } else {
                        throw new Exception("Tuổi phải > 18! Xin vui lòng nhập lại: ");
                    }
                } else {
                    throw new Exception("Định dạng nhập vào không đúng! Xin vui lòng nhập lại: ");
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }

    public static String regexInt(String temp, String regex) {
        while (true) {
            try {
                if (temp.matches(regex) && !temp.equals("")) {
                    return temp;
                } else {
                    throw new Exception("Bạn đã nhập sai định dạng, số nhập phải là số dương\nXin vui lòng nhập lại: ");
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
    }
}
