import java.util.ArrayList;
import java.util.List;

public class PrintSSet {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 2, 3, 4 };
    printsset(arr, 0, new ArrayList<>(), 5);
  }

  static void printsset(int[] arr, int n, List<Integer> sset, int target) {

    if (target == 0) {
      System.out.println(sset.toString());
      return;
    }

    if (n == arr.length) {
      return;
    }

    for (int i = n; i < arr.length; i++) {

      if (i > n && arr[i] == arr[i - 1]) {
        continue;
      }
      sset.add(arr[i]);
      printsset(arr, i + 1, sset, target - arr[i]);
      sset.removeLast();
      printsset(arr, i + 1, sset, target);
    }

  }

}
