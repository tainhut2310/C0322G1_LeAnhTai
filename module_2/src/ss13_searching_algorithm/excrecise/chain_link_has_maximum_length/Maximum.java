package ss13_searching_algorithm.practice.chain_link_has_maximum_length;

import java.util.LinkedList;
import java.util.Scanner;

public class Maximum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> maximumChar = new LinkedList<>();
        LinkedList<Character> listChar = new LinkedList<>();
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (listChar.size() > 0 && string.charAt(i) <= listChar.getLast() /*&& listChar.contains(string.charAt(i))*/) {
                listChar.clear();
            }
            listChar.add(string.charAt(i));
            if (listChar.size() > maximumChar.size()) {
                maximumChar.clear();
                maximumChar.addAll(listChar);
            }
        }
        for (Character item : maximumChar) {
            System.out.print(item);
        }
    }
}
