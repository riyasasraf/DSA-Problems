package Util;

import java.util.Scanner;

public class inputHandeller {

  private static inputHandeller instance;
  private final Scanner scanner;

  public inputHandeller() {
    scanner = new Scanner(System.in);
  }

  public static inputHandeller getInstance() {
    if (instance == null)
      instance = new inputHandeller();
    return instance;
  }

  public String readString(String prompt) {
    System.out.println(prompt + ": ");
    return scanner.nextLine().trim();
  }

  public Integer readInt(String prompt) {

    while (true) {
      System.out.println(prompt + ": ");
      String input = scanner.nextLine();

      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.err.println("Invalid Nuber please try again");
      }
    }
  }

  public String readEmail(String prompt) {
    while (true) {
      System.out.println(prompt + ": ");
      String input = scanner.nextLine();
      if (input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
        return input;

      System.out.println("please enter the valid email");
    }
  }
}
