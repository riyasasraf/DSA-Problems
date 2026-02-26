package Strings;

public class HappyNumber {

  public static void main(String[] args) {
    System.out.println(isHappy(2));
  }

  public static boolean isHappy(int n) {

    int fast, slow;
    fast = slow = n;
    do {
      slow = backtrack(slow);
      fast = backtrack(backtrack(fast));
    } while (fast != slow);

    return (slow == 1);

  }

  public static int backtrack(int n) {
    int temp = n;
    int sum = 0;
    while (temp != 0) {
      int digit = temp % 10;
      sum = sum + (digit * digit);
      temp = temp / 10;
    }
    return sum;
  }
}
