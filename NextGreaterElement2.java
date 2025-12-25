import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 1 };

    System.out.println(Arrays.toString(nextGreaterElements(nums)));
  }

  public static int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] nge = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = (n * 2) - 1; i >= 0; i--) {

      while (!st.isEmpty() && st.peek() <= nums[i % n]) {
        st.pop();
      }
      if (st.isEmpty()) {
        if (i < n) {
          nge[i % n] = -1;
        }

      } else {
        if (i < n) {
          nge[i % n] = st.peek();
        }
      }
      st.push(nums[i % n]);
    }
    return nge;
  }
}
