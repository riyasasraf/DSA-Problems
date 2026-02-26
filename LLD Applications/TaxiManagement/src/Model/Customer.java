package Model;

public class Customer {

  private static int idCounter = 0;
  private int id;
  private char pickPoint;
  private char dropPoint;
  private int pickTime;

  public Customer(char pickPoint, char dropPoint, int pickTime) {
    this.id = ++idCounter;
    this.pickPoint = pickPoint;
    this.dropPoint = dropPoint;
    this.pickTime = pickTime;
  }

  public char getPickPoint() {
    return pickPoint;
  }

  public void setPickPoint(char pickPoint) {
    this.pickPoint = pickPoint;
  }

  public char getDropPoint() {
    return dropPoint;
  }

  public void setDropPoint(char dropPoint) {
    this.dropPoint = dropPoint;
  }

  public int getPickTime() {
    return pickTime;
  }

  public void setPickTime(char pickTime) {
    this.pickTime = pickTime;
  }

}