package ss12_java_collection_framework.practice.using_hashmap_linkedhashmap_treemap;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        System.out.println("-------------------------------");
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        System.out.println("----------------------------");

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
        System.out.println(linkedHashMap);

        Map<Integer, String> treeeMap = new TreeMap<>();
        treeeMap.put(1, "One");
        treeeMap.put(2, "Two");
        treeeMap.put(3, "Three");
        treeeMap.put(4, "Four");
        treeeMap.put(4, "Five");
        treeeMap.put(5, null);
        treeeMap.put(6, "Two");
        System.out.println(treeeMap.get(4));
        System.out.println(treeeMap.containsKey(1));
        System.out.println(treeeMap.get(10));
        // Trả về 1 Set lưu trữ key của Map
        Set<Integer> keySet = treeeMap.keySet();
        for (Integer item : keySet) {
            System.out.println(treeeMap.get(item));
        }
        // Cách duyệt nhanh bằng entrySet
        for (Map.Entry<Integer, String> item : treeeMap.entrySet()) {
            System.out.println("Key:" + item.getKey() + "Value:" + item.getValue());
        }
    }
}
