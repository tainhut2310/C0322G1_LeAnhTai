package ss05_access_modifier_static_method_static_property.excrecise.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

     protected double getRadius() {
        return radius;
    }

     protected String getColor() {
        return color;
    }

    protected double getArea() {
        return radius * radius * Math.PI;
    }
}
