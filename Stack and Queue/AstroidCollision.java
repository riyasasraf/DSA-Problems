import java.util.List;
import java.util.Stack;

public class AstroidCollision {

  public static void main(String[] args) {
    int[] ast = { 8, -8 };
    System.out.println(ast(ast).toString());
  }

  public static List<Integer> ast(int[] arr) {

    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {

      while (!st.isEmpty() && st.peek() < Math.abs(arr[i]) && arr[i] < 0) {
        st.pop();
      }
      if (!st.isEmpty() && st.peek() == Math.abs(arr[i]))
        st.pop();
      else if (st.isEmpty() && arr[i] < 0) {
        st.add(arr[i]);
      }
      if (arr[i] > 0)
        st.add(arr[i]);
    }

    return st.stream().toList();

  }

}
