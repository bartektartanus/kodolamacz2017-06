package pl.sages.twitter.dao;

import pl.sages.twitter.model.Tweet;
import pl.sages.twitter.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class TweetDaoImpl extends AbstractDaoImpl<Tweet> implements TweetDao {

    public TweetDaoImpl(EntityManager entityManager) {
        super(entityManager, Tweet.class);
    }

    @Override
    public List<Tweet> findAllByUser(User user) {
        return null;
    }
}
