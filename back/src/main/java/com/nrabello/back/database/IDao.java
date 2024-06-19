package com.nrabello.back.database;

import java.util.List;

public interface IDao<T> {

    List<T> findAll();
    T findById(Long id);
    List<T> find(String filter);
    void save(T t);
    void update(T t);
    void delete(Long id);
}
