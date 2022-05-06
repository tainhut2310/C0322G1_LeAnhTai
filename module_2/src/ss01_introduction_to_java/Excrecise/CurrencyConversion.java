package Excrecise;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int rateVND = 23000;
        System.out.println("Enter a value USD:");
        double valueUSD = scanner.nextDouble();
        System.out.println(valueUSD + " USD co gia tri bang " + (valueUSD * rateVND) + " VND");
    }
}
