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

    User user = new User(0, "marcin.krol", 25);
    entityManager.persist(user);

    for (int i = 0; i < 10; i++) {
      Notebook notebook = new Notebook(0, "Acer" + i, 1200 + i * 10, Instant.now().plusSeconds(60 * i));
      entityManager.persist(notebook);
    }

    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
