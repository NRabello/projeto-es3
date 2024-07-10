package com.nrabello.back.strategies.impl.book;

import com.nrabello.back.database.impl.BookDao;
import com.nrabello.back.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateBookStrategyTest {

    @InjectMocks
    private ValidateBookStrategy validateBookStrategy;

    @Mock
    private BookDao bookDao;

    private Book createBook(Long id, String title, Author author, List<Category> categories, String year,
                            PublishingCompany publishingCompany, Double value, String edition, String isbn,
                            Integer pages, String synopsis, Dimension dimensions, PricingGroup pricingGroup,
                            String barcode, Boolean active) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategories(categories);
        book.setYear(year);
        book.setPublishingCompany(publishingCompany);
        book.setValue(value);
        book.setEdition(edition);
        book.setIsbn(isbn);
        book.setPages(pages);
        book.setSynopsis(synopsis);
        book.setDimensions(dimensions);
        book.setPricingGroup(pricingGroup);
        book.setBarcode(barcode);
        book.setActive(active);
        return book;
    }

    @Test
    @DisplayName("Should return no exception when book is valid")
    public void testValidBook() {
        Book validBook = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertDoesNotThrow(() -> validateBookStrategy.process(validBook));
    }

    @Test
    @DisplayName("Should return exception when book has missing title")
    public void testMissingTitle() {
        Book bookWithMissingTitle = createBook(1L, null, new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingTitle));
    }

    @Test
    @DisplayName("Should return exception when book has empty title")
    public void testEmptyTitle() {
        Book bookWithEmptyTitle = createBook(1L, "", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithEmptyTitle));
    }

    @Test
    @DisplayName("Should return exception when book has missing author")
    public void testMissingAuthor() {
        Book bookWithMissingAuthor = createBook(1L, "Valid Title", null, new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingAuthor));
    }

    @Test
    @DisplayName("Should return exception when book has missing categories")
    public void testMissingValue() {
        Book bookWithMissingValue = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                null, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingValue));
    }

    @Test
    @DisplayName("Should return exception when book has missing year")
    public void testMissingYear() {
        Book bookWithMissingYear = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), null, new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingYear));
    }

    @Test
    @DisplayName("Should return exception when book has empty year")
    public void testEmptyYear() {
        Book bookWithEmptyYear = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithEmptyYear));
    }

    @Test
    @DisplayName("Should return exception when book has missing publishing company")
    public void testMissingPublishingCompany() {
        Book bookWithMissingPublishingCompany = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", null,
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis",
                new Dimension(), new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingPublishingCompany));
    }

    @Test
    @DisplayName("Should return exception when book has missing value")
    public void testMissingEdition() {
        Book bookWithMissingEdition = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, null, "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingEdition));
    }

    @Test
    @DisplayName("Should return exception when book has empty edition")
    public void testEmptyEdition() {
        Book bookWithEmptyEdition = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithEmptyEdition));
    }

    @Test
    @DisplayName("Should return exception when book has missing isbn")
    public void testMissingIsbn() {
        Book bookWithMissingIsbn = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", null, 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingIsbn));
    }

    @Test
    @DisplayName("Should return exception when book has empty isbn")
    public void testEmptyIsbn() {
        Book bookWithEmptyIsbn = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithEmptyIsbn));
    }

    @Test
    @DisplayName("Should return exception when book has missing pages")
    public void testMissingPages() {
        Book bookWithMissingPages = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", null, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingPages));
    }

    @Test
    @DisplayName("Should return exception when book has missing synopsis")
    public void testMissingSynopsis() {
        Book bookWithMissingSynopsis = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, null, new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingSynopsis));
    }

    @Test
    @DisplayName("Should return exception when book has empty synopsis")
    public void testEmptySynopsis() {
        Book bookWithEmptySynopsis = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "", new Dimension(),
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithEmptySynopsis));
    }

    @Test
    @DisplayName("Should return exception when book has missing dimensions")
    public void testMissingDimensions() {
        Book bookWithMissingDimensions = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", null,
                new PricingGroup(), "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingDimensions));
    }

    @Test
    @DisplayName("Should return exception when book has missing pricing group")
    public void testMissingPricingGroup() {
        Book bookWithMissingPricingGroup = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                null, "123456789012", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingPricingGroup));
    }

    @Test
    @DisplayName("Should return exception when book has missing barcode")
    public void testMissingBarcode() {
        Book bookWithMissingBarcode = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), null, true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingBarcode));
    }

    @Test
    @DisplayName("Should return exception when book has empty barcode")
    public void testEmptyBarcode() {
        Book bookWithEmptyBarcode = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "", true);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithEmptyBarcode));
    }

    @Test
    @DisplayName("Should return exception when book has missing active")
    public void testMissingActive() {
        Book bookWithMissingActive = createBook(1L, "Valid Title", new Author(), new ArrayList<>(), "2021", new PublishingCompany(),
                10.0, "1st Edition", "1234567890123", 200, "Valid Synopsis", new Dimension(),
                new PricingGroup(), "123456789012", null);
        assertThrows(IllegalArgumentException.class, () -> validateBookStrategy.process(bookWithMissingActive));
    }
}