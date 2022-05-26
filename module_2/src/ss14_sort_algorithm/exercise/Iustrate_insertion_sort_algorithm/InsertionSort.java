package ss14_sort_algorithm.excrecise.Iustrate_insertion_sort_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSortBySteep(list);
    }

    public static void insertionSortBySteep(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            System.out.println("Gán arr[" + i + "]=" + arr[i]);
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                System.out.println("Vì " + arr[j] + " > " + current + " Nên gán vị trí arr[" + (j + 1) + "]= " + arr[j]);
                j--;
            }
            arr[j + 1] = current;
            System.out.println("Giá trị đầu tiên của phần mảng đã sắp xếp hiện tại sẽ là arr[" + (j + 1) + "]=  " + current);
            System.out.println("List after the " + i + " sort: ");
            System.out.println(Arrays.toString(arr));
        }
    }
}