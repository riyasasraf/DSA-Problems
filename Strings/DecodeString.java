package Strings;

import java.util.Stack;

public class DecodeString {

  public static void main(String[] args) {
    String s = "2[abc]3[cd]ef";
    System.out.println(decodeString(s));
  }

  public static String decodeString(String s) {

    Stack<Integer> nums = new Stack<>();
    Stack<StringBuilder> chars = new Stack<>();

    StringBuilder cur = new StringBuilder();
    int num = 0;
    for (char ch : s.toCharArray()) {

      if (Character.isDigit(ch)) {
        num = num * 10 + (ch - '0');
      } else if (ch == '[') {
        nums.push(num);
        chars.push(cur);
        num = 0;
        cur = new StringBuilder();
      } else if (ch == ']') {
        int count = nums.pop();
        StringBuilder st = chars.pop();
        while (count > 0) {
          st.append(cur);
          count--;
        }
        cur = st;
      } else {
        cur.append(ch);

      }

    }

    return cur.toString();

  }
}
