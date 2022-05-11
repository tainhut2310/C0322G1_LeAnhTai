package ss04_class_object_to_java.excrecise.build_quadratic_equation;

import ss04_class_object_to_java.excrecise.build_quadratic_equation.QuadraticEquation;

import java.util.Scanner;

public class OOPQuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double numberA = Double.parseDouble(input.nextLine());

        System.out.print("Enter coefficient b: ");
        double numberB = Double.parseDouble(input.nextLine());

        System.out.print("Enter coefficient c: ");
        double numberC = Double.parseDouble(input.nextLine());

        QuadraticEquation quadraticEquation = new QuadraticEquation(numberA, numberB, numberC);
        double resultDelta = quadraticEquation.getDiscriminant();
        if (resultDelta > 0) {
            System.out.println("Phuong trinh co hai nghiem: x1= " + quadraticEquation.getRoot1() + ", x2= " + quadraticEquation.getRoot2());
        } else if (resultDelta == 0) {
            System.out.println("Phuong trinh co nghiem kep: x1=x2= " + quadraticEquation.getRoot());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
