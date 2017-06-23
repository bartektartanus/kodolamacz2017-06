package sages.bootcamp.solid.isp;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    List<Client> clients = new ArrayList<Client>();
    clients.add(new Client());

    clients.forEach(client -> System.out.println(client.getAddressFromDb()));
  }
}

interface Persistable {
  String getAddressFromDb();
  // String getGps();
}

class Client implements Persistable{

  @Override
  public String getAddressFromDb() {
    return null;
  }
}
