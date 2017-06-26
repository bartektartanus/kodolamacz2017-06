package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {

    private EntityManager entityManager;

    public NotebookDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Notebook> findByResolution(int resolution) {
        TypedQuery<Notebook> query = entityManager.createQuery("select n from Notebook n where resolution = :resolution", Notebook.class);
        query.setParameter("resolution", resolution);
        return query.getResultList();
    }
}
