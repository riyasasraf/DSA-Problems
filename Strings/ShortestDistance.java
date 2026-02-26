package Strings;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistance {

  public static void main(String[] args) {
    ArrayList<String> s = new ArrayList<>();
    s.add("the");
    s.add("quick");
    s.add("brown");
    s.add("fox");
    s.add("quick");

    String word1 = "the";
    String word2 = "fox";
    System.out.println(shortestDistance(s, word1, word2));
  }

  static int shortestDistance(ArrayList<String> s, String word1, String word2) {

    // code here
    int size = 0;
    int i = 0;
    boolean count = false;
    while (i < s.size()) {
      String cur = s.get(i);
      if (cur.equals(word1)) {
        count = true;
        size = 0;
      }

      else if (count) {
        size++;
        if (cur.equals(word2)) {
          break;
        }
      }
      i++;
    }
    return size;
  }
}
