package ss06_inheritance.excrecise.class_inhertance;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public double getArea() {
        return super.getArea() * 2 + 2 * Math.PI * height * super.getRadius();
    }

    @Override
    public String toString() {
        return "Cylinder{" + super.toString() +
                ", height=" + height +
                ", area=" + getArea() +
                ", volume=" + getVolume() +
                '}';
    }
}
