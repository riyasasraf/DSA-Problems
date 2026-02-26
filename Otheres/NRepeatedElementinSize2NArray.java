package Otheres;

import java.util.HashMap;

public class NRepeatedElementinSize2NArray {
  public int repeatedNTimes(int[] nums) {

    int n = nums.length / 2;
    HashMap<Integer, Integer> mpp = new HashMap<>();
    for (int i : nums) {
      mpp.put(i, mpp.getOrDefault(i, 0) + 1);
    }
    for (int i : mpp.keySet()) {
      if (mpp.get(i) == n) {
        return i;
      }
    }
    return 0;
  }
}
