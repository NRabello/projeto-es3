package com.nrabello.back.strategies.impl.book;

import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidateBookPriceStrategy implements IStrategy<Book> {

    @Override
    public List<Book> process(Book book) {
        if (!isPriceValid(book)) {
            throw new IllegalArgumentException("Invalid price for book");
        }
        return new ArrayList<>();
    }

    private boolean isPriceValid(Book book) {
        int pricingGroupId = Math.toIntExact(book.getPricingGroup().getId());

        return switch (pricingGroupId) {
            case 1 -> book.getValue() >= 1 && book.getValue() <= 20;
            case 2 -> book.getValue() > 20 && book.getValue() <= 50;
            case 3 -> book.getValue() > 50;
            default -> throw new IllegalArgumentException("Invalid pricing group ID");
        };
    }

}
