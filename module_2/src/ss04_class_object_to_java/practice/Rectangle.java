package ss04_class_object_to_java.practice;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the width:");
        double width = Double.parseDouble(input.nextLine());

        System.out.print("Enter the height:");
        double height = Double.parseDouble(input.nextLine());

        OOPRectangle rectangle = new OOPRectangle(width, height);

        System.out.println("Your Rectangle: \n" + rectangle.display());
        System.out.println("Perimeter of the Rectangle: " + rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: " + rectangle.getArea()) ;
    }
}
    class OOPRectangle {
        double width, height;
        public OOPRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return this.width * this.height;
        }

        public double getPerimeter() {
            return (this.width * this.height ) * 2;
        }

        public  String display() {
            return "Rentangle{" + "width=" + width + ", height=" + height + "}";
        }
    }

