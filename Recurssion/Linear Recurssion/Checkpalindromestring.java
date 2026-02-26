public class Checkpalindromestring {
  public static void main(String[] args) {

    char[] s = { 'm', 'a', 'a' };
    System.out.println(isPallindrome(s, 0));
  }

  static boolean isPallindrome(char[] arr, int i) {
    if (i > arr.length / 2) {
      return true;
    }
    if (arr[i] != arr[arr.length - i - 1]) {
      return false;
    }
    return isPallindrome(arr, i + 1);
  }

}
