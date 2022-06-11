package ss15_xu_li_ngoai_le_debug.exercise.using_class_Illegal_triangle_exception;

import java.util.Scanner;

public class CheckTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        double a, b, c;
        do {
            check = false;
            try {
                System.out.print("Nhập hệ số a: ");
                a = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập hệ số b: ");
                b = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập hệ số c: ");
                c = Double.parseDouble(scanner.nextLine());
                checkTriangle(a, b, c);
            } catch (IllegalTriangleException e) {
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Không được nhập ký tự! Xin nhập lại");
                check = true;
            }
        } while (check);
    }

    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Thông số nhập sai. a,b,c phải lớn hơn 0, xin nhập lại");
        } else if (a + c <= b) {
            throw new IllegalTriangleException("Thông số nhập sai, a + c phải lớn hơn b, xin nhập lại");
        } else if (b + c <= a) {
            throw new IllegalTriangleException("Thông số nhập sai, b + c phải lớn hơn a, xin nhập lại");
        } else if (a + b <= c) {
            throw new IllegalTriangleException("Thông số nhập sai, a + b phải lớn hơn c, xin nhập lại");
        } else {
            System.out.println("Thông số nhập đã chính xác!");
        }
    }
}
