import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

  public static void main(String[] args) {
    List<List<Integer>> result = new ArrayList<>();
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int n = 7;
    int k = 3;
    com3(arr, 0, n, k, new ArrayList<>(), result);
    System.out.println(result.toString());
  }

  static void com3(int[] arr, int ind, int target, int size, List<Integer> sub, List<List<Integer>> result) {

    if (target == 0 && size == 0) {
      result.add(new ArrayList<>(sub));
      return;
    }
    if (ind == arr.length || size < 0) {
      return;
    }
    if (arr[ind] <= target) {
      sub.add(arr[ind]);
      com3(arr, ind + 1, target - arr[ind], size - 1, sub, result);
      sub.remove(sub.size() - 1);
    }
    com3(arr, ind + 1, target, size, sub, result);
  }

}
