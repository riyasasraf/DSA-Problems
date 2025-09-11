
// 152. Maximum Product Subarray
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
//solution

// Maintain two running products:one from the left(prefix)and one from the right(suffix).

// If a product becomes 0,reset it to 1(because multiplication restarts after zero).

// At each step,update the maximum product using the larger of prefix or suffix.

// This works because the maximum product subarray could be split by negative numbers,and checking from both sides ensures we capture the best case.


public class MaximumProductSubarray {
  public int maxProduct(int[] arr) {
    int max = Integer.MIN_VALUE;
    int pre = 1;
    int suf = 1;
    int n = arr.length;

    for (int i = 0; i < arr.length; i++) {
      if (pre == 0)
        pre = 1;
      if (suf == 0)
        suf = 1;
      pre = pre * arr[i];
      suf = suf * arr[n - i - 1];
      max = Math.max(max, Math.max(pre, suf));
    }
    return max;

  }
}
