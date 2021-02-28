package org.example.ch3;

public class Expression {
    public static void main(String[] args) {
        String expression = "1 + 3 / 2 + 3 * 4";
        Stack<Operator> operatorStack = new Stack<>();
        Stack<Float> numberStack = new Stack<>();
        String[] e = expression.split(" ");

        for (int idx = 0; idx < e.length; idx++) {
            String s = e[idx];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Operator current = Operator.getOperator(s);
                if (!operatorStack.isEmpty()) {
                    Operator top = operatorStack.getTop();
                    if(top.getPriority()< current.getPriority()) {
                        Integer right = Integer.parseInt(e[++idx]);
                        Float left = numberStack.pop();
                        switch (s){
                            case "+":
                                numberStack.push(left + right);
                                break;
                            case "-":
                                numberStack.push(left - right);
                                break;
                            case "*":
                                numberStack.push(left * right);
                                break;
                            case "/":
                                numberStack.push( left / right);
                                break;
                        }
                    } else {
                        operatorStack.push(current);
                    }
                } else {
                    operatorStack.push(current);
                }
            } else {
                numberStack.push(Float.parseFloat(s));
            }
        }
        while (!numberStack.isEmpty() && !operatorStack.isEmpty()) {
            Float left = numberStack.pop();
            Float right = numberStack.pop();
            Operator operator = operatorStack.pop();
            switch (operator.getFlag()){
                case "+":
                    numberStack.push(left + right);
                    break;
                case "-":
                    numberStack.push(left - right);
                    break;
                case "*":
                    numberStack.push(left * right);
                    break;
                case "/":
                    numberStack.push(left / right);
                    break;
            }
        }
        System.out.println(numberStack.pop());
    }


}
enum Operator{

    plus("+"), minus("-"),multiply("*"), divide("/");
    private String flag;
    private int priority;

    Operator(String flag) {
        this.flag = flag;
        if(flag.equals("-") || flag.equals("+")) {
            priority = 1;
        }
        if (flag.equals("*") || flag.equals("/")) {
            priority = 2;
        }
        if (flag.equals("(")) {
            priority = 0;
        }
        if (flag.equals(")")) {
            priority = 3;
        }
    }

    public static Operator getOperator(String s) {
        switch (s) {
            case "+":
                return plus;
            case "-":
                return minus;
            case "*":
                return multiply;
            case "/":
                return divide;
        }
        return null;
    }
    public String getFlag() {
        return flag;
    }

    public int getPriority() {
        return priority;
    }
}