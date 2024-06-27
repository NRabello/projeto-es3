package com.nrabello.back.repositories;

import com.nrabello.back.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:filter% OR b.author.name like %:filter% OR b.year like %:filter% and b.active = true")
    List<Book> findAllByTitleOrAuthorNameOrYearAndActive(@Param("filter") String filter);
}
