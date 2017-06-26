package pl.sages.twitter.dao;

import pl.sages.twitter.model.Tweet;
import pl.sages.twitter.model.User;

import java.util.List;

public interface TweetDao extends AbstractDao<Tweet> {

    List<Tweet> findAllByUser(User user);

}
