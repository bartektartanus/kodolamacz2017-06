package sages.bootcamp;

import java.util.List;

public interface UserDao {

    User findById(int id);

    User findByLogin(String login);

    List<User> findAllByAgeBetween(int low, int high);

}
