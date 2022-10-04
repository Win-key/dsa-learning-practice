package general;

import utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator("16/8/4+(9*2)+7+9*3+6*(6+(9*2))/2");
        Double val = expressionEvaluator.solve();
        Utils.print(val);
    }

    private int pos = 0;
    private final String expression;
    private final Predicate<Character> isNumberChar = d -> d <= '9' && d >= '0';

    public ExpressionEvaluator(String expression) {
        this.expression = expression.replaceAll("\\s", "");
    }


    public Double solve() {
        Deque<Double> num = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();
        String val = nextVal(expression);
        while (val.length() > 0) {
            // push number
            if (isNumber(val)) num.push(Double.valueOf(val));
            // push open bracket
            else if ("(".equals(val)) operators.push(val);
            // process inner expression
            else if (")".equals(val)) {
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Parenthesis are empty");
                }
                String oprt = operators.pop();
                while (!"(".equals(oprt)) {
                    evaluateTop(num, oprt);
                    oprt = operators.pop();
                }
            }
            // evaluate based on priority and push operators
            else {
                while (!operators.isEmpty()
                        && priority(operators.peek()) >= priority(val)) {
                    evaluateTop(num, operators.pop());
                }
                operators.push(val);
            }

            // move to next value in expression
            val = nextVal(expression);
        }
        // calculate final result
        while (!operators.isEmpty()) {
            evaluateTop(num, operators.pop());
        }
        return num.pop();

    }

    private void evaluateTop(Deque<Double> num, String val) {
        Double right = num.pop();
        Double left = num.pop();
        Double res = calculate(val, left, right);
        // push final result back to number stack
        num.push(res);
    }

    // perform mathematical operations based on the given operation
    private static Double calculate(String operation, double left, double right) {
        if ("+".equals(operation))
            return left + right;
        if ("-".equals(operation))
            return left - right;
        if ("*".equals(operation))
            return left * right;
        if ("/".equals(operation))
            return left / right;
        return 0d;
    }

    // Check is it a number or not
    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Gets the next value in expresison. Could be either a number or math operator or ( or )
    private String nextVal(String expression) {
        if(pos < expression.length() && !isNumberChar.test(expression.charAt(pos)))
            return String.valueOf(expression.charAt(pos++));

        StringBuilder sb = new StringBuilder();
        while (pos < expression.length()) {
            char c = expression.charAt(pos++);
            if (!isNumberChar.test(c)) {
                pos--;
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // Defines the priority of the operator
    public static int priority(String operator) {
        if ("+".equals(operator) || "-".equals(operator))
            return 0;
        if ("*".equals(operator))
            return 1;
        if ("/".equals(operator))
            return 2;

        return -1;
    }

}
