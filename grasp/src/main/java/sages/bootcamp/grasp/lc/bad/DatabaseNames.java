package sages.bootcamp.grasp.lc.bad;

import java.util.List;

public class DatabaseNames {
  DatabaseNamesReader namesReader = new DatabaseNamesReader();

  String join() {
    List<String> names = namesReader.readNames();
    return String.join(":", names);
  }
}
