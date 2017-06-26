package pl.sages.twitter.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.sages.twitter.model.User;

import javax.persistence.Persistence;
import java.util.List;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl(Persistence
            .createEntityManagerFactory("postgres").createEntityManager());

    @Test
    public void shouldSaveUserTest(){
        // given
        User bartek = new User("bartek");
        // when
        userDao.save(bartek);

        // then
        List<User> all = userDao.findAll();
        Assert.assertEquals(1, all.size());

    }

    @Test
    public void shouldFindUserByLoginTest(){
        // given

        // when

        // then

    }

}
