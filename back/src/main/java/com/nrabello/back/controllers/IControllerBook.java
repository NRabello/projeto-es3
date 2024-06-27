package com.nrabello.back.controllers;

import com.nrabello.back.domain.Book;
import org.springframework.http.ResponseEntity;

public interface IControllerBook extends IController {

    ResponseEntity<?> save(Book book);
    ResponseEntity<?> update(Book book);
    ResponseEntity<?> findById(Long id);
}
