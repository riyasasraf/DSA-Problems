import java.util.Stack;

public class RemoveKDigits {

  public static void main(String[] args) {
    System.out.println(removeKdigits("123456", 3));
  }

  public static String removeKdigits(String num, int k) {

    Stack<Character> st = new Stack<>();

    for (char ch : num.toCharArray()) {
      while (!st.isEmpty() && k > 0 && st.peek() > ch) {
        st.pop();
        k--;
      }
      st.push(ch);
    }

    while (k > 0) {
      st.pop();
      k--;
    }

    StringBuilder res = new StringBuilder();
    for (char ch : st)
      res.append(ch);

    while (res.length() > 0 && res.charAt(0) == '0') {
      res.deleteCharAt(0);
    }
    while (k > 0 && res.length() > 0) {

      res.deleteCharAt(res.length() - 1);
      k--;
    }

    return res.length() != 0 ? res.toString() : "0";
  }

}
