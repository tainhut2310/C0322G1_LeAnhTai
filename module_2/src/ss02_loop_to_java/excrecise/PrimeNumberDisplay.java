package ss02_loop_to_java.excrecise;

import java.util.Scanner;

class PrimeNumberDisplay {
    public static void main(String[] args) {
        System.out.println("Nhap vao so nguyen to ban muon in ra:");
        Scanner input = new Scanner(System.in);
        int numbers = Integer.parseInt(input.nextLine());
        int count = 0;
        int n = 2;
        System.out.print(numbers + " số nguyên tố đầu tiên là: ");
        while (count < numbers) {
            boolean check = true;
            for (int i = 2; i < n ; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }
}
