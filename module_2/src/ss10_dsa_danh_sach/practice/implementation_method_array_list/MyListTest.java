package ss10_dsa_danh_sach.practice.implementation_method_array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(3);
        myList.add(3);
        myList.add(5);
        myList.add(6);
        myList.add(1, 9);

        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        System.out.println(myList.get(3));

//        myList.remove(2);
        System.out.println(myList);

        System.out.println(myList.size());
        System.out.println(myList.contains(5));
        System.out.println(myList.indexOf(5));

        myList.clear();
        System.out.println(myList);
    }
}
