package com.nrabello.back.database;

import com.nrabello.back.domain.Book;
import com.nrabello.back.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDao implements IDao<Book> {

    @Autowired
    BookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Book> find(String filter) {
        return repository.findAllByTitleOrAuthorNameOrAcquisitionValueOrYearAndActive(filter);
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
