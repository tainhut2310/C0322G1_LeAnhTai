package ss01_introduction_to_java.Excrecise;

import java.util.Scanner;

public class PublicHello {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        System.out.println("Hello: " + fullName);
    }
}
