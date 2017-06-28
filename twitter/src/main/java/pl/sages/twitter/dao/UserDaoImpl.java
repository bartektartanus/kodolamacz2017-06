package pl.sages.twitter.dao;

import pl.sages.twitter.model.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public User findByLogin(String login) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = query();
        Root<User> root = query.from(User.class);
        query.where(cb.equal(root.get("login"), login));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = query();
        Root<User> root = query.from(User.class);
        query.where(cb.equal(root.get("email"), email));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<User> findAllByAgeGte(int age) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(ageGte(cb, root, age));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findAllByAgeBetween(int low, int high) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = query();
        Root<User> root = query.from(User.class);
        Predicate ageLow = ageGte(cb, root, low);
        Predicate ageHigh = cb.lessThanOrEqualTo(root.get("age"), high);
        query.where(cb.and(ageLow, ageHigh));
        return entityManager.createQuery(query).getResultList();
    }

    private Predicate ageGte(CriteriaBuilder cb, Root<User> root, int age){
        return cb.greaterThanOrEqualTo(root.get("age"), age);
    }
}
