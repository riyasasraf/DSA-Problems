package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTwoElement {
    public static void main(String[] args) {

        int[] arr = { 4, 3, 6, 2, 1, 1 };
        System.out.println(findTwoElement(arr).toString());

    }

    static ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int n = arr.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }
        System.out.println(
                xor);
        return ans;
    }
}
