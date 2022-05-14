package ss07_abstract_class_interface.excrecise.colorable_interface;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        Square square1 = new Square(20);
        System.out.println(square1);

        Square square2 = new Square(30, "green", false);
        System.out.println(square2);
        square2.howToColor();
    }
}
