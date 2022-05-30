package ss19_string_and_regex.exrecise.validate_phonenumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    public static final String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số điện thoại muốn kiểm tra: ");
        String enterPhoneNumber = input.nextLine();
        boolean isvalid = validate(enterPhoneNumber);
        if (isvalid) {
            System.out.println("Nhập số điện thoại hợp lệ");
        } else {
            System.out.println("Số điện thoại không hợp lệ!");
        }
    }
}
