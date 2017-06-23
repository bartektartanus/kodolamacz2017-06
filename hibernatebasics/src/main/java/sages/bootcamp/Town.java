package sages.bootcamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final int id;

  private final String name;
  private final int inhabitantsCount;

  public Town(int id, String name, int inhabitantsCount) {
    this.id = id;
    this.name = name;
    this.inhabitantsCount = inhabitantsCount;
  }

  @Override
  public String toString() {
    return "Town{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", inhabitantsCount=" + inhabitantsCount +
        '}';
  }
}
