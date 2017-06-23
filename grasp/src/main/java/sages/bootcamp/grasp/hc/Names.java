package sages.bootcamp.grasp.hc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Names {

  public String join(String namesFile) throws IOException {
    StringBuilder namesBuilder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(namesFile))) {
      String name;
      if ((name = reader.readLine()) != null) {
        namesBuilder.append(name);
        while ((name = reader.readLine()) != null) {
          namesBuilder.append(":").append(name);
        }
      }
    }

    return namesBuilder.toString();
  }

}
