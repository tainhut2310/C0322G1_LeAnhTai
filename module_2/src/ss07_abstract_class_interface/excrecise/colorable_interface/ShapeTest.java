package ss07_abstract_class_interface.excrecise.colorable_interface;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        Shape shape1 = new Shape("black", false);
        System.out.println(shape1);
    }
}
