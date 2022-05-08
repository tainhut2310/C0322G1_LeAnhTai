package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class SumOneColumDefine {
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
        System.out.print("Nhap vi tri cot ma ban muon tinh: ");
        int placeCol = Integer.parseInt(input.nextLine());
        double sum = 0.0;
        for (int i = 0; i < row ; i++) {
            sum += array[i][placeCol];
        }
        System.out.println("Tong cua cot o vi tri thu " + placeCol + " = " + sum);
    }

}
