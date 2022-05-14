package ss07_abstract_class_interface.excrecise.colorable_interface;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Square(25);
        shapes[1] = new Circle(15);
        shapes[2] = new Rectangle(20, 20);
        shapes[3] = new Square(30);
        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                System.out.print(shape + " ");
                ((Colorable) shape).howToColor();
            } else {
                System.out.println(shape);
            }
        }
    }
}
