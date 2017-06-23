package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;

public class App {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    Notebook notebook = new Notebook(0, "Samsung", 1300, Instant.now());
    entityManager.persist(notebook);
    System.out.println(notebook);

    User user = new User(0, "marcin.krol", 25, notebook);
    entityManager.persist(user);
    System.out.println(user);

    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
