import java.util.*;

class Solution {

    public int evaluatePostfix(String[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (!isOp(arr[i])) {
                st.add(Integer.parseInt(arr[i]));
            } else {
                if (st.size() >= 2) {
                    int b = st.pop();
                    int a = st.pop();
                    int c = apply(a, b, arr[i]);
                    st.add(c);
                }
            }
        }
        return st.pop();
    }

    private boolean isOp(String s) {
        return (
            s.equals("+") ||
            s.equals("-") ||
            s.equals("*") ||
            s.equals("/") ||
            s.equals("^")
        );
    }

    private int apply(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return (int) Math.floor((double) a / (double) b);
            case "^":
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
