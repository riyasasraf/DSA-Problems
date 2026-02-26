import java.util.Arrays;

public class Reverseastring {

  public static void main(String[] args) {
    String s = "riyas";
    // o/p : sayir
    char arr[] = s.toCharArray();
    reverseastring(arr, 0);
    System.out.println(Arrays.toString(arr));
  }

  static void reverseastring(char[] arr, int n) {
    if (n >= (arr.length / 2)) {
      return;
    }
    swap(arr, n);
    reverseastring(arr, n + 1);
    return;
  }

  static void swap(char[] arr, int n) {
    int size = arr.length;
    char temp = arr[n];
    arr[n] = arr[size - n - 1];
    arr[size - n - 1] = temp;
  }

}
