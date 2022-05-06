package ss02_loop_to_java.practice;

import java.util.Scanner;

public class IntertestCalculator {
    public static void main(String[] args) {
        double money = 1.0;
        double intertestRate = 1.0;
        int month = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng tiền cho vay: ");
        money = Double.parseDouble(input.nextLine());

        System.out.println("Nhập tỉ lệ lãi suất theo tháng: ");
        intertestRate = Double.parseDouble(input.nextLine());

        System.out.println("Nhập số tháng cho vay: ");
        month = Integer.parseInt(input.nextLine());

        double totalIntertest = 0;

        for (int i = 0; i < month; i++) {
            totalIntertest += money * (intertestRate / 100) / 12 * month;
        }
        System.out.println("Total of intertest: " + totalIntertest);
    }
}
