package com.nrabello.back.strategies.book;

import com.nrabello.back.database.BookDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveBookStrategy implements IStrategy<Book> {

    @Autowired
    BookDao dao;

    @Override
    public List<Book> process(Book book) {
        book.getDimensions().setBook(book);
        dao.save(book);
        return new ArrayList<>();
    }
}
