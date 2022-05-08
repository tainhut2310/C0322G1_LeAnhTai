package ss03_array_to_java.practice;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter a size: ");
            size = Integer.parseInt(input.nextLine());
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20 );
        int[] array = new int[size];
        int i = 0;
        while (i < array.length ) {
            System.out.println("Enter element " + (i + 1) + " :");
            array[i] = Integer.parseInt(input.nextLine());
            i++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        for (int j = 0; j < array.length / 2 ; j++) {
            int temp = array[j];
            array[j] = array[array.length - 1 - j];
            array[array.length - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}
