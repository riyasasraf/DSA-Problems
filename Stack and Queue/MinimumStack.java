import java.util.Stack;

public class MinimumStack {

  Stack<Integer> st;
  int min;

  public MinimumStack() {
    st = new Stack<Integer>();
    min = Integer.MAX_VALUE;

  }

  public void push(int val) {

    if (st.isEmpty()) {
      st.push(val);
      min = val;
    } else if (val < min) {
      st.push(2 * val - min);
      min = val;
    } else {
      st.push(val);
    }
  }

  public void pop() {
    if (st.isEmpty()) {
      return;
    }
    int top = st.pop();
    if (top < min) {
      min = 2 * min - top;
    }
    if (st.isEmpty()) {
      min = Integer.MAX_VALUE;
    }
  }

  public int top() {
    if (st.isEmpty())
      throw new RuntimeException("Stack is empty");
    int top = st.peek();
    if (top < min) {
      return min;
    } else {
      return top;
    }
  }

  public int getMin() {
    if (st.isEmpty())
      throw new RuntimeException("Stack is empty");
    return min;
  }
}
