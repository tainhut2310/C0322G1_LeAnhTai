package ss07_abstract_class_interface.excrecise.colorable_interface;

public class Square extends Shape implements Colorable {
    private double length = 1.0;

    public Square() {
    }

    public Square(double length) {
        this.length = length;
    }

    public Square(double length, String color, boolean filled) {
        super(color, filled);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return length * length;
    }

    public double getPerimeter() {
        return 4 * length;
    }

    @Override
    public String toString() {
        return "A Square width length= " +
                getLength() + ",Diện tích= " +
                getArea();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
