package pl.sages.twitter.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tweets")
public class Tweet extends BaseEntity{

    // user_id jest kolumną, w której ma być trzymane ID użytkownika z klasy User
    // many to one oznacza, że wiele tweetów jest przypisanych do jednego użytkownika
    @ManyToOne
    private User user;
    private final String text;
    private final Instant addDate;

    public Tweet() {
        text = "";
        this.addDate = Instant.now();
    }

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
        this.addDate = Instant.now();
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Instant getAddDate() {
        return addDate;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                "} " + super.toString();
    }
}
