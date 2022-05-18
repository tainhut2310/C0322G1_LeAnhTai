package ss10_dsa_danh_sach.practice.implementation_method_linked_list;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>(10);
        integerLinkedList.addFirst(11);
        integerLinkedList.addFirst(18);
        integerLinkedList.addFirst(17);
        integerLinkedList.addFirst(11);
        integerLinkedList.addFirst(12);
        integerLinkedList.addLast(11);
        integerLinkedList.addLast(71);
        integerLinkedList.addLast(19);
        integerLinkedList.add(1, 15);
        integerLinkedList.printList();
        System.out.println(integerLinkedList.removeFirst());
        System.out.println(integerLinkedList.removeLast());
        System.out.println(integerLinkedList.clone());

    }
}
