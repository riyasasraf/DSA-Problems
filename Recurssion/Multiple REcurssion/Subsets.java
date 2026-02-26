import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3 };

    List<List<Integer>> ans = new ArrayList<>();
    ps(arr, 0, new ArrayList<>(), ans);
    System.out.println(ans);
  }

  static void ps(int[] arr, int i, List<Integer> sub, List<List<Integer>> ans) {
    if (i == arr.length) {
      
      ans.add(sub);
      return;
    }
    sub.addLast(arr[i]);
    ps(arr, i + 1, sub, ans);
    sub.removeLast();
    ps(arr, i + 1, sub, ans);
  }
}
