package com.nrabello.back.strategies.impl.book;

import com.nrabello.back.database.impl.BookDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateBookStrategy implements IStrategy<Book> {

    @Autowired
    BookDao dao;

    @Override
    public List<Book> process(Book book) {
        if(dao.findById(book.getId()).isPresent()) {
            book.getDimensions().setBook(book);
            dao.save(book);
        }else{
            throw new IllegalArgumentException("This book does not exist.");
        }
        return new ArrayList<>();
    }
}
