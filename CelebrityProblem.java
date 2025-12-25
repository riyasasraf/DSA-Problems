public class CelebrityProblem {

  public static void main(String[] args) {
    int mat[][] = { { 1, 1, 0 },
        { 0, 1, 0 },
        { 0, 1, 1 } };
    System.out.println(celebrity(mat));
  }

  public static int celebrity(int mat[][]) {

    int top = 0;
    int down = mat.length - 1;

    while (top < down) {
      if (mat[top][down] == 1) {
        top++;
      } else {

        down--;
      }
    }

    int check = top;

    for (int i = 0; i < mat.length; i++) {
      if (check != i) {
        if (mat[check][i] == 1) {
          return -1;
        }
        if (mat[i][check] == 0) {
          return -1;
        }
      }
    }
    return top;

  }
}
