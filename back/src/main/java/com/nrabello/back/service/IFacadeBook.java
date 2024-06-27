package com.nrabello.back.service;

import com.nrabello.back.domain.Book;

public interface IFacadeBook extends IFacade<Book>{

    Book findById(Long id);
    void save(Book book);
    void update(Book book);
}
