import java.util.List;

public class SubsetSumExists {

  public static void main(String[] args) {

  }

  static int isExsit(int[] arr, int target, int n) {
    if (n == arr.length) {
      return target == 0 ? 1 : 0;
    }

    int pick = isExsit(arr, target - arr[n], n + 1);
    int notpick = isExsit(arr, target, n + 1);
    return pick + notpick;
  }

}
