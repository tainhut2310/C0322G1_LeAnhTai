package ss04_class_object_to_java.excrecise.build_quadratic_equation;

public class QuadraticEquation {
    private double numberA, numberB, numberC;

    public QuadraticEquation(double numberA, double numberB, double numberC) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.numberC = numberC;
    }

    public double getNumberA() {
        return this.numberA;
    }

    public double getNumberB() {
        return this.numberB;
    }

    public double getNumberC() {
        return this.numberC;
    }

    public double getDiscriminant() {
        return Math.pow(this.numberB, 2) - 4 * this.numberA * this.numberC;
    }

    public double getRoot() {
        return -this.numberB / 2 * this.numberA;
    }

    public double getRoot1() {
        return (-this.numberB + Math.sqrt(Math.pow(this.numberB, 2) - 4 * this.numberA * this.numberC)) / 2 * this.numberA;
    }

    public double getRoot2() {
        return (-this.numberB - Math.sqrt(Math.pow(this.numberB, 2) - 4 * this.numberA * this.numberC)) / 2 * this.numberA;
    }
}
