package group.lab1FINAL.Service;

import group.lab1FINAL.Model.Cubes;

import java.util.List;

public interface Service<T> {
    List<T> getAll();

    T save(T obj);

    T getById(Long id);

    T update(T obj);

    void delete(Long id);
}
