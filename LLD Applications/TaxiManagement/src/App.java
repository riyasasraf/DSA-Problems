import Model.Customer;
import Service.BookingService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Customer c = new Customer('A', 'B', 9);
        Customer c2 = new Customer('B', 'C', 9);
        Customer c3 = new Customer('C', 'A', 9);
        Customer c4 = new Customer('A', 'D', 9);

        BookingService bookingsystem = new BookingService(4);

        bookingsystem.bookTaxi(c4);
        bookingsystem.bookTaxi(c);
        bookingsystem.bookTaxi(c3);
        bookingsystem.bookTaxi(c2);

    }
}
