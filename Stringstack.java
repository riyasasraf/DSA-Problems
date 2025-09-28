// You are given two strings pat and tar consisting of lowercase English characters. You can construct a new string s by performing any one of the following operation for each character in pat:

// Append the character pat[i] to the string s.
// Delete the last character of s (if s is empty do nothing).
// After performing operations on every character of pat exactly once, your goal is to determine if it is possible to make the string s equal to string tar.

import java.util.Stack;


public class Stringstack {

  public static void main(String[] args) {
    String pat = "geuaek", tar = "geek";
    System.out.println(stringStack(pat, tar));
  }
  public static boolean stringStack(String pat, String tar) {
    Stack<Character> word = new Stack<Character>();
    int i = 0;
    for (char ch : pat.toCharArray()) {
      word.push(ch);
      while (!word.isEmpty() && i < tar.length() && word.peek() == tar.charAt(i)) {
        word.pop();
        i++;
      }
    }
       
    StringBuilder sb = new StringBuilder();
    for (char ch : word)
      sb.append(ch);

    return i == tar.length();

  }
}
