package sages.bootcamp;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager, User.class);
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
                .createQuery("select u from User u WHERE u.age > :lowAge AND u.age < :highAge", User.class);
        query.setParameter("lowAge", low);
        query.setParameter("highAge", high);
        List<User> resultList = query.getResultList();
        commitTransaction();
        return resultList;
    }

}
