package ss03_array_to_java.practice;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter a name's student:");
        String input_name = input.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length ; i++) {
            if (input_name.equals(students[i])) {
                System.out.println("Position of the student in the list " + input_name + " is: " + i);
                isExist = true;
                break;
            }
        }
        if(!isExist) {
            System.out.println("Not found" + input_name + " in the list.");
        }
    }
}
