package model;

public class Calculator {
    public Calculator() {
    }
    public static double calculator (double firstOperand, double lastOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + lastOperand;
            case '-':
                return firstOperand - lastOperand;
            case '*':
                return firstOperand * lastOperand;
            case '/':
                if (lastOperand != 0) {
                    return firstOperand / lastOperand;
                } else {
                    throw new RuntimeException("Can't divide by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
