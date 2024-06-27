package com.nrabello.back.strategies.impl.book;

import com.nrabello.back.database.impl.BookDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FindBookByIdStrategy implements IStrategy<Book> {

    @Autowired
    BookDao dao;

    @Override
    public List<Book> process(Book book) {
        if(dao.findById(book.getId()).isPresent()){
            return Collections.singletonList(dao.findById(book.getId()).get());
        }else{
            return new ArrayList<>();
        }
    }
}
