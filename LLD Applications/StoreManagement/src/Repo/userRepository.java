package Repo;

import java.util.HashMap;
import java.util.Map;

import Model.user;

public class userRepository {

  private static userRepository instance;

  private Map<String, user> userMap;

  private userRepository() {
    userMap = new HashMap<>();
  }

  public static userRepository getInstatnce() {

    if (instance == null) {
      instance = new userRepository();
    }
    return instance;
  }

  public boolean save(user user) {
    if (user == null) {

      throw new IllegalArgumentException("can save null");
    }
    if (userMap.containsKey(user.getEmail())) {
      return false;
    }
    return userMap.putIfAbsent(user.getEmail(), user) == null;
  }

  public boolean exsistsByemail(String email) {
    return userMap.containsKey(email);
  }

  public user geUserByEmail(String email) {
    return userMap.get(email);
  }
}
