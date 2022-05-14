package ss07_abstract_class_interface.excrecise.resizeable_interface;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        Square square1 = new Square(8);
        System.out.println(square1);

        Square square2 = new Square(6, "blue", true);
        System.out.println(square2);
    }
}
