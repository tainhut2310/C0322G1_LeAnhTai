package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class SumMainDiagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao so hang: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.print("Nhap vao so cot: ");
        int col = Integer.parseInt(input.nextLine());
        double[][] array = new double[row][col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                System.out.print("Nhap phan tu o vi tri thu "+ i + "\t" + j + " : ");
                array[i][j] = Double.parseDouble(input.nextLine());
            }
        }
        System.out.println("Mang sau khi nhap:");
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        double sum = 0.0;
        if (row == col) {
            for (int i = 0; i < row ; i++) {
                for (int j = 0; j < col ; j++) {
                    if ( i == j ) {
                        sum += array[i][j];
                    }
                }
            }
            System.out.println("Tong duong cheo chinh = " + sum);
        } else {
            System.out.println("Ma tran tren khong phai la ma tran vuong nen không the tinh tong duong cheo chinh");
        }
    }
}
