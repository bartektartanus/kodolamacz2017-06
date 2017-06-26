package sages.bootcamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "notebooks")
public class Notebook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final int id;

  private final String model;
  private final int resolution;
  private final int sizeInInches;
  private final String colour;
  private final Instant productionTimestamp;

  public Notebook(String model, int resolution, int sizeInInches, String colour, Instant productionTimestamp) {
    this.id = 0;
    this.model = model;
    this.resolution = resolution;
    this.sizeInInches = sizeInInches;
    this.colour = colour;
    this.productionTimestamp = productionTimestamp;
  }

  public int getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public int getResolution() {
    return resolution;
  }

  public int getSizeInInches() {
    return sizeInInches;
  }

  public String getColour() {
    return colour;
  }

  public Instant getProductionTimestamp() {
    return productionTimestamp;
  }

  @Override
  public String toString() {
    return "Notebook{" +
        "id=" + id +
        ", model='" + model + '\'' +
        ", resolution=" + resolution +
        ", productionTimestamp=" + productionTimestamp +
        '}';
  }
}
