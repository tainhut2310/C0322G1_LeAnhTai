package quan_ly_person.exception;

import java.util.Scanner;

public class CheckException extends Exception {
    public static Scanner scanner = new Scanner(System.in);

    public CheckException(String message) {
        super(message);
    }

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


    public static Double checkParseDouble() {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Nhập sai định dạng! Xin vui lòng nhập lại: ");
            }
        }
        return value;
    }

    public static String checkString(String temp) {
        boolean check = true;
        while (check) {
            try {
                if (!temp.trim().equals("")) {
                    check = false;
                } else {
                    throw new CheckException("Nhập sai định dạng! Xin vui lòng nhập lại: ");
                }
            } catch (CheckException e) {
                System.err.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
