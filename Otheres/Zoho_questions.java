package Otheres;

public class Zoho_questions {
  // Question 1

  // Remove all duplicate characters from the given string while preserving the
  // order.

  // Constraints:

  // Do not use any built-in functions.

  // Perform the operation using in-place memory (do not use an additional
  // variable to store the result).

  // For alphabets, keep only the first occurrence.

  // For digits, keep only the last occurrence.

  // Example:

  // Input: a1b2c34c3b2cb3a1d
  // Output: abc4231d
  public static void main(String[] args) {
    removeDuplicates("a1b2c34c3b2cb3a1d");
  }

  public static void removeDuplicates(String s) {
    int[] characters = new int[256];
    StringBuilder ss = new StringBuilder();
    for (char ch : s.toCharArray()) {
      if (characters[ch] >= 'a' && characters[ch] <= 'z') {
        ss.append(ch);
        characters[ch] += 1;
        continue;
      } else {
        ss.append(ch);

      }
    }
    System.out.println(ss.toString());

  }

}
