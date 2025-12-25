import java.util.HashMap;

public class SubarraySumEqualsK {
  // Given an array of integers nums and an integer k, return the total number of
  // subarrays whose sum equals to k.

  // A subarray is a contiguous non-empty sequence of elements within an array.

  // Example 1:

  // Input: nums = [1,1,1], k = 2
  // Output: 2
  // Example 2:

  // Input: nums = [1,2,3], k = 3
  // Output: 2
  // solution
  // Maintain a running sum (sum), which represents the sum from start to current
  // index.

  // For each index:

  // We want the number of earlier prefix sums where:
  // previousSum = sum - k
  // → because (sum - previousSum) = k.

  // Add how many times that previousSum occurred so far to count.

  // Update the map: prefixCount[sum]++.

  // Start with {0:1} to handle subarrays starting at index 0.
  public int subarraySum(int[] nums, int k) {

    HashMap<Integer, Integer> mpp = new HashMap<>();
    int sum = 0;
    int count = 0;
    mpp.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      int presum = sum - k;
      if (mpp.containsKey(presum)) {
        count += mpp.get(presum);
      }
      mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
    }
    return count;

  }
}
