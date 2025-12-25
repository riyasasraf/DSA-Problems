import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

  public static void main(String[] args) {
    int[] nums = { 1, 3, 4, 2 };
    int[] nums2 = { 4, 1, 2 };

    System.out.println(Arrays.toString(nextGreaterElement(nums, nums2)));
  }

  public static int[] nextGreaterElement(int[] nums, int[] nums2) {
    HashMap<Integer, Integer> mpp = new HashMap<>();
    int n = nums.length;
    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {

      while (!st.empty() && st.peek() < nums[i]) {
        st.pop();
      }
      mpp.put(nums[i], st.empty() ? -1 : st.peek());

      st.push(nums[i]);
    }
    int nge[] = new int[nums2.length];

    for (int i = 0; i < nums2.length; i++) {
      nge[i] = mpp.get(nums2[i]);
    }

    return nge;
  }

}