package pl.sages.twitter.dao;

import pl.sages.twitter.model.User;

import javax.persistence.EntityManager;

public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
