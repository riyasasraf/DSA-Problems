import java.util.Stack;

public class NextGreaterElementI {

  public static void main(String[] args) {
    int[] nums1 = { 4, 1, 2 };
    int[] nums2 = { 1, 3, 4, 2 };

    nextGreaterElement(nums1, nums2);
  }

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = nge(nums2, nums1[i]);
    }

    return nums1;
  }

  public static int nge(int[] arr, int tg) {
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {

      if (arr[i] == tg) {
        if (st.isEmpty())
          return -1;
        return st.pop();
      }
      while (!st.isEmpty() && st.peek() < arr[i]) {
        st.pop();
      }
      st.push(arr[i]);
    }
    return -1;

  }
}
