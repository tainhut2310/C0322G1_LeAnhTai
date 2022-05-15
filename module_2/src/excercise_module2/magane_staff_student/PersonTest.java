package excercise_module2.magane_staff_student;

import java.util.Scanner;

public class PersonTest {
    public static Person[] personList = new Person[50];
    public static int count;
    static Scanner input = new Scanner(System.in);

    static {
        personList[0] = new Teacher(1, "Nguyễn Văn Tèo", 20, true, 15000000);
        personList[1] = new Student(2, "Nguyễn Văn Hùng", 30, true, 8);
        personList[2] = new Teacher(3, "Trần Văn Long", 32, true, 13000000);
        personList[3] = new Student(4, "Lê Bá Long ", 22, true, 9);
        personList[4] = new Teacher(5, "Nguyễn Thị Tuyết", 28, false, 12000000);
        personList[5] = new Student(6, "Nguyễn Phi Long", 36, true, 7);
        personList[6] = new Teacher(7, "Lê Thị Huyền", 19, false, 10000000);
        count = 7;
    }

    public static void displayList() {
        for (Person item : personList) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public static void addNewPerson() {
        if (count < personList.length - 1) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.print("Choose options: ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Nhập tên:");
                    String nameStudent = input.nextLine();
                    System.out.println("Nhập tuổi:");
                    int ageStudent = Integer.parseInt(input.nextLine());
                    System.out.println("Nhập giới tính:");
                    boolean genderStudent = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Nhập điểm:");
                    double pointStudent = Double.parseDouble(input.nextLine());
                    Person person = new Student(count + 1, nameStudent, ageStudent, genderStudent, pointStudent);
                    personList[count] = person;
                    count++;
                    break;
                case 2:
                    System.out.println("Nhập tên:");
                    String nameTeacher = input.nextLine();
                    System.out.println("Nhập tuổi:");
                    int ageTeacher = Integer.parseInt(input.nextLine());
                    System.out.println("Nhập giới tính:");
                    boolean genderTeacher = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Nhập lương:");
                    double salaryTeacher = Double.parseDouble(input.nextLine());
                    Person person1 = new Teacher(count + 1, nameTeacher, ageTeacher, genderTeacher, salaryTeacher);
                    personList[count] = person1;
                    count++;
                    break;
                default:
                    System.out.println("Not in the option please re-enter");
            }
        } else {
            System.out.println("Bộ nhớ đã hết không thể thêm");
        }
    }

    public static void SearchPerson() {
        System.out.print("Nhập tên muốn tìm :");
        String find = input.nextLine();
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] != null && (personList[i].getName().contains(find))) {
                System.out.println(personList[i]);
            }
        }
    }

    public static void DeletePerson() {
        boolean flag = false;
        int index = 0;
        System.out.print("Nhập id muốn xóa: ");
        int placeId = Integer.parseInt(input.nextLine());
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] != null && placeId == personList[i].getId()) {
                flag = true;
                index = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Vị trí bạn muốn xóa ở vị trí thứ: " + index + 1);
            personList[index] = null;
        } else {
            System.out.println("Id bạn muốn xóa không có trong danh sách");
        }
        displayList();
    }

    public static void UpdatePerson() {
        boolean flag = false;
        int index = 0;
        System.out.print("Nhập id muốn update: ");
        int placeId = Integer.parseInt(input.nextLine());
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] != null && personList[i].getId() == placeId) {
                flag = true;
                index = i;
                if (personList[i] instanceof Teacher) {
                    Teacher teacher = (Teacher) personList[i];
                    System.out.println("Nhập tên:");
                    String nameTeacher = input.nextLine();
                    System.out.println("Nhập tuổi:");
                    int ageTeacher = Integer.parseInt(input.nextLine());
                    System.out.println("Nhập giới tính:");
                    boolean genderTeacher = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Nhập lương:");
                    double salaryTeacher = Double.parseDouble(input.nextLine());
                    teacher.setName(nameTeacher);
                    teacher.setAge(ageTeacher);
                    teacher.setGender(genderTeacher);
                    teacher.setSalary(salaryTeacher);
                } else {
                    Student student = (Student) personList[i];
                    System.out.println("Nhập tên:");
                    String nameStudent = input.nextLine();
                    System.out.println("Nhập tuổi:");
                    int ageStudent = Integer.parseInt(input.nextLine());
                    System.out.println("Nhập giới tính:");
                    boolean genderStudent = Boolean.parseBoolean(input.nextLine());
                    System.out.println("Nhập điểm:");
                    double pointStudent = Double.parseDouble(input.nextLine());
                    Person person = new Student(count + 1, nameStudent, ageStudent, genderStudent, pointStudent);
                    personList[count] = person;
                    student.setName(nameStudent);
                    student.setAge(ageStudent);
                    student.setGender(genderStudent);
                    student.setPoint(pointStudent);
                }
            }
        }
        if (flag) {
            System.out.println("Vị trí bạn muốn xóa ở vị trí thứ: " + index + 1);
        } else {
            System.out.println("Id bạn muốn xóa không có trong danh sách");
        }
        displayList();
    }

    public static void main(String[] args) {
        do {
            System.out.println("-------------Person Management-----------");
            System.out.println("1. Display list Person");
            System.out.println("2. Add new Person");
            System.out.println("3. Search Person");
            System.out.println("4. Delete Person");
            System.out.println("5. Update Person");
            System.out.println("6. Exit");
            System.out.print("Choose options: ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Display list Person");
                    displayList();
                    break;
                case 2:
                    System.out.println("Add new Person");
                    addNewPerson();
                    break;
                case 3:
                    System.out.println("Search Person");
                    SearchPerson();
                    break;
                case 4:
                    System.out.println("Delete Person");
                    DeletePerson();
                    break;
                case 5:
                    System.out.println("Update Person");
                    UpdatePerson();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not in the option please re-enter");
            }
        } while (true);
    }
}
