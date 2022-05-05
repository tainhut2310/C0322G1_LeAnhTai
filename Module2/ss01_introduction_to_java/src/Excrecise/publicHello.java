package Excrecise;

import java.util.Scanner;

public class publicHello {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        System.out.println("Hello: " + fullName);
    }
}
