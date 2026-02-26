package Recurssion;

import java.util.ArrayList;
// Given a string s that contains only digits (0-9) and an integer target, return all possible strings by inserting the binary operator ' + ', ' - ', and/or ' * ' between the digits of s such that the resultant expression evaluates to the target value.

// Note:

// Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine.
// It is allowed to not insert any of the operators.
// Driver code will print the final list of strings in lexicographically smallest order.
// Examples:

// Input: s = "124", target = 9
// Output: ["1+2*4"]
// Explanation: The valid expression that evaluate to 9 is 1 + 2 * 4
// Input: s = "125", target = 7
// Output: ["1*2+5", "12-5"]
// Explanation: The two valid expressions that evaluate to 7 are 1 * 2 + 5 and 12 - 5.
// Input: s = "12", target = 12
// Output: ["12"] 
// Explanation: s itself matches the target. No other expressions are possible.
// Input: s = "987612", target = 200
// Output: []
// Explanation: There are no expressions that can be created from "987612" to evaluate to 200.

//solution

// Use backtracking to explore all possible ways of inserting +, -, or * between digits.

// Keep track of:

// total: evaluated value so far.

// last: the last number added/subtracted (important for handling multiplication precedence).

// expr: current expression being built.

// Special cases:

// First number → no operator.

// Skip numbers with leading zeros.
public class ExpressionAddOperators {

  public ArrayList<String> findExpr(String s, int target) {
    // code here
    ArrayList<String> result = new ArrayList<String>();
    tryExp(s, target, result, 0, 0, 0, new StringBuilder());
    return result;
  }

  public static void tryExp(String s, int target, ArrayList<String> result, int index, int total, int last,
      StringBuilder expr) {

    if (index == s.length()) {
      if (total == target) {
        result.add(expr.toString());
      }
      return;
    }

    for (int i = index; i < s.length(); i++) {
      if (i > index && s.charAt(index) == '0')
        break;
      String numString = s.substring(index, i + 1);
      int num = Integer.parseInt(numString);
      int len = expr.length();
      if (index == 0) {
        expr.append(numString);
        tryExp(s, target, result, i + 1, num, num, expr);
        expr.setLength(len);
      } else {
        expr.append('+').append(numString);
        tryExp(s, target, result, i + 1, total + num, num, expr);
        expr.setLength(len);
        expr.append('-').append(numString);
        tryExp(s, target, result, i + 1, total - num, -num, expr);
        expr.setLength(len);
        expr.append('*').append(numString);
        tryExp(s, target, result, i + 1, total - last + last * num, last * num, expr);
        expr.setLength(len);
      }
    }

  }
}