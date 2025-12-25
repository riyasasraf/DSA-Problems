// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

// The majority element appears more than n/2 times.

// Keep a counter count and a candidate:

// If count == 0 → choose the current number as the new candidate.

// If the current number equals the candidate → increment count.

// Otherwise → decrement count.

// At the end, candidate is guaranteed to be the majority element.
public class MajorityElement {
  public int majorityElement(int[] nums) {
    int count = 0;
    int prev = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (prev == nums[i]) {
        count++;
      } else if (prev != nums[i]) {
        count--;
      } else if (count == 0) {
        prev = nums[i];
        count++;
      }
    }
    return prev;

  }
}
