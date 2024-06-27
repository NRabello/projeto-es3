package com.nrabello.back.database.impl;

import com.nrabello.back.database.IDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDao implements IDao<Book> {

    @Autowired
    BookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> find(String filter) {
        return repository.findAllByTitleOrAuthorNameOrYearAndActive(filter);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public void update(Book book) {
        repository.save(book);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
