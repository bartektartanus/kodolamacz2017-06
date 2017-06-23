package sages.bootcamp.solid.ocp;

public class Client {
  private final String customerType;

  public Client(String customerType) {
    this.customerType = customerType;
  }

  public double getDiscount(double totalAmount) {
    if (customerType.equals("VIP")) {
      return totalAmount - 100;
    } else {
      return totalAmount - 50;
    }
  }
}
