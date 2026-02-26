import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

  public static void main(String[] args) {

  }

  static void comsumII(List<List<Integer>> result, int ind, int target, int[] arr, List<Integer> sub) {

    if (target == 0) {
      result.add(new ArrayList<>(sub));
      return;
    }
    if (ind == arr.length) {
      return;
    }
    for (int i = ind; i < arr.length; i++) {
      if (i > ind && arr[i] == arr[i - 1]) {
        continue;
      }
      if (arr[i] > target)
        break;
      sub.add(arr[i]);
      comsumII(result, ind + 1, target - arr[i], arr, sub);
      sub.remove(sub.size() - 1);
    }

  }

}