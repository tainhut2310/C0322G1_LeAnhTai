package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrNumber = {10, 4 , 6 , 7 , 8, 6, 9, 5, 0, 0};
        System.out.print("Mảng trước khi xoa: ");
        for (int value : arrNumber) {
            System.out.print(value + "\t");
        }
        System.out.print("\nChon phan tu can xoa:");
        int elementDelete = Integer.parseInt(input.nextLine());
        int place = 0;
        boolean flag = false;
        for (int i = 0; i < arrNumber.length ; i++) {
            if( elementDelete == arrNumber[i]) {
                flag = true;
                arrNumber[i] = arrNumber[i + 1];
                place = i;
                break;
            }
        }
        if (!flag) {
            System.out.println("Khong tim thay phan tu can xoa trong Mang");
        } else {
            System.out.println("Tim thay vi tri can xoa o vi tri thu: " + place);
            for (int j = place; j < arrNumber.length -1 ; j++) {
                arrNumber[j] = arrNumber[j + 1];
            }
            System.out.print("Mang sau khi xoa:");
            for (int value : arrNumber) {
                System.out.print(value + "\t");
            }
        }

    }
}
