package com.nrabello.back.strategies.impl.book;

import com.nrabello.back.domain.Book;
import com.nrabello.back.domain.PricingGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateBookPriceStrategyTest {

    @InjectMocks
    private ValidateBookPriceStrategy validateBookPriceStrategy;

    @BeforeEach
    public void setUp() {
        validateBookPriceStrategy = new ValidateBookPriceStrategy();
    }

    @Test
    @DisplayName("Should return empty list when price is valid")
    public void testValidPriceGroup1() {
        Book validBook = createBook(1, 10);
        assertDoesNotThrow(() -> validateBookPriceStrategy.process(validBook));
    }

    @Test
    @DisplayName("Should throw exception when price is invalid")
    public void testInvalidPriceGroup1() {
        Book invalidBook = createBook(1, 25);
        assertThrows(IllegalArgumentException.class, () -> validateBookPriceStrategy.process(invalidBook));
    }

    @Test
    @DisplayName("Should return empty list when price is valid")
    public void testValidPriceGroup2() {
        Book validBook = createBook(2, 30);
        assertDoesNotThrow(() -> validateBookPriceStrategy.process(validBook));
    }

    @Test
    @DisplayName("Should throw exception when price is invalid")
    public void testInvalidPriceGroup2() {
        Book invalidBook = createBook(2, 55);
        assertThrows(IllegalArgumentException.class, () -> validateBookPriceStrategy.process(invalidBook));
    }

    @Test
    @DisplayName("Should return empty list when price is valid")
    public void testValidPriceGroup3() {
        Book validBook = createBook(3, 60);
        assertDoesNotThrow(() -> validateBookPriceStrategy.process(validBook));
    }

    @Test
    @DisplayName("Should throw exception when price is invalid")
    public void testInvalidPriceGroup3() {
        Book invalidBook = createBook(3, 40);
        assertThrows(IllegalArgumentException.class, () -> validateBookPriceStrategy.process(invalidBook));
    }

    @Test
    @DisplayName("Should throw exception when price is invalid")
    public void testInvalidPricingGroup() {
        Book invalidBook = createBook(99, 10);
        assertThrows(IllegalArgumentException.class, () -> validateBookPriceStrategy.process(invalidBook));
    }

    private Book createBook(long pricingGroupId, double value) {
        PricingGroup pricingGroup = new PricingGroup();
        pricingGroup.setId(pricingGroupId);
        Book book = new Book();
        book.setPricingGroup(pricingGroup);
        book.setValue(value);
        return book;
    }

}