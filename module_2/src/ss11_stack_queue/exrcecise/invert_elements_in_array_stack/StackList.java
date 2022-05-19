package ss11_stack_queue.exrcecise.invert_elements_in_array_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackList {
    public static void main(String[] args) {
        //Đảo ngược phần tử trong mảng số nguyên sử dụng Stack
        Scanner input = new Scanner(System.in);
        int[] array = {4, 7, 5, 7, 9, 11};
        Stack<Integer> stack = new Stack<>();
        for (int item : array) {
            stack.push(item);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println("Mảng sau khi sau khi lấy ra từ Stack và đưa lại mảng ban đầu");
        for (Integer item : array) {
            System.out.println(item);
        }

        //Đảo ngược chuỗi sử dụng Stack
        String string = input.nextLine();
        System.out.println("Nhập vào một chuỗi ký tự");
        String[] strings = string.split(" ");
        Stack<String> wStack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            wStack.push(strings[i]);
        }
        for (String item : wStack) {
            System.out.println(item);
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = wStack.pop();
        }
        for (String item : strings) {
            System.out.println(item);
        }
    }
}