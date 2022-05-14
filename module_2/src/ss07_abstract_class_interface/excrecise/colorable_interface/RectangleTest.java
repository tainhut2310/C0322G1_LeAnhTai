package ss07_abstract_class_interface.excrecise.colorable_interface;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        Rectangle rectangle1 = new Rectangle(10,20);
        System.out.println(rectangle1);

        Rectangle rectangle2 = new Rectangle(15, 25, "white", true);
        System.out.println(rectangle2);
    }
}
