package io.github.tibetteixeira.api.v1.domain.service;

import java.util.List;

public interface CrudService<T, Tid> {

    void save(T object);
    void update(Tid id, T object);
    void delete(T object);
    T findById(Tid id);
    List<T> findAll();
}
