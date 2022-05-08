package ss02_loop_to_java.excrecise;

import java.util.Scanner;

public class PrintingPicture {
    public static void main(String[] args) {
        int choice = -1;
        int length,width;
        Scanner input = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1. Print the rectange");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles");
        System.out.println("0. Exit");
        choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 0:
                System.exit(0);
            case 1:
                System.out.println("Enter length: ");
                length = Integer.parseInt(input.nextLine());

                System.out.println("Enter width: ");
                width = Integer.parseInt(input.nextLine());

                for (int i = 0; i < length ; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Enter length: ");
                width = Integer.parseInt(input.nextLine());

                for (int i = 0; i < width ; i++) {
                    for (int j = 0; j <= i ; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                System.out.println();
                for (int i = 0; i < width ; i++) {
                    for (int j = i ; j < width -1 ; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 0 ; j <= i ; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                System.out.println();
                for (int i = 0; i < width ; i++) {
                    for (int j = 0; j < width - i ; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                System.out.println();
                for (int i = 0; i < width ; i++) {
                    for (int j = 0; j < i ; j++) {
                        System.out.print("  ");
                    }
                    for (int j = 0; j < width - i ; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Enter width: ");
                width = Integer.parseInt(input.nextLine());
                width--;
                for( int i = 0; i < width; i++) {
                    for(int j = 0; j < 2 * width + 1; j++) {
                        if(j == width - i || j == width + i ) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                for(int k = 0;k < 2 * width + 1; k++) {
                    System.out.print("*");
                }
                break;
            default:
                System.out.println("No choose!");
        }
    }
}
