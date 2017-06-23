package sages.bootcamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final int id;

  private final String login;
  private final int age;

  @OneToOne
  private final Notebook notebook;

  public User(int id, String login, int age, Notebook notebook) {
    this.id = id;
    this.login = login;
    this.age = age;
    this.notebook = notebook;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", age=" + age +
        ", notebook=" + notebook +
        '}';
  }
}
