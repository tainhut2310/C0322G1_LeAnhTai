package ss11_stack_queue.exrcecise.string_check_using_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeUsingQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi ký tự muốn kiểm tra: ");
        String stringPalindrome = input.nextLine();
        String[] arrPalindrome = stringPalindrome.toLowerCase().split("");
        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();
        for (String item : arrPalindrome) {
            stringStack.push(item);
            stringQueue.add(item);
        }
//        System.out.println(stringStack);
//        System.out.println(stringQueue);
        boolean flag = false;
        while (!stringStack.isEmpty()) {
            if (stringStack.pop().equals(stringQueue.poll())) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Đây là chuỗi Palindrome");
        } else {
            System.out.println("Đây không phải là chuỗi Palindrome");
        }
    }
}
