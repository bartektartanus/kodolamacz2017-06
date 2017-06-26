package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class NotebookDaoImpl extends AbstractDaoImpl<Notebook> implements NotebookDao {

    public NotebookDaoImpl(EntityManager entityManager) {
        super(entityManager, Notebook.class);
    }

    @Override
    public List<Notebook> findByResolution(int resolution) {
        TypedQuery<Notebook> query = entityManager
                .createQuery("select n from Notebook n where n.resolution = :resolution", Notebook.class);
        query.setParameter("resolution", resolution);
        return query.getResultList();
    }

    @Override
    public List<Notebook> findAllBySizeAndColour(int size, String colour) {
        beginTransaction();
        TypedQuery<Notebook> query = entityManager
                .createQuery("select n from Notebook n " +
                                "where n.sizeInInches = :size and n.colour = :colour",
                        Notebook.class);
        query.setParameter("size", size);
        query.setParameter("colour", colour);
        List<Notebook> resultList = query.getResultList();
        commitTransaction();
        return resultList;

    }


}
