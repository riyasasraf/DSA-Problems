package View;

import Controller.authController;
import Model.userType;
import Util.inputHandeller;

public class view {

  inputHandeller sc = inputHandeller.getInstance();
  authController auth = new authController();

  public void start() {
    while (true) {
      System.out.println("1.Register\n 2.Login\n 3.exit");
      int choice = sc.readInt("Enter Choice");
      switch (choice) {
        case 1:
          handleRegister();
          break;
        case 2:
          handleLogin();
          break;
        case 3:
          System.exit(0);
      }
    }
  }

  private void handleLogin() {
    String mail = sc.readEmail("enter mail");
    String pwd = sc.readString("Enter Pewd");
    auth.login(mail, pwd);

  }

  private void handleRegister() {
    String name = sc.readString("Enter Name");
    String password = sc.readString("Enter Pwd");
    String email = sc.readEmail("Enter email");
    int type = sc.readInt("Enter Usertype(1. BUYER or 2.SELLER)");
    userType typeStr;
    if (type == 1) {
      typeStr = userType.BUYER;
    } else {
      typeStr = userType.SELLER;
    }
    if (auth.auth(email, password, name, typeStr)) {
      System.out.println("Register successfully");
    } else {
      System.out.println("Invlaid");
    }
  }
}
