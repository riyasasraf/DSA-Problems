package Model;

public class seller extends user {

  public seller(String name, String email, String password) {
    super(name, email, userType.SELLER, password);
  }

}
