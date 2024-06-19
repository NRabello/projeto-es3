package com.nrabello.back.controllers;

import org.springframework.http.ResponseEntity;

public interface IController<T> {

    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> find(String filter);
    ResponseEntity<?> save(T t);
    ResponseEntity<?> update(T t);
    ResponseEntity<?> delete(Long id);
}
