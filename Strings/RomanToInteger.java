package Strings;

import java.util.HashMap;

public class RomanToInteger {
  public static void main(String[] args) {
    System.out.println(romanToDecimal("MCMIV"));
  }

  public static int romanToDecimal(String s) {
    // code here
    HashMap<Character, Integer> mpp = new HashMap<>();
    mpp.put('I', 1);
    mpp.put('V', 5);
    mpp.put('X', 10);
    mpp.put('L', 50);
    mpp.put('C', 100);
    mpp.put('D', 500);
    mpp.put('M', 1000);

    int ans = 0;

    int n = s.length();
    int prev = 0;
    for (int i = n - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      int val = mpp.get(ch);

      if (val >= prev) {
        ans += val;
        prev = val;
      } else {
        ans -= val;
        prev = val;
      }
    }
    return ans;

  }
}