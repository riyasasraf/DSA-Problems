package Strings;

import java.util.Arrays;

public class SpiralMatrixII {

  public static void main(String[] args) {
    for (int[] arr : generateMatrix(5)) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public static int[][] generateMatrix(int n) {
    int[][] arr = new int[n][n];

    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = n - 1;

    int num = 0;
    while (top <= bottom && left <= right) {
      for (int i = left; i <= right; i++) {
        arr[top][i] = num += 1;
      }
      top++;
      for (int i = top; i <= bottom; i++) {
        arr[i][right] = num += 1;
      }
      right--;
      if (left <= right && top <= bottom) {
        for (int i = right; i >= left; i--) {
          arr[bottom][i] = num += 1;
        }
        bottom--;
        for (int i = bottom; i >= top; i--) {
          arr[i][left] = num += 1;
        }
        left++;
      }
    }
    return arr;
  }
}
