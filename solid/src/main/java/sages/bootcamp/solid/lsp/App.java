package sages.bootcamp.solid.lsp;


import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Client> clients = new ArrayList<Client>();
    clients.add(new Client());
    clients.add(new Equiry());

    clients.forEach(client -> System.out.println(client.getDiscount(1000)));

    clients.forEach(client -> System.out.println(client.getAddressFromDb()));
  }
}

class Client {
  public double getDiscount(double totalAmount) {
    return totalAmount - 50;
  }

  public String getAddressFromDb() {
    return "some-address";
  }
}

class Equiry extends Client {

  @Override
  public double getDiscount(double totalAmount) {
    return totalAmount - 100;
  }

  @Override
  public String getAddressFromDb() {
    throw new UnsupportedOperationException();
  }
}
