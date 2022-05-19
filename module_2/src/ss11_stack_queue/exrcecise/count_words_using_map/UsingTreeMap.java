package ss11_stack_queue.exrcecise.count_words_using_map;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class UsingTreeMap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi ký tự:");
        String wordChar = input.nextLine();
        String[] arrChar = wordChar.split(" ");
        int value = 0;
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arrChar.length; i++) {
            if (treeMap.containsKey(arrChar[i])) {
                value = treeMap.get(arrChar[i]) + 1;
                treeMap.put(arrChar[i], value);
            } else {
                value = 1;
                treeMap.put(arrChar[i], value);
            }
        }
        Set<String> keySet = treeMap.keySet();
        for (String item : keySet) {
            System.out.print(item + ":" + treeMap.get(item) + ",");
        }
    }
}
