package pl.sages.twitter.dao;

import pl.sages.twitter.model.User;
import pl.sages.twitter.model.User_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = query();
        Root<User> root = query.from(User.class);
        query.where(cb.equal(root.get(User_.login),login));
        List<User> list = entityManager.createQuery(query).getResultList();
        if(list.size() > 0){
            return Optional.of(list.get(0));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public User findByEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = query();
        Root<User> root = query.from(User.class);
        query.where(cb.equal(root.get(User_.email), email));
        List<User> list = entityManager.createQuery(query).getResultList();
        if(list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }
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
        Predicate ageHigh = cb.lessThanOrEqualTo(root.get(User_.age), high);
        query.where(cb.and(ageLow, ageHigh));
        return entityManager.createQuery(query).getResultList();
    }

    private Predicate ageGte(CriteriaBuilder cb, Root<User> root, int age){
        return cb.greaterThanOrEqualTo(root.get(User_.age), age);
    }
}
