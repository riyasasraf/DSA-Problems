package Otheres;

public class ReverseInt {

  public static void main(String[] args) {
    System.out.println(rev("-1200"));
  }

  public static String rev(String s) {
    boolean negetive = Integer.parseInt(s) < 0;

    char[] arr = s.toCharArray();
    int left = 0, right = arr.length - 1;

    if (negetive) {
      left = 1;
    }

    while (left < right) {
      char tmp = arr[left];
      arr[left] = arr[right];
      arr[right] = tmp;
      left++;
      right--;
    }
    // String ans = new String(arr);
    return new String(arr);
  }

}
