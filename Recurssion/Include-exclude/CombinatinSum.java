import java.util.ArrayList;
import java.util.List;

public class CombinatinSum {

  public static void main(String[] args) {

    int[] arr = { 2, 3, 6, 7 };
    List<List<Integer>> result = new ArrayList<>();
    comSum(0, 7, arr, result, new ArrayList<>());
    System.out.println(result.toString());

  }

  static void comSum(int i, int target, int[] arr, List<List<Integer>> result, List<Integer> sub) {

    if (target == 0) {
      result.add(new ArrayList<>(sub));
      return;
    }
    if (i == arr.length) {
      return;
    }
    if (arr[i] <= target) {
      sub.add(arr[i]);
      comSum(i, target - arr[i], arr, result, sub);
      sub.remove(sub.size() - 1);
    }
    comSum(i + 1, target, arr, result, sub);

  }

}
