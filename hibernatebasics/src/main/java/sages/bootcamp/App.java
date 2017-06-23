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

    Town town = new Town(0, "Warszawa", 100);
    entityManager.persist(town);
    System.out.println(town);

    User user = new User(0, "marcin.krol", 25, notebook, town);
    entityManager.persist(user);
    System.out.println(user);

    User userWithoutTown = new User(0, "marcin.krol", 25, notebook, null);
    entityManager.persist(userWithoutTown);
    System.out.println(userWithoutTown);

    User userWithoutTownAndNotebook = new User(0, "marcin.krol", 25, null, null);
    entityManager.persist(userWithoutTownAndNotebook);
    System.out.println(userWithoutTownAndNotebook);


    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
}
