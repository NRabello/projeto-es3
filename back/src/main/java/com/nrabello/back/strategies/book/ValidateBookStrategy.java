package com.nrabello.back.strategies.book;

import com.nrabello.back.database.BookDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class ValidateBookStrategy implements IStrategy<Book> {

    @Autowired
    BookDao dao;

    @Override
    public List<Book> process(Book book) {
        Field[] fields = book.getClass().getDeclaredFields();
        List<String> errorMessages = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if(field.getName() == "id") continue;

                Object value = field.get(book);

                if (value == null || value.toString().trim().isEmpty()) {
                    errorMessages.add("Field " + field.getName() + " is required.");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                errorMessages.add("Field " + field.getName() + " could not be accessed.");
            }
        }

        if (!errorMessages.isEmpty()) {
            throw new IllegalArgumentException(String.join(" ", errorMessages));
        }
        return null;
    }
}
