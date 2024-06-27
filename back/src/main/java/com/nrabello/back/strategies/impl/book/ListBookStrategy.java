package com.nrabello.back.strategies.impl.book;

import com.nrabello.back.database.impl.BookDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListBookStrategy implements IStrategy<Book> {

    @Autowired
    BookDao dao;

    @Override
    public List<Book> process(Book book) {
        return dao.findAll();
    }
}
