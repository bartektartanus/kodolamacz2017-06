package sages.bootcamp;

import java.util.List;

public interface UserDao extends AbstractDao<User> {


    User findByLogin(String login);

    List<User> findAllByAgeBetween(int low, int high);

}
