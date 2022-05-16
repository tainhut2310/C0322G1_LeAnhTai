package ss08_clean_code_refactoring.practice.change_variable_name_and_detached_const;

public class Calculator {
    public static int calculate(int firstOperand , int secondOperand , char operator ) {
        switch (operator ) {
            case '+':
                return firstOperand  + secondOperand ;
            case '-':
                return firstOperand  - secondOperand ;
            case '*':
                return firstOperand  * secondOperand ;
            case '/':
                if (secondOperand  != 0)
                    return firstOperand  / secondOperand ;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
