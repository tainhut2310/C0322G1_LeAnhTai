package ss03_array_to_java.excrecise;

import java.util.Scanner;

public class CoutCharInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = "Công Tằng Tôn Nữ Nguyễn Thị Long Lanh Bồng Bềnh Ánh Tuyết";
        System.out.print("Nhap vao ky tu muon dem: ");
        char charFind = input.nextLine().charAt(0);
        ;
        int count = 0;
        for (int i = 0; i < string.length() ; i++) {
            if (charFind == string.charAt(i)) {
                count++;
            }
        }
        System.out.println("Ky tu " + charFind + " xuat hien " + count + " lan trong chuoi.");
    }
}
