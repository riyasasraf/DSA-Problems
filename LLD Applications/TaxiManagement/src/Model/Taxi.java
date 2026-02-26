package Model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

  private static int idCounter = 0;
  private int id;
  private List<Booking> bookings;
  private char currPoint;
  private int earning;
  private int freeTime;

  public Taxi() {
    this.id = ++idCounter;
    this.bookings = new ArrayList<>();
    this.currPoint = 'A';
    this.earning = 0;
    this.freeTime = 0;
  }

  public boolean isFree(char pickPoint, int pickTime) {
    int distance = Math.abs(currPoint - pickPoint);
    return (freeTime + distance) < pickTime;
  }

  public int getId() {
    return id;
  }

  public void assignBooking(Booking b) {
    bookings.add(b);
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  public char getCurrPoint() {
    return currPoint;
  }

  public int getEarning() {
    return earning;
  }

  public int getFreeTime() {
    return freeTime;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  public void setCurrPoint(char currPoint) {
    this.currPoint = currPoint;
  }

  public void setEarning(int earning) {
    this.earning = earning;
  }

  public void setFreeTime(int freeTime) {
    this.freeTime = freeTime;
  }

}
