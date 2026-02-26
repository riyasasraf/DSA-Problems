import java.util.Arrays;

public class eraseOverlapIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

    int count = 1;
    int free = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= free) {
        count++;
        free = intervals[i][1];
      }
    }
    return intervals.length - count;
  }

  public boolean haveConflict(String[] event1, String[] event2) {

    return event1[0].compareTo(event2[1]) <= 0 && event2[1].compareTo(event1[1]) <= 0;

  }
}
