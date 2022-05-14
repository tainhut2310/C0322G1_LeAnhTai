package ss07_abstract_class_interface.excrecise.resizeable_interface;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(20, 14);
        shapes[2] = new Square(30);
        System.out.println("Kích thước tại thời điểm chưa thay đổi");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("Kích thước sau khi thay đổi");
        for (Shape shape : shapes) {
            shape.resize(Math.random() * 99 + 1);
            System.out.println(shape);
        }
    }
}
