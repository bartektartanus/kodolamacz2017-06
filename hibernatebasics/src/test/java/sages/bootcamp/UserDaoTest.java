package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class UserDaoTest {

    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("postgres").createEntityManager();
    private UserDao userDao = new UserDaoImpl(entityManager);
    private TownDao townDao = new TownDaoImpl(entityManager);

    @Test
    public void shouldFindUsersByAgeTest(){
        // given
        Town warszawa = new Town(0, "Warszawa", 1500);
        townDao.save(warszawa);
        User mlody = new User("Franek", 10, warszawa);
        User starszy = new User("Stefan", 18, warszawa);
        User najstarszy = new User("Hela", 28, warszawa);
        userDao.save(mlody);
        userDao.save(starszy);
        userDao.save(najstarszy);
        // when
        List<User> users = userDao.findAllByAgeBetween(17, 20);
        // then
        Assert.assertEquals(1, users.size());
        User user = users.get(0);
        Assert.assertTrue(user.getAge() > 17);
        Assert.assertTrue(user.getAge() < 20);

    }

}
