package pl.sages.twitter.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String login;
    private String email = "";
    private int age;
    @Enumerated(EnumType.STRING)
    private UserType type;
    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private List<Tweet> tweets;

    public User() {
        type = UserType.STANDARD;
    }

    public User(String login, int age) {
        this.login = login;
        this.age = age;
        this.tweets = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        }
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
