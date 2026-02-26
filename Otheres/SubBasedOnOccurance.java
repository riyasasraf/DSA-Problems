package Otheres;

import java.util.HashMap;
import java.util.Map;

public class SubBasedOnOccurance {

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 3, 4 };
    sum(arr);
  }

  public static void sum(int[] arr) {

    Map<Integer, Integer> mpp = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
    }
    Map<Integer, Integer> sum = new HashMap<>();

    for (Map.Entry<Integer, Integer> i : mpp.entrySet()) {

      int freq = i.getValue();
      int val = i.getKey();
      int cal = freq * val;
      sum.put(freq, sum.getOrDefault(freq, 0) + cal);
    }

    System.out.println(sum.toString());

  }

}
