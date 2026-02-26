package Expressions;

import java.util.Stack;

public class EvalRPN {

  public static void main(String[] args) {
    String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
    System.out.println(evalRPN(tokens));
  }

  public static int evalRPN(String[] s) {
    Stack<String> st = new Stack<>();
    for (int i = 0; i < s.length; i++) {
      String ch = s[i];
      if (!st.isEmpty() && isOperator(ch)) {
        int a = Integer.parseInt(st.pop());
        int b = Integer.parseInt(st.pop());
        String op = ch;
        st.push(evaluate(b, a, op).toString());
      } else {
        st.push(ch);
      }
    }
    return Integer.parseInt(st.peek());
  }

  public static Integer evaluate(int a, int b, String op) {
    if (op.equals("+")) {
      return a + b;
    } else if (op.equals("-")) {
      return a - b;
    } else if (op.equals("*")) {
      return a * b;
    } else if (op.equals("/")) {
      return a / b;
    }
    return 0;
  }

  public static boolean isOperator(String ch) {
    return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
  }
}
