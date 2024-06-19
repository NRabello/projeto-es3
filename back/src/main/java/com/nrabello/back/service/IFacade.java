package com.nrabello.back.service;

import java.util.List;

public interface IFacade<T>{
    public List<T> findAll();
    public T findById(Long id);
    public List<T> find(String filter);

    public void save(T t);
    public void update(T t);
    public void delete(Long id);
}
