package Controller;

import Model.buyer;
import Model.seller;
import Model.user;
import Model.userType;
import Repo.userRepository;
import Service.userService;
import View.buyerView;
import View.sellerView;

public class authController {

  private user currentUser;
  userService service = new userService(userRepository.getInstatnce());

  public boolean auth(String email, String password, String name, userType userType) {
    return service.register(email, password, name, userType);
  }

  public void login(String email, String password) {

    currentUser = service.login(email, password);
    if (currentUser == null) {
      System.out.println("login Failed Invalid Credentials");
      return;
    }
    if (currentUser instanceof buyer) {

      new buyerView().start();
    } else if (currentUser instanceof seller) {
      new sellerView().start();
    } else {
      System.out.println("Unknown UserType");
    }
    System.out.println("login Successful");
  }
}
