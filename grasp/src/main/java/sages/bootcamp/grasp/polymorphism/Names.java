package sages.bootcamp.grasp.polymorphism;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Names {

  private final NamesReader namesReader;

  Names(NamesReader namesReader) {
    List<String> list = new ArrayList<>();
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
