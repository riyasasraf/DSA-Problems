package Model;

public class Booking {

  private static int idCounter = 0;
  private int id;
  private int dropTime;
  private int fare;
  private Customer customer;

  public Booking(int dropTime, int fare, Customer customer) {
    this.id = ++idCounter;
    this.dropTime = dropTime;
    this.fare = fare;
    this.customer = customer;
  }

  public int getDropTime() {
    return dropTime;
  }

  public int getFare() {
    return fare;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setDropTime(int dropTime) {
    this.dropTime = dropTime;
  }

  public void setFare(int fare) {
    this.fare = fare;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

}
