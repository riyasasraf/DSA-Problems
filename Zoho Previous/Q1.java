public class Q1 {

  public static void main(String[] args) {
    squareRead("finalchaltersntm");
  }

  public static void squareRead(String s) {
    int n = s.length();
    int sqrt = (int) Math.sqrt(n);
    if (sqrt * sqrt != n) {
      System.out.println("-1");
      return;
    }
    char[][] arr = new char[sqrt][sqrt];
    int k = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (k < n)
          arr[i][j] = s.charAt(k++);
      }
    }
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        sb.append(arr[j][i]);
      }
    }
    System.out.println(sb.toString());
  }
}