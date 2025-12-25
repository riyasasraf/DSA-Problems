import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutationsofanarray {
  
  public static void main(String[] args) {
  
    int[] arr = { 1, 3, 3 };
    System.out.println(uniquePerms(arr));

  }

     public static Set<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

        for (int i = 0; i < arr.length - 1; i++) {
          ArrayList<Integer> ans = new ArrayList<>();
          ans.add(arr[i]);
          for (int j = i + 1; j < arr.length; j++) {
            ans.add(arr[j]);
          }
          result.add(ans);
        }
        return result;

    }
}
