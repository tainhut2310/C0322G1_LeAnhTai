package ss11_stack_queue.exrcecise.check_brackets_in_expression;

import java.util.Stack;

public class BracketsInExpression {
    public static void main(String[] args) {
        Stack<String> bStack = new Stack<>();
        String sym = " s * (s – a) * (s – b * (s – c)";
        String[] arrSym = sym.split("");
        boolean flag = true;
        String left = "";
        for (String item : arrSym) {
            if (item.equals("(")) {
                bStack.push(item);
            } else if (item.equals(")")) {
                if (bStack.isEmpty()) {
                    flag = false;
                } else {
                    bStack.pop();
                }
            }
        }
        if (!bStack.isEmpty()) {
            flag = false;
        }
        if (flag) {
            System.out.println("Biểu thức đúng");
        } else {
            System.out.println("Biểu thức sai");
        }
    }
}
