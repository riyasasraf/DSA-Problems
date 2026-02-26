package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Booking;
import Model.Customer;
import Model.Taxi;

public class BookingService {

  List<Taxi> taxis;

  public BookingService(int TaxisCount) {
    taxis = new ArrayList<>();

    for (int i = 0; i < TaxisCount; i++) {
      taxis.add(new Taxi());
    }
  }

  private int calculateCharges(char pickPoint, char dropPoint) {
    int charge = 100;
    int distance = Math.abs(pickPoint - dropPoint) * 15;
    distance -= 5;
    charge += distance * 10;
    return charge;
  }

  Taxi findTaxi(char pickPoint, int pickTime) {
    List<Taxi> freetaxies = new ArrayList<>();
    int minDistance = Integer.MAX_VALUE;

    for (Taxi taxi : taxis) {
      if (taxi.isFree(pickPoint, pickTime)) {
        freetaxies.add(taxi);
        int distance = Math.abs(taxi.getCurrPoint() - pickPoint);
        minDistance = Math.min(distance, minDistance);
      }
    }

    if (freetaxies.isEmpty()) {
      return null;
    }

    List<Taxi> closeTaxi = new ArrayList<>();
    for (Taxi taxi : freetaxies) {
      int distance = Math.abs(taxi.getCurrPoint() - pickPoint);
      if (distance == minDistance) {
        closeTaxi.add(taxi);
      }
    }

    Taxi selected = closeTaxi.get(0);
    for (Taxi taxi : closeTaxi) {
      if (selected.getEarning() > taxi.getEarning()) {
        selected = taxi;
      }
    }
    return selected;
  }

  public void bookTaxi(Customer c) {
    Taxi selected = findTaxi(c.getPickPoint(), c.getPickTime());
    if (selected == null) {
      System.out.println("No taxi aval");
      return;
    }
    int dp = Math.abs(c.getPickPoint() - c.getDropPoint());
    int charges = calculateCharges(c.getPickPoint(), c.getDropPoint());
    Booking booking = new Booking(dp, charges, c);
    selected.assignBooking(booking);
    selected.setCurrPoint(c.getDropPoint());
    selected.setFreeTime(dp);
    selected.setEarning(selected.getEarning() + charges);
    System.out.println("taxi" + selected.getId() + "is booked");
  }

}
