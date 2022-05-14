package ss07_abstract_class_interface.excrecise.colorable_interface;


public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle1 = new Circle(20);
        System.out.println(circle1);

        Circle circle2 = new Circle(25, "red", false);
        System.out.println(circle2);
    }
}
