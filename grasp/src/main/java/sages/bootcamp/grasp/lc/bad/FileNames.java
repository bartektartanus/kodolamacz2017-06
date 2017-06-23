package sages.bootcamp.grasp.lc.bad;

import java.util.List;

public class FileNames {
  FileNamesReader namesReader = new FileNamesReader();

  String join() {
    List<String> names = namesReader.readNames();
    return String.join(":", names);
  }
}
