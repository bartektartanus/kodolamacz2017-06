package sages.bootcamp.grasp.hc.good;

import java.io.IOException;
import java.util.List;

public class Names {

  private final NamesJoiner namesJoiner;
  private final NamesReader namesReader;

  public Names(NamesJoiner namesJoiner, NamesReader namesReader) {
    this.namesJoiner = namesJoiner;
    this.namesReader = namesReader;
  }

  public String join(String namesFile) throws IOException {
    List<String> names = namesReader.readNames();
    return namesJoiner.join(names);
  }

}

