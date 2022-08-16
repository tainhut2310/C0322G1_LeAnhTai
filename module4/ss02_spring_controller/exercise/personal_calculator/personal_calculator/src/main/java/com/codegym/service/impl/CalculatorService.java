package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double calculator(double firstOperand, double lastOperand, char operator) {
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
