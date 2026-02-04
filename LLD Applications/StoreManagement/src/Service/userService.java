package Service;

import Model.buyer;
import Model.seller;
import Model.user;
import Model.userType;
import Repo.userRepository;

public class userService {

  private final userRepository repo;

  public userService(userRepository repository) {
    this.repo = repository;
  }

  public user login(String email, String password) {

    user user = repo.geUserByEmail(email);
    if (user == null) {

      System.out.println("user not found");
      return null;
    }
    if (!user.getPassword().equals(password)) {
      System.out.println("Incorrect Password");
      return null;
    }
    return user;
  }

  public boolean register(String email, String password, String name, userType type) {
    if (name == null || email == null || password == null || type == null) {

      System.out.println("canot Register User data Missing");
      return false;
    }
    user u;
    switch (type) {
      case BUYER -> u = new buyer(name, email, password);
      case SELLER -> u = new seller(name, email, password);
      default -> throw new IllegalArgumentException("Invalid type");
    }
    return repo.save(u);
  }
}
