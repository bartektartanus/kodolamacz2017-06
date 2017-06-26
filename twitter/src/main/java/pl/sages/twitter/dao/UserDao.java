package pl.sages.twitter.dao;

import pl.sages.twitter.model.User;

public interface UserDao extends AbstractDao<User> {

    User findByLogin(String login);
    User findByEmail(String email);

}
