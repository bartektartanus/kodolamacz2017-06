package sages.bootcamp.grasp.lc;

import java.util.List;

public class Names {
  FileNamesReader namesReader = new FileNamesReader();

  String join() {
    List<String> names = namesReader.readNames();
    return String.join(":", names);
  }
}
