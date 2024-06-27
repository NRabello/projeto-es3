package com.nrabello.back.database;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    List<T> findAll();
    Optional<T> findById(Long id);
    List<T> find(String filter);
    void save(T t);
    void update(T t);
    void delete(Long id);
}
