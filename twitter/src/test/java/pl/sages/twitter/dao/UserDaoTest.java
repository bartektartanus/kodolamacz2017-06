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
        User user = new User("abc");
        user.addTweet("Siema, to mój pierwszy tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        // when
        userDao.save(user);

        // then
        User byId = userDao.findById(1);
        System.out.println(byId);
        System.out.println(byId.getTweets().get(0).getUser());

    }

}
