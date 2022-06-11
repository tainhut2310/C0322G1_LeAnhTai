package quan_ly_benh_vien.util;

import quan_ly_benh_vien.exception.CheckException;
import quan_ly_benh_vien.exception.NameMedicalException;
import quan_ly_benh_vien.exception.NamePatientException;

import java.util.Scanner;

public class RegexData {

    public static Scanner scanner = new Scanner(System.in);
    public static String regexPatient(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (temp.matches(regex)) {
                    check = false;
                    return temp;
                } else {
                    throw new NamePatientException( "Bạn đã nhập sai định dạng, mã bệnh nhân phải có dạng BN-XXX\nXin vui lòng nhập lại: ");
                }
            } catch (NamePatientException e) {
                System.out.print(e.getMessage());
                temp = CheckException.checkString(scanner.nextLine());
            }
        }
        return temp;
    }

    public static String regexMedical(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (temp.matches(regex)) {
                    check = false;
                    return temp;
                } else {
                    throw new NameMedicalException( "Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng BA-XXX\nXin vui lòng nhập lại: ");
                }
            } catch (NameMedicalException e) {
                System.out.print(e.getMessage());
                temp = CheckException.checkString(scanner.nextLine());
            }
        }
        return temp;
    }

    public static String regexDate(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (temp.matches(regex)) {
                    check = false;
                    return temp;
                } else {
                    throw new NameMedicalException( "Bạn đã nhập sai định dạng! Xin vui lòng nhập lại: ");
                }
            } catch (NameMedicalException e) {
                System.out.print(e.getMessage());
                temp = CheckException.checkString(scanner.nextLine());
            }
        }
        return temp;
    }
}
