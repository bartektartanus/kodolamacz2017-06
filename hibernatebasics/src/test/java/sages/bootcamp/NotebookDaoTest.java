package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Persistence;
import java.time.Instant;
import java.util.List;

public class NotebookDaoTest {

    NotebookDao notebookDao = new NotebookDaoImpl(Persistence
            .createEntityManagerFactory("postgres").createEntityManager());

    @Test
    public void shouldFindBySizeAndColourTest(){
        // given
        Notebook samsung = new Notebook("samsung", 1024, 15,
                "black", Instant.now());
        Notebook macbook = new Notebook("macbook", 1368, 15,
                "silver", Instant.now());
        Notebook hp = new Notebook("hp", 1080, 17, "blue", Instant.now());
        notebookDao.save(samsung);
        notebookDao.save(macbook);
        notebookDao.save(hp);
        // when
        List<Notebook> notebooks = notebookDao.findAllBySizeAndColour(15, "silver");

        // then
        Assert.assertEquals(1, notebooks.size());
        Assert.assertEquals("macbook", notebooks.get(0).getModel());

    }

}
