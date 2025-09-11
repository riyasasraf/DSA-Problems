
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// Example 3:

// Input: intervals = [[4,7],[1,4]]
// Output: [[1,7]]
// Explanation: Intervals [1,4] and [4,7] are considered overlapping.

//Solution

// Sort intervals by start time.

// Keep track of a current [start, end] interval.

// For each next interval:

// If it overlaps (start ≤ current end) → merge by extending end.

// If it doesn’t overlap → add the current interval to the result and reset [start, end].

// Add the last interval at the end.



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public int[][] merge(int[][] arr) {
    List<int[]> ans = new ArrayList<>();
    Arrays.sort((arr), (a, b) -> Integer.compare(a[0], b[0]));
    int start = arr[0][0];
    int end = arr[0][1];

    for (int i = 1; i < arr.length; i++) {

      if (arr[i][0] <= end) {
        end = Math.max(end, arr[i][1]);
      } else {
        ans.add(new int[] { start, end });
        start = arr[i][0];
        end = arr[i][1];
      }

    }
    ans.add(new int[] { start, end });

    return ans.toArray(new int[ans.size()][]);

  }
}
