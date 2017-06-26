package pl.sages.twitter.dao;

import pl.sages.twitter.model.Tweet;
import pl.sages.twitter.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TweetDaoImpl extends AbstractDaoImpl<Tweet> implements TweetDao {

    public TweetDaoImpl(EntityManager entityManager) {
        super(entityManager, Tweet.class);
    }

    @Override
    public List<Tweet> findAllByUser(User user) {
        beginTransaction();

        TypedQuery<Tweet> query = query("select t from Tweet t where t.user = :user");
        query.setParameter("user", user);
        List<Tweet> tweets = query.getResultList();

        commitTransaction();
        return tweets;
    }

    @Override
    public List<Tweet> findAllByUserLogin(String login) {
        beginTransaction();

        TypedQuery<Tweet> query = query("select t from Tweet t where t.user.login = :login");
        query.setParameter("login", login);
        List<Tweet> tweets = query.getResultList();

        commitTransaction();
        return tweets;
    }

    @Override
    public List<Tweet> findAllByTextContains(String text) {
        beginTransaction();

        TypedQuery<Tweet> query = query("select t from Tweet t where t.text like :text");
        query.setParameter("text", "%"+text+"%");
        List<Tweet> tweets = query.getResultList();

        commitTransaction();
        return tweets;
    }
}
