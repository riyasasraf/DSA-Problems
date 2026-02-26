package Recurssion.JP;

public class Factorial {

  public static void main(String[] args) {
    // System.out.println(fact(5));
    // System.out.println(sumofDigits(5));

    // String s = "riyas";
    // char[] arr = s.toCharArray();
    // reverseaString(0, arr);
    // System.out.println(Arrays.toString(arr));
    // System.out.println(pow(2, 3));

    System.out.println(isPalindrome("madam", 0));
  }

  static int fact(int i) {
    if (i == 0) {
      return 1;
    }

    return i * fact(i - 1);
  }

  static int pow(int base, int pow) {
    if (pow == 0) {
      return 1;
    }
    return base * pow(base, pow - 1);

  }

  static int sumofDigits(int i) {

    if (i == 0) {
      return 0;
    }
    return i + sumofDigits(i - 1);

  }

  static void reverseaString(int i, char[] arr) {

    if (i >= arr.length / 2) {
      return;
    }
    char temp = arr[i];
    arr[i] = arr[(arr.length - 1) - i];
    arr[(arr.length - 1) - i] = temp;
    reverseaString(i + 1, arr);
  }

  static boolean isPalindrome(String s, int i) {

    if (i == s.length()) {
      return true;
    }
    if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
      return false;
    }

    return isPalindrome(s, i + 1);

  }

}