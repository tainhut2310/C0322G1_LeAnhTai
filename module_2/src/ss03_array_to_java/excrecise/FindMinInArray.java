package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter quantity element:");
        int size = Integer.parseInt(input.nextLine());
        int[] array = new int[size];
        for (int i = 0; i < array.length ; i++) {
            System.out.print("Enter element place " + i + " : ");
            array[i] = Integer.parseInt(input.nextLine());
        }
        System.out.print("Element in array:");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        int min = array[0];
        for (int i = 0; i < array.length ; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("\nMin element in array: " + min);
    }
}
