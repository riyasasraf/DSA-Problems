package Otheres;

import java.util.Stack;

public class SumofSubarrayMinimums {
  static final long MOD = 1_000_000_007;

  public int sumSubarrayMins(int[] arr) {
    int[] nse = nse(arr);
    int[] pse = pse(arr);
    long total = 0;

    for (int i = 0; i < arr.length; i++) {
      int left = i - pse[i];
      int right = nse[i] - i;
      total = (total + (right * left * arr[i] * 1L) % MOD) % MOD;
    }
    return (int) total;

  }

  private int[] pse(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] pse = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
        st.pop();
      }
      pse[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    return pse;
  }

  private int[] nse(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] nse = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
        st.pop();
      }
      nse[i] = st.isEmpty() ? arr.length : st.peek();
      st.push(i);
    }
    return nse;
  }

}
