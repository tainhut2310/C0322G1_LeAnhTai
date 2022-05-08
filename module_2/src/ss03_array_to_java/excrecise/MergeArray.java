package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] arrayA = new int[5];
        int[] arrayB = new int[7];
        int[] arrayC = new int[arrayA.length + arrayB.length];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter elment in array A");
        for (int i = 0; i < arrayA.length ; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arrayA[i] = Integer.parseInt(input.nextLine());
        }
        System.out.println("Enter elment in array B");
        for (int i = 0; i < arrayB.length ; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arrayB[i] = Integer.parseInt(input.nextLine());
        }
        System.out.print("\nElement in array A: ");
        for (int i = 0; i < arrayA.length ; i++) {
            arrayC[i] = arrayA[i];
            System.out.print(arrayA[i] + "\t");
        }
        System.out.print("\nElement in array B: ");
        for (int i = 0; i < arrayB.length ; i++) {
            arrayC[arrayA.length + i] = arrayB[i];
            System.out.print(arrayB[i] + "\t");
        }
        System.out.print("\nElement in array C: ");
        for (int value : arrayC) {
            System.out.print(value + "\t");
        }
    }
}
