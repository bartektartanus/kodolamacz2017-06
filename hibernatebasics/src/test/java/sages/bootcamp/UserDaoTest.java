package sages.bootcamp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UserDaoTest {

    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("postgres").createEntityManager();
    private UserDao userDao = new UserDaoImpl(entityManager);
    private TownDao townDao = new TownDaoImpl(entityManager);

    @Before
    public void init(){
        Town warszawa = new Town(0, "Warszawa", 1500);
        townDao.save(warszawa);
        User mlody = new User("Franek", 10, warszawa);
        User starszy = new User("Stefan", 18, warszawa);
        User najstarszy = new User("Hela", 28, warszawa);
        List<User> usersToSave = new ArrayList<>(3);
        usersToSave.add(mlody);
        usersToSave.add(starszy);
        usersToSave.add(najstarszy);
        userDao.save(usersToSave);
    }

    @Test
    public void shouldFindUsersByAgeTest(){
        // given
        // sekcja given jest pusta, bo mamy metodę init oznaczoną anotacją @Before
        // która wykonuje się PRZED testem i wrzuca użytkowników do bazy
        // when
        List<User> users = userDao.findAllByAgeBetween(17, 20);
        // then
        Assert.assertEquals(1, users.size());
        User user = users.get(0);
        Assert.assertTrue(user.getAge() > 17);
        Assert.assertTrue(user.getAge() < 20);

    }

    @Test
    public void shouldFindAllUsersTest(){
        // given

        // when
        List<User> result = userDao.findAll();
        // then
        Assert.assertEquals(3, result.size());

    }

}
