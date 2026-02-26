import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nmeetingsinoneroom {
  // Function to find the maximum number of meetings that can
  // be performed in a meeting room.

  class data {
    int start;
    int end;
    int pos;

    public data(int start, int end, int pos) {
      this.start = start;
      this.end = end;
      this.pos = pos;
    }

    public data() {
    }

  }

  public int maxMeetings(int start[], int end[]) {

    data arr[] = new data[start.length];

    for (int i = 0; i < start.length; i++) {
      arr[i] = new data();
      arr[i].start = start[i];
      arr[i].end = end[i];
      arr[i].pos = i;
    }

    Arrays.sort(arr, (a, b) -> Integer.compare(a.end, b.end));

    int count = 1;
    int free = arr[0].end;
    List<Integer> ds = new ArrayList<>();

    for (int i = 1; i < arr.length; i++) {

      if (arr[i].start > free) {
        count += 1;
        free = arr[i].end;
        ds.add(arr[i].pos);
      }
    }
    return count;
  }
}
