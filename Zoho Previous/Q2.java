
public class Q2 {
  public static void main(String[] args) {
    characterProcessor("ecighdus");
  }

  static void characterProcessor(String s) {

    if (s.isEmpty()) {
      System.out.println(s.toString());
      return;
    }
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (ch == 's') {
        if (!sb.isEmpty()) {
          sb.reverse();
        }
      } else if (ch == 'd') {
        if (!sb.isEmpty()) {
          sb.deleteCharAt(sb.length() - 1);
        }
      } else if (ch == 'u') {
        if (!sb.isEmpty()) {
          char uc = sb.charAt(sb.length() - 1);
          sb.append(Character.toUpperCase(uc));
        }
      } else {
        sb.append(ch);
      }
      i++;

    }

    System.out.println(sb.toString());
  }
}
