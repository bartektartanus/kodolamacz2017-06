package sages.bootcamp;

import java.util.List;

// CRUD
public interface AbstractDao<T> {

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
