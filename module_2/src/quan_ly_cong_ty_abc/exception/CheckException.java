package quan_ly_cong_ty_abc.exception;

import java.util.Scanner;

public class CheckException extends Exception {
    public static Scanner scanner = new Scanner(System.in);

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
}
