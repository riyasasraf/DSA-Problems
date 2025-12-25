// Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
//solution

// Maintain a running sum currentSum.

// Add each number to it.

// If currentSum becomes negative, reset it to 0 (because a negative prefix will only reduce future sums).

// Track the maximum sum seen so far in maxSum.
public class MaximumSubarray {
  public static void main(String[] args) {

  }
  
  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum > max) {
        max = sum;
      }
      if (sum < 0) {
        sum = 0;
      }

    }
    return max;

  }
}
