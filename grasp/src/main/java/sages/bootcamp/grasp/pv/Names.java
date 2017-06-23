package sages.bootcamp.grasp.pv;

import java.util.List;

public class Names {

  FileNamesReader namesReader;

  public Names(FileNamesReader namesReader) {
    this.namesReader = namesReader;
  }

  String join() {
    List<String> names = namesReader.readNames();
    return String.join(":", names);
  }
}
