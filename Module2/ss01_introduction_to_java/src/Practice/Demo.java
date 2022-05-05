package Practice;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập điểm Toán:");
        double math = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập điểm Lý:");
        double physics = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập điểm Hóa:");
        double chemistry = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập tên:");
        String student = scanner.nextLine();

        double avg = ( math + physics + chemistry ) / 3;

        System.out.println("Điểm trung bình " + student + avg );
    }
}
