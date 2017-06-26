package sages.bootcamp;

import java.util.List;

public interface AbstractDao<T> {

    void save(T entity);

    void save(List<T> entities);

    T findById(int id);

    List<T> findAll();

}
