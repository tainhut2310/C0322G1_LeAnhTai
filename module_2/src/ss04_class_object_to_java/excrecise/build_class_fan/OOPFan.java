package ss04_class_object_to_java.excrecise.build_class_fan;

public class OOPFan {
    public static void main(String[] args) {
        Fan fan = new Fan(3, true, 10, "Yellow");
        System.out.println(fan);

        Fan fan2 = new Fan(2, false, 5, "Blue");
        System.out.println(fan2);
    }
}