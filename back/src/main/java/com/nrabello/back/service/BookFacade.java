package com.nrabello.back.service;

import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.book.*;
import com.nrabello.back.strategies.log.GenerateLogStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class BookFacade implements IFacade<Book>{

    @Autowired
    ValidateBookStrategy validateBookStrategy;

    @Autowired
    SaveBookStrategy saveBookStrategy;

    @Autowired
    ListBookStrategy listBookStrategy;

    @Autowired
    FindBookByIdStrategy findBookByIdStrategy;

    @Autowired
    UpdateBookStrategy updateBookStrategy;

    @Autowired
    GenerateLogStrategy generateLogStrategy;


    @Override
    public List<Book> findAll() {
        return listBookStrategy.process(new Book());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Book findById(Long id) {
        Book book = new Book();
        book.setId(id);
        return findBookByIdStrategy.process(book).get(0);
    }

    @Override
    public List<Book> find(String filter) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Book book) {
        validateBookStrategy.process(book);
        generateLogStrategy.process(book);
        saveBookStrategy.process(book);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Book book) {
        validateBookStrategy.process(book);
        generateLogStrategy.process(book);
        updateBookStrategy.process(book);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {

    }
}
