package ss11_stack_queue.exrcecise.convert_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Chuyển đổi từ hệ thập phân sang hệ nhị phân.
        System.out.print("Nhập vào số hệ thập phân muốn chuyển:");
        int num = Integer.parseInt(input.nextLine());
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        String binaryString = "";
        while (!stack.isEmpty()) {
            binaryString += stack.pop();
        }
        System.out.print("Sau khi chuyển sang hệ nhị phân: ");
        System.out.println(binaryString);
    }
}
