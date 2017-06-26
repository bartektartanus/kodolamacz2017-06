package sages.bootcamp;

import javax.persistence.EntityManager;

public class TownDaoImpl implements TownDao {

    private EntityManager entityManager;

    public TownDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Town town) {
        beginTransaction();
        entityManager.persist(town);
        commitTransaction();
    }

    private void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    private void beginTransaction() {
        entityManager.getTransaction().begin();
    }
}
