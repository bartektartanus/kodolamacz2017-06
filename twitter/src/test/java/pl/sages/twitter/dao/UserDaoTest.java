package pl.sages.twitter.dao;

import org.junit.Assert;
import org.junit.Test;
import pl.sages.twitter.model.User;

import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl(Persistence
            .createEntityManagerFactory("postgres").createEntityManager());

    @Test
    public void shouldSaveUserTest(){
        // given
        User bartek = new User("bartek", 20);
        // when
        userDao.save(bartek);

        // then
        List<User> all = userDao.findAll();
        Assert.assertEquals(1, all.size());

    }

    @Test
    public void shouldFindUserByLoginTest(){
        // given
        User user = new User("abc", 20);
        user.addTweet("Siema, to mój pierwszy tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        // when
        userDao.save(user);

        // then
        User pusty = null;
        String pustyLogin = null;
        if(pusty != null){
            pustyLogin = pusty.getLogin();
        }
        if(pustyLogin != null){
            System.out.println(pustyLogin.length());
        }
        pusty.getLogin();
        Optional<User> byLogin = userDao.findByLogin("abc");

        byLogin.map(u -> u.getTweets()).ifPresent(tweets -> System.out.println());

        if(byLogin.isPresent()){
            System.out.println(byLogin.get().getTweets());
        }

        UUID uuid = UUID.randomUUID();
        uuid.toString();

        Integer age = byLogin.map(u -> u.getAge() * 365).orElse(0);

        // NIGDY nie wolno przypisać nulla do Optionala
        // jeśli wartośći nie ma to TYLKO empty();
        Optional<User> TEGO_NIGDY_NIE_ROBIMY = null;

        Optional<User> tegoNieMa = userDao.findByLogin("tegoNieMa");
        User user1 = tegoNieMa.orElse(new User("tegoNieMa",19));
        tegoNieMa.ifPresent(u -> System.out.println(u));
        Optional<Integer> integer = tegoNieMa
                .map(User::getLogin)
                .map(login -> login.length());
        Optional<String> s = tegoNieMa.map(new Function<User, String>() {
            @Override
            public String apply(User user) {
                return user.getLogin();
            }
        });
        getUserLoginLength2(new User("",19));
    }

    public int getUserLoginLength(User user){
        if(user != null){
            if(user.getLogin() != null){
                return user.getLogin().length();
            }
        }
        return 0;
    }

    public int getUserLoginLength2(User user){
        return user.getLogin().length();
    }


    @Test
    public void shouldFindUserByEmailTest(){
        // given
        User user = new User("abc", 20);
        user.addTweet("Siema, to mój pierwszy tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        user.addTweet("Siema, to mój drugi tweet!");
        // when
        userDao.save(user);

        // then
        User byId = userDao.findByEmail("test@gmail.com");
        System.out.println(byId);
        if(byId != null){
            System.out.println(byId.getTweets().get(0).getUser());
        }

    }
}
