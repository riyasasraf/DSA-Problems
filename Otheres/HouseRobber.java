package Otheres;

public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    System.out.println(rob(nums));
  }

  public static int rob(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = -1;
    }
    return backtrac(nums, nums.length - 1, dp);
  }

  public static int backtrac(int[] nums, int index, int[] dp) {
    if (index == 0) {
      return nums[index];
    }
    if (index < 0) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    int left = nums[index] + backtrac(nums, index - 2, dp);
    int right = 0 + backtrac(nums, index - 1, dp);
    return dp[index] = Math.max(left, right);
  }
}
