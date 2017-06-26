package sages.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDaoImpl<T>  implements AbstractDao<T> {

    protected EntityManager entityManager;
    private Class<T> tClass;
    public AbstractDaoImpl(EntityManager entityManager, Class<T> tClass) {
        this.entityManager = entityManager;
        this.tClass = tClass;
    }

    protected TypedQuery<T> query(String query){
        return entityManager.createQuery(query, tClass);
    }

    @Override
    public T findById(int id){
        beginTransaction();
        T entity = entityManager.find(tClass, id);
        commitTransaction();
        return entity;
    }

    @Override
    public void save(T entity) {
        beginTransaction();
        entityManager.persist(entity);
        commitTransaction();
    }

    @Override
    public void save(List<T> entities) {
        beginTransaction();
        for (T entity : entities) {
            entityManager.persist(entity);
        }
        commitTransaction();
    }

    @Override
    public void delete(T entity) {
        beginTransaction();
        entityManager.remove(entity);
        commitTransaction();
    }

    @Override
    public void update(T entity) {
        beginTransaction();
        entityManager.merge(entity);
        commitTransaction();
    }

    @Override
    public List<T> findAll() {
        beginTransaction();
        TypedQuery<T> query = entityManager.createQuery("SELECT t from " + tClass.getName() + " t", tClass);
        List<T> resultList = query.getResultList();
        commitTransaction();
        return resultList;
    }

    protected void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    protected void beginTransaction() {
        entityManager.getTransaction().begin();
    }

}
