package sages.bootcamp;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.Arrays;

public class App {
    private static final Logger LOG = Logger.getLogger(App.class);

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Notebook samsungNotebook = new Notebook(0, "Samsung", 1300, Instant.now());
        entityManager.persist(samsungNotebook);
        System.out.println(samsungNotebook);

        Notebook acerNotebook = new Notebook(0, "Acer", 1500, Instant.now());
        entityManager.persist(acerNotebook);
        System.out.println(acerNotebook);

        Town town = new Town(0, "Warszawa", 100);
        entityManager.persist(town);
        System.out.println(town);

        User user1 = new User(0, "marcin.krol", 25, Arrays.asList(samsungNotebook, acerNotebook), town);
        User user2 = new User(0, "bartek", 25, Arrays.asList(samsungNotebook, acerNotebook), town);
        entityManager.persist(user1);
        entityManager.persist(user2);

        System.out.println(user1);
        LOG.info(user1);
        entityManager.getTransaction().commit();


        UserDao userDao = new UserDaoImpl(entityManager);
        User userFromDb = userDao.findById(user1.getId());
        System.out.println(user1);
        System.out.println(userFromDb);

        User bartek = userDao.findByLogin("bartek");
        System.out.println("Bartek: " + bartek);

        // CRUD - Create Read Update Delete
        // DAO - Data Access Object

//    entityManager.getTransaction().begin();
//    User userFromDb = entityManager.find(User.class, user.getId());
        // postgres.jastadomain.ovh zamiast localhost
        //ERROR
        //WARN
        //INFO
        //DEBUG
        //TRACE

        entityManager.close();
        entityManagerFactory.close();
    }
}
