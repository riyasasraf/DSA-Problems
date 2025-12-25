public class Exam {
  public static void main(String[] args) {
    // Java Code (e.g., in ProductsApplication.java)
    System.out.println("JVM Default TimeZone: " + System.getProperty("user.timezone"));
    System.out.println("System Default TimeZone: " + java.util.TimeZone.getDefault().getID());
  }
}
