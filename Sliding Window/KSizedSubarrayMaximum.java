import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class KSizedSubarrayMaximum {
  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
    int k = 3;
    System.out.println(maxOfSubarrays(arr, k));
  }

  public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < arr.length; i++) {

      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
        deque.pollLast()();
      }
      deque.offer(i);
      if (i >= k - 1) {
        ans.add(arr[deque.peekFirst()]);

      }
    }

    return ans;
  }

}