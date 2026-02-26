package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

  public static void main(String[] args) {

    int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
    merge(arr);
  }

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> ans = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= end) {
        if (intervals[i][1] > end) {
          end = intervals[i][1];
        }
      } else {
        ans.add(new int[] { start, end });
        start = intervals[i][0];
        end = intervals[i][1];
      }
    }
    ans.add(new int[] { start, end });

    for (int[] is : ans) {
      System.out.println(Arrays.toString(is));
    }

    return ans.toArray(new int[ans.size()][]);
  }
}
