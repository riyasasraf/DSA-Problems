// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Stack;

// public class Main {

//   // NUM-PUZZLE VERIFIER (Level II - Low Level Design)
//   // Problem:

//   // Given a mapping of letters to digits, verify whether a given equation is true
//   // under that mapping. Write a program that takes input as the raw set of mapped
//   // strings and an equation and prints whether the given equation is valid. Note
//   // that each letter has a unique value, and the same value is not assigned to
//   // different characters.

//   // Input Format:

//   // List of key-value pairs (the mappings), as a single line.

//   // An equation to verify in another line.

//   // Output Format:

//   // Evaluation results (True or False).

//   // Constraints:
//   // 0≤ input mappings length ≤100

//   // Operations allowed: $'+', '-', '/', '\*', '>', '>=', '<', '<=', '=='$

//   // Length of inputs: Outputs should not be hard coded.

//   // Examples:
//   // Example 1:

//   // Input:
//   // Enter Mappings: ONE=203, TWO=812
//   // Enter the Equation to evaluate: ONE + ONE = TWO

//   // Output:
//   // False

//   // Explanation: ONE+ONE=203+203=406, which is not equal to 812=TWO.

//   // Example 2:

//   // Input:
//   // Enter Mappings: BASE = 7480, TO = 92, NO = 12, SE = 80
//   // Enter the Equation to evaluate: TO - NO >= SE

//   // Output:
//   // True

//   // Explanation: TO is 92, NO is 12, so 92−12=80. 80≥80.

//   public static void main(String[] args) {

//     String mappings[] = { "ONE=203, TWO=812", "BASE = 7480, TO = 92, NO = 12, SE = 80",
//         "BASE = 7480, TO = 92, NO = 12, SE = 80" };
//     String expressions[] = { "one+ONE=TWO", "TO - NO >= SE", "base-to-no+se=base" };

//     for (int i = 0; i < expressions.length; i++) {
//       System.out.println(numPuzVer(mappings[i], expressions[i]));
//     }

//   }

//   public static Boolean numPuzVer(String mapping, String expression) {
//     mapping = mapping.replaceAll(" ", "");
//     expression = expression.replaceAll(" ", "");

//     String[] mapSplit = mapping.split(",");

//     HashMap<String, Integer> mpp = new HashMap<String, Integer>();

//     for (String string : mapSplit) {
//       String arr[] = string.split("=");
//       for (int i = 0; i < arr[0].length(); i++) {
//         mpp.put(Character.toString(arr[0].charAt(i)).toUpperCase(),
//             Integer.parseInt(Character.toString(arr[1].charAt(i))));
//       }
//     }

//     System.out.println(mpp);

//     expression = expression.toUpperCase();
//     System.out.println(expression);

//     ArrayList<String> lhs = new ArrayList<String>();
//     StringBuilder rhs = new StringBuilder();
//     StringBuilder comparator = new StringBuilder();
//     Stack<Character> operator = new Stack<Character>();

//     int i = 0;
//     StringBuilder operand = new StringBuilder();
//     while (i < expression.length()
//         && (expression.charAt(i) != '<' && expression.charAt(i) != '>' && expression.charAt(i) != '=')) {

//       if (expression.charAt(i) >= 'A' && expression.charAt(i) <= 'Z') {
//         operand.append(expression.charAt(i));
//         i++;

//       } else if (expression.charAt(i) != '<' && expression.charAt(i) != '>' && expression.charAt(i) != '=') {
//         lhs.add(operand.toString());
//         operand = new StringBuilder();
//         operator.push(expression.charAt(i));
//         i++;
//       }
//     }
//     lhs.add(operand.toString());

//     while (i < expression.length()
//         && (expression.charAt(i) == '<' || expression.charAt(i) == '>' || expression.charAt(i) == '=')) {
//       comparator.append(expression.charAt(i));
//       i++;
//     }
//     while (i < expression.length()) {
//       rhs.append(expression.charAt(i));
//       i++;
//     }

//     System.out.println(lhs + " lhs");
//     System.out.println(rhs + " rhs");
//     System.out.println(comparator + " comarator");
//     System.out.println(operator + " operator");

//     int lhsCalc = 0;
//     for (String var : lhs) {
//       int val = 0;
//       for (int j = 0; j < var.length(); j++) {
//         val = (val * 10) + mpp.get(Character.toString(var.charAt(j)));
//       }
//       if (lhsCalc <= 0) {
//         lhsCalc += val;

//       } else {
//         Character op = operator.pop();
//         switch (op) {
//           case '+':
//             lhsCalc += val;
//             break;
//           case '-':
//             lhsCalc -= val;
//             break;
//           case '*':
//             lhsCalc *= val;
//             break;
//           case '/':
//             lhsCalc /= val;
//             break;
//           default:
//             break;
//         }
//       }
//     }

//     System.out.println(lhsCalc + "LHS");

//     int rhsCalc = 0;
//     for (int j = 0; j < rhs.length(); j++) {
//       rhsCalc = rhsCalc * 10 + mpp.get(Character.toString(rhs.charAt(j)));
//     }

//     System.out.println(rhsCalc + "RHS");

//     switch (comparator.toString()) {
//       case "=":
//         return lhsCalc == rhsCalc;
//       case "<":
//         return lhsCalc < rhsCalc;
//       case ">":
//         return lhsCalc > rhsCalc;
//       case "<=":
//         return lhsCalc <= rhsCalc;
//       case ">=":
//         return lhsCalc >= rhsCalc;
//       default:
//         break;
//     }
//     System.out.println("------------------");

//     return false;

//   }

// }

import java.util.*;

public class Main {

  public static void main(String[] args) {
    String[] mappings = {
        "ONE=203, TWO=812",
        "BASE=7480, TO=92, NO=12, SE=80"
    };

    String[] expressions = {
        "ONE + ONE = TWO",
        "TO - NO >= SE"
    };

    for (int i = 0; i < expressions.length; i++) {
      System.out.println(numPuzzleVerifier(mappings[i], expressions[i]));
    }
  }

  // Verifier function
  public static boolean numPuzzleVerifier(String mappingStr, String expression) {
    Map<Character, Integer> letterMap = parseMappings(mappingStr);

    String comparator = extractComparator(expression);
    String[] sides = expression.split("\\s*" + comparator + "\\s*");

    int lhsValue = evaluateExpression(sides[0].trim(), letterMap);
    int rhsValue = evaluateExpression(sides[1].trim(), letterMap);

    return compare(lhsValue, rhsValue, comparator);
  }

  // Parse mappings into letter → digit
  private static Map<Character, Integer> parseMappings(String mappingStr) {
    Map<Character, Integer> map = new HashMap<>();
    mappingStr = mappingStr.replaceAll("\\s+", "");
    String[] pairs = mappingStr.split(",");

    for (String pair : pairs) {
      String[] kv = pair.split("=");
      String word = kv[0].toUpperCase();
      String digits = kv[1];

      for (int i = 0; i < word.length(); i++) {
        map.put(word.charAt(i), digits.charAt(i) - '0');
      }
    }
    return map;
  }

  // Extract the comparator
  private static String extractComparator(String expression) {
    if (expression.contains(">="))
      return ">=";
    if (expression.contains("<="))
      return "<=";
    if (expression.contains("=="))
      return "==";
    if (expression.contains(">"))
      return ">";
    if (expression.contains("<"))
      return "<";
    if (expression.contains("="))
      return "=";
    throw new IllegalArgumentException("No valid comparator found.");
  }

  // Convert words into numbers based on letter mapping and evaluate arithmetic
  private static int evaluateExpression(String expr, Map<Character, Integer> letterMap) {
    expr = expr.toUpperCase().replaceAll("\\s+", "");
    StringTokenizer tokenizer = new StringTokenizer(expr, "+-*/", true);

    int result = 0;
    String operator = "+";

    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();

      if ("+-*/".contains(token)) {
        operator = token;
      } else {
        int value = wordToNumber(token, letterMap);

        switch (operator) {
          case "+":
            result += value;
            break;
          case "-":
            result -= value;
            break;
          case "*":
            result *= value;
            break;
          case "/":
            result /= value;
            break;
        }
      }
    }
    return result;
  }

  // Convert a word (e.g. "ONE") to its numeric value using the letter map
  private static int wordToNumber(String word, Map<Character, Integer> letterMap) {
    int num = 0;
    for (char c : word.toCharArray()) {
      if (!letterMap.containsKey(c)) {
        throw new IllegalArgumentException("No mapping for letter: " + c);
      }
      num = num * 10 + letterMap.get(c);
    }
    return num;
  }

  // Compare values
  private static boolean compare(int lhs, int rhs, String comparator) {
    return switch (comparator) {
      case "=", "==" -> lhs == rhs;
      case ">" -> lhs > rhs;
      case "<" -> lhs < rhs;
      case ">=" -> lhs >= rhs;
      case "<=" -> lhs <= rhs;
      default -> false;
    };
  }
}
