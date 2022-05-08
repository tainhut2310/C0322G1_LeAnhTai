package ss03_array_to_java.practice;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = Integer.parseInt(input.nextLine());
            if ( size > 20 ) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i + 1) + " : ");
            array[i] = Integer.parseInt(input.nextLine());
            i++;
        }
        System.out.print("Property list: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length ; j++) {
            if(array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("\nThe largest property value in the list is " + max + " ,at position " + index);
    }
}
