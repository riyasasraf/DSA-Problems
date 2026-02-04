package Model;

import Util.idGenerator;

public class user {
  private String id;
  private String name;
  private String email;
  private userType type;
  private String password;

  public user(String name, String email, userType type, String password) {
    this.id = idGenerator.generateId(type.toString());
    this.name = name;
    this.email = email;
    this.type = type;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public userType getType() {
    return type;
  }

  public void setType(userType type) {
    this.type = type;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "user [id=" + id + ", name=" + name + ", email=" + email + ", type=" + type + "]";
  }

}
