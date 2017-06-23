package sages.bootcamp.grasp.polymorphism;

import java.util.List;

public class Names {

  private final NamesReader namesReader;

  Names(NamesReader namesReader) {
    this.namesReader = namesReader;
  }

  String join() {
    if (namesReader instanceof DatabaseNamesReader) {
      // open database connection
    }
    List<String> names = namesReader.readNames();
    return String.join(":", names);
  }
}
