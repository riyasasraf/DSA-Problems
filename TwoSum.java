// problem Statement
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.


//Solution


// "Use a map to store each number from the array along with its index.

// For each element in the array, calculate the difference (target - current number).

// Check if this difference already exists in the map:

// If yes → return the stored index (for the difference) and the current index.

// If no → store the current number and its index in the map.

// If no pair is found by the end, return {-1, -1}."

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int [] nums = {2,7,11,15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums,target)));
    }

      public static int[] twoSum(int[] nums, int target) {
        Map <Integer,Integer> mpp = new HashMap<>();

        for(int i = 0; i < nums.length;i++){
            int diff = target - nums[i];
            if(mpp.containsKey(diff)){
                return new int [] {mpp.get(diff), i};
            }
            mpp.put(nums[i], i);
        }
        return new int [] {-1,-1};

    }
}


