package Greedy.FractionalKnapscak;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

  class data {
    int val;
    int wt;

    public data(int val, int wt) {
      this.val = val;
      this.wt = wt;
    }

    public data() {
    }
  }

  public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
    // code here

    data arr[] = new data[val.length];

    Comparator<data> comp = (a, b) -> {
      double r1 = (double) a.val / a.wt;
      double r2 = (double) b.val / b.wt;
      return Double.compare(r2, r1);

    };
    for (int i = 0; i < arr.length; i++) {

      arr[i] = new data(val[i], wt[i]);

    }
    Arrays.sort(arr, comp);

    Double total = 0.0;
    for (int j = 0; j < arr.length; j++) {

      if (capacity > arr[j].wt) {
        total += arr[j].val;
        capacity -= arr[j].wt;
      } else {
        Double fracval = (double) (arr[j].val / arr[j].wt) * capacity;
        break;
      }
    }
    return total;

  }

}
