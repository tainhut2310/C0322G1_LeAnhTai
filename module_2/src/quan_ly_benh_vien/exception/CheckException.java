package quan_ly_benh_vien.exception;

import java.util.Scanner;

public class CheckException extends Exception {
    static Scanner scanner = new Scanner(System.in);
    public static int checkParseInt() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Nhập sai định dạng! Xin vui lòng nhập lại: ");
            }

        }
        return value;
    }

    public static double checkParseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Nhập sai định dạng! Xin vui lòng nhập lại: ");
            }
        }
        return value;
    }

    public static String checkString(String temp) {
        boolean check = true;
        while (check) {
            try {
                if (!temp.equals("")) {
                    check = false;
                } else {
                    throw new StringException("Nhập sai định dạng! Xin vui lòng nhập lại: ");
                }
            } catch (StringException e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
