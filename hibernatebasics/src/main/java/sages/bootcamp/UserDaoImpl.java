package sages.bootcamp;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findById(int id) {
        beginTransaction();
        User user = entityManager.find(User.class, id);
        commitTransaction();
        return user;
    }

    @Override
    public User findByLogin(String login) {
        beginTransaction();
        LOG.info("Transakcja rozpoczęta");
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = ?1",
                User.class);
        query.setParameter(1, login);
        User singleResult = query.getSingleResult();
        commitTransaction();
        LOG.info("Transakcja zakończona");
        return  singleResult;
    }

    @Override
    public List<User> findAllByAgeBetween(int low, int high) {
        beginTransaction();
        TypedQuery<User> query = entityManager
                .createQuery("SELECT u from User u WHERE u.age > ?1 AND u.age < ?2", User.class);
        query.setParameter(1, low);
        query.setParameter(2, high);
        List<User> resultList = query.getResultList();
        commitTransaction();
        return resultList;
    }

    @Override
    public void save(User user) {
        beginTransaction();
        entityManager.persist(user);
        commitTransaction();
    }

    private void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    private void beginTransaction() {
        entityManager.getTransaction().begin();
    }
}
