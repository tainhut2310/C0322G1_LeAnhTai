package quan_ly_dien_thoai.util;

import quan_ly_dien_thoai.exception.IntegerException;

import java.util.Scanner;

public class RegexData {
    public static Scanner scanner = new Scanner(System.in);

    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex) && !temp.equals("")) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }

    public static String regexInt(String temp, String regex) {
        while (true) {
            try {
                if (temp.matches(regex) && !temp.equals("")) {
                    return temp;
                } else {
                    throw new IntegerException("Nhập sai định dạng, nhập vào phải là số dương\nXin vui lòng nhập lại: ");
                }
            } catch (IntegerException e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
    }
}
