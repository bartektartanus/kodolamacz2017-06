package sages.bootcamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final int id;

  private final String login;
  private final int age;

  @ManyToMany
  private final List<Notebook> notebook;

  @OneToOne
  private final Town town;

  public User(int id, String login, int age, List<Notebook> notebook, Town town) {
    this.id = id;
    this.login = login;
    this.age = age;
    this.notebook = notebook;
    this.town = town;
  }

  public int getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public int getAge() {
    return age;
  }

  public List<Notebook> getNotebook() {
    return notebook;
  }

  public Town getTown() {
    return town;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", age=" + age +
        ", notebook=" + notebook +
        ", town=" + town +
        '}';
  }

  public void addNotebook(Notebook notebook) {
    this.notebook.add(notebook);
  }
}
