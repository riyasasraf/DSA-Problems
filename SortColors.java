

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]

//solution

// Maintain 3 regions:

// [0..left-1]→all 0 s

// [left..mid-1]→all 1 s

// [right+1..end]→all 2 s

// Traverse with mid:

// If nums[mid]==0→swap with left,expand left,move mid.

// If nums[mid]==1→just move mid.

// If nums[mid]==2→swap with right,shrink right(don’t move mid yet).


public class SortColors {
  public void sortColors(int[] nums) {
    int l = 0;
    int m = 0;
    int r = nums.length - 1;

    while (m <= r) {
      if (nums[m] == 0) {
        swap(nums, l, m);
        l++;
        m++;
      } else if (nums[m] == 1) {
        m++;
      } else if (nums[m] == 2) {
        swap(nums, m, r);
        r--;
      }
    }

  }

  public static void swap(int[] arr, int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }
}
