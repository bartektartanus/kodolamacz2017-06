package pl.sages.twitter.dao;

import pl.sages.twitter.model.User;

import java.util.List;

public interface UserDao extends AbstractDao<User> {

    User findByLogin(String login);
    User findByEmail(String email);
    List<User> findAllByAgeGte(int age);

    List<User> findAllByAgeBetween(int low, int high);

}
