package general;

import java.util.Stack;

public class BalancedExpression {

    private static final char OPEN_SQR = '[';
    private static final char CLOSE_SQR = ']';
    private static final char OPEN_CIR = '(';
    private static final char CLOSE_CIR = ')';
    private static final char OPEN_CURL = '{';
    private static final char CLOSE_CURL = '}';

    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        System.out.println(exp + " : " + solve(exp));
        exp = "[(])";
        System.out.println(exp + " : " + solve(exp));
    }

    private static boolean solve(String exp) {
        Stack<Character> mem = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (!mem.isEmpty() && checkClose(exp.charAt(i), mem.peek())) {
                mem.pop();
            } else {
                mem.add(exp.charAt(i));
            }
        }
        return mem.isEmpty();
    }

    private static boolean checkClose(char charAt, char peek) {
        switch (peek) {
            case OPEN_SQR:
                return charAt == CLOSE_SQR;
            case OPEN_CIR:
                return charAt == CLOSE_CIR;
            case OPEN_CURL:
                return charAt == CLOSE_CURL;
        }
        return false;
    }
}
