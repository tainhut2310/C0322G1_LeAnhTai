package ss01_introduction_to_java.Practice;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);// Khai bao doi tuong Scanner

        System.out.println("Enter width: ");
        width = scanner.nextFloat(); //Nhap chieu rong

        System.out.println("Enter height: ");
        height = scanner.nextFloat(); // Nhap chieu dai

        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
