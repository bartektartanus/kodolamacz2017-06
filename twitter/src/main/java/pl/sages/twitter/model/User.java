package pl.sages.twitter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private List<Tweet> tweets;

    public User(String login) {
        this.login = login;
        this.tweets = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void addTweet(String tweet){
        tweets.add(new Tweet(tweet, this));
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", tweets=" + tweets +
                "} " + super.toString();
    }
}
