package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrNumber = {10, 4, 6, 7, 8, 0, 0, 0, 0};
        System.out.printf("%-20s%s", "Mang truoc khi them phan tu: ", "");
        for (int value : arrNumber) {
            System.out.print(value + "\t");
        }
        System.out.print("\nNhap gia tri phan tu can them vao mang: ");
        int elementValue = Integer.parseInt(input.nextLine());
        System.out.print("Nhap vi tri cua phan tu can them vao mang: ");
        int placeValue = Integer.parseInt(input.nextLine());
        if (placeValue < 0 || placeValue > arrNumber.length - 1) {
            System.out.println("Khong chen duoc phan tu vao mang");
        } else {
            System.out.printf("%-20s%s", "Mang sau khi them phan tu: ", "");
            for (int i = arrNumber.length - 1; i > placeValue; i--) {
                arrNumber[i] = arrNumber[i - 1];
            }
            arrNumber[placeValue] = elementValue;
            for (int value : arrNumber) {
                System.out.print(value + "\t");
            }
        }
    }
}
