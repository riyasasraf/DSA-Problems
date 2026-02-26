package Otheres;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Sortit {

  public static void main(String[] args) {

    int arr[] = { 0, 4, 5, 3, 7, 2, 1 };

    sortIt(arr);
    System.out.println(Arrays.toString(arr));

  }

  public static void sortIt(int[] arr) {
    // Step 1: Sort entire array
    Arrays.sort(arr);

    // Step 2: Reverse only the odd part
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      // move left to first odd
      while (left < arr.length && arr[left] % 2 == 0)
        left++;
      // move right to last odd
      while (right >= 0 && arr[right] % 2 == 0)
        right--;

      if (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }
    }

  }

}
