package sages.bootcamp.grasp.lc.good;

import java.util.List;

public class Names {
  NamesReader namesReader;

  public Names(NamesReader namesReader) {
    this.namesReader = namesReader;
  }

  String join() {
    List<String> names = namesReader.readNames();
    return String.join(":", names);
  }
}
