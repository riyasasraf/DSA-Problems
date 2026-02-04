package Util;

import java.util.UUID;

public class idGenerator {

  public idGenerator() {
  }

  public static String generateId(String prefix) {
    return prefix + "-" + UUID.randomUUID().toString();
  }
}
