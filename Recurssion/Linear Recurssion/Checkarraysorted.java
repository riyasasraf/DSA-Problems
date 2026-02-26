public class Checkarraysorted {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6 };
    int[] arr2 = { 1, 2, 4, 3, 6, 5 };

    System.out.println(isSorted(arr2, 0));
    System.out.println(isSorted(arr, 0));

  }

  static boolean isSorted(int[] arr, int i) {
    if (i >= arr.length - 1) {
      return true;
    }
    if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isSorted(arr, i + 1);
  }

}
