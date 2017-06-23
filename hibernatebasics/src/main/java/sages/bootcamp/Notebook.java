package sages.bootcamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "notebooks")
public class Notebook {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final int id;

  private final String model;
  private final int resolution;
  private final Instant productionTimestamp;

  public Notebook(int id, String model, int resolution, Instant productionTimestamp) {
    this.id = id;
    this.model = model;
    this.resolution = resolution;
    this.productionTimestamp = productionTimestamp;
  }
}
