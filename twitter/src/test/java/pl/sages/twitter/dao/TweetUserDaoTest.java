package pl.sages.twitter.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sages.twitter.model.Tweet;
import pl.sages.twitter.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TweetUserDaoTest {

    EntityManager entityManager = Persistence
            .createEntityManagerFactory("postgres").createEntityManager();

    UserDao userDao = new UserDaoImpl(entityManager);

    TweetDao tweetDao = new TweetDaoImpl(entityManager);

    User user;

    @Before
    public void init(){
        user = new User("abc");
        user.addTweet("Siema, to mój pierwszy tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        userDao.save(user);
    }

    @Test
    public void shouldFindByUserTest(){
        // given

        // when
        List<Tweet> tweets = tweetDao.findAllByUser(user);

        // then
        Assert.assertEquals(3, tweets.size());

    }

    @Test
    public void shouldFindByUserLoginTest(){
        // given

        // when
        List<Tweet> tweets = tweetDao.findAllByUserLogin(user.getLogin());

        // then
        Assert.assertEquals(3, tweets.size());

    }

    @Test
    public void shouldFindByTextTest(){
        // given

        // when
        List<Tweet> tweets = tweetDao.findAllByTextContains("drugi");

        // then
        Assert.assertEquals(2, tweets.size());

    }

    @Test
    public void shouldNotFindByTextTest(){
        // given

        // when
        List<Tweet> tweets = tweetDao.findAllByTextContains("szakalaka");

        // then
        Assert.assertEquals(0, tweets.size());

    }

}
