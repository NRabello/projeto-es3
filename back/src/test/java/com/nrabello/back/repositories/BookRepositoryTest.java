package com.nrabello.back.repositories;

import com.nrabello.back.domain.Author;
import com.nrabello.back.domain.Book;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("Should return a list of books when successful")
    void findAllByTitleOrAuthorNameOrYearAndActiveSuccess() {
        Author author = new Author();
        author.setName("AuthorTest");
        createAuthor(author);

        Book book = new Book();
        book.setTitle("TitleTest");
        book.setYear("2024");
        book.setActive(true);
        book.setAuthor(author);

        createBook(book);
        String busca = "AuthorTest";
        List<Book> foundedBooks = bookRepository.findAllByTitleOrAuthorNameOrYearAndActive(busca);

        assertThat(foundedBooks).isNotEmpty();
    }

    @Test
    @DisplayName("Should not return a list of books when filter don't match with any book")
    void findAllByTitleOrAuthorNameOrYearAndActiveFailed() {
        Author author = new Author();
        author.setName("AuthorTest");
        createAuthor(author);

        Book book = new Book();
        book.setTitle("TitleTest");
        book.setYear("2024");
        book.setActive(true);
        book.setAuthor(author);

        createBook(book);
        String busca = "InvalidAuthorTest";
        List<Book> foundedBooks = bookRepository.findAllByTitleOrAuthorNameOrYearAndActive(busca);

        assertThat(foundedBooks).isEmpty();
    }


    private Book createBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    private Author createAuthor(Author author) {
        entityManager.persist(author);
        entityManager.flush();
        return author;
    }
}