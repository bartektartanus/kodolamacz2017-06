package pl.sages.twitter.dao;

import pl.sages.twitter.model.BaseEntity;

import java.util.List;

public interface AbstractDao<T extends BaseEntity> {

    // Create
    void save(T entity);

    void save(List<T> entities);

    // Read
    T findById(int id);

    List<T> findAll();

    // Update
    void update(T entity);

    // Delete
    void delete(T entity);

}
