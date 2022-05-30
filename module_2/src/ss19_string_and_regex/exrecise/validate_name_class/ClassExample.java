package ss19_string_and_regex.exrecise.validate_name_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static final String CLASS_REGEX = "^[C|A|P]+\\d{4}[G|H|I|K|L|M]{1}$";

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tên lớp muốn kiểm tra: ");
        String enterNameClass = input.nextLine();
        boolean isvalid = validate(enterNameClass);
        if (isvalid) {
            System.out.println("Nhập tên lớp hợp lệ");
        } else {
            System.out.println("Tên lớp không hợp lệ!");
        }
    }
}
