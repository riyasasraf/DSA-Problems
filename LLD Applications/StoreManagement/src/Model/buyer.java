package Model;

public class buyer extends user {

  public buyer(String name, String email, String password) {
    super(name, email, userType.BUYER, password);
  }

}
