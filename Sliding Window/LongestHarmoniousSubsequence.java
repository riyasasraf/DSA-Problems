import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

  public static int findLHS(int[] nums) {
    HashMap<Integer, Integer> mpp = new HashMap<>();

    for (int i : nums) {
      mpp.put(i, mpp.getOrDefault(i, 0) + 1);
    }

    int ans = 0;

    for (int key : mpp.keySet()) {
      if (mpp.containsKey(key + 1)) {
        ans = Math.max(ans, mpp.get(key) + mpp.get(key + 1));
      }
    }
    return ans;
  }

}
