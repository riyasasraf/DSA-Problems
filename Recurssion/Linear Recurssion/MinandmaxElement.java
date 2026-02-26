public class MinandmaxElement {

  public static void main(String[] args) {
    int[] arr = { 2, 0, 4, 5, 3, 100, 23, -10 };
    System.out.println(min(arr, 0, Integer.MAX_VALUE));
  }

  static int min(int[] arr, int i, int min) {
    if (i == arr.length) {
      return min;
    }
    if (arr[i] < min) {
      min = arr[i];
    }
    return min(arr, i + 1, min);
  }

}
