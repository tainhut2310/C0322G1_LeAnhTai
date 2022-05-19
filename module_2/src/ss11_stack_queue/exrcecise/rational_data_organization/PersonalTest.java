package ss11_stack_queue.exrcecise.rational_data_organization;

import java.util.*;

public class PersonalTest {
    public static void main(String[] args) {
        List<Personal> personalArrayList = new ArrayList<>();
        personalArrayList.add(new Personal(1, "Trần Công Hoàng Trung", true, 1996));
        personalArrayList.add(new Personal(2, "Nguyễn Thị Hoa", false, 1997));
        personalArrayList.add(new Personal(3, "Nguyễn Thị Mỹ Linh", false, 1998));
        personalArrayList.add(new Personal(4, "Trần Công Hoàng Quân", true, 1995));
        personalArrayList.add(new Personal(5, "Nguyễn Văn Tèo", true, 1994));
        personalArrayList.add(new Personal(6, "Trần Văn Tùng", true, 1993));

        Collections.sort(personalArrayList);
        for (Personal item : personalArrayList) {
            System.out.println(item);
        }
        System.out.print("---------------------------------");
        Queue<Personal> queueGirl = new LinkedList<>();
        Queue<Personal> queueBoy = new LinkedList<>();
        for (Personal item : personalArrayList) {
            if (item.isGender()) {
                queueBoy.add(item);
            } else {
                queueGirl.add(item);
            }
        }
        System.out.println("\nDữ liệu sau khi được sắp xếp lại");
        while (!queueGirl.isEmpty()) {
            System.out.println(queueGirl.poll());
        }
        while (!queueBoy.isEmpty()) {
            System.out.println(queueBoy.poll());
        }
    }
}
