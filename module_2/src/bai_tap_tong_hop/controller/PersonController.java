package bai_tap_tong_hop.controller;

import bai_tap_tong_hop.service.PersonServiceArray;
import bai_tap_tong_hop.service.PersonServiceArrayList;
import bai_tap_tong_hop.service.PersonServiceLinkedList;
import bai_tap_tong_hop.service.PersonServiceMap;

import java.util.Scanner;

public class PersonController {
    public static Scanner scanner = new Scanner(System.in);
    public static PersonServiceArray personService = new PersonServiceArray();
    public static PersonServiceArrayList personServiceArrayList = new PersonServiceArrayList();
    public static PersonServiceLinkedList personServiceLinkedList = new PersonServiceLinkedList();
    public static PersonServiceMap personServiceMap = new PersonServiceMap();

    public static void menu() {
        int choose;
        do {
            System.out.println("1. Display array Nhân Viên");
            System.out.println("2. Display arrayList Nhân Viên");
            System.out.println("3. Display LinkedList Nhân Viên");
            System.out.println("4. Display TreeMap Nhân Viên");
            System.out.println("5. Sort Person");
            System.out.println("6. Exit");
            System.out.print("Choose options: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    personService.displayList();
                    break;
                case 2:
                    personServiceArrayList.displayList();
                    break;
                case 3:
                    personServiceLinkedList.displayList();
                    break;
                case 4:
                    personServiceMap.displayListMap();
                case 5:
                    personServiceLinkedList.sortPerson();
                    break;
                case 6:
                    System.exit(0);
                default:
                System.out.println("Lựa chọn không có trong Menu!");
            }
        } while (true);
    }
}
