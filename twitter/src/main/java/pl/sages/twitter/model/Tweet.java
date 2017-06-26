package pl.sages.twitter.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet extends BaseEntity{

    // user_id jest kolumną, w której ma być trzymane ID użytkownika z klasy User
    // many to one oznacza, że wiele tweetów jest przypisanych do jednego użytkownika
    @ManyToOne
    private User user;
    private final String text;

    public Tweet() {
        text = "";
    }

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                "} " + super.toString();
    }
}
