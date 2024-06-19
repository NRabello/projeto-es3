package com.nrabello.back.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Autores")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aut_id")
    private Long id;

    @Column(name="aut_nome")
    private String name;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "author")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(Long id, String name, List<Book> books) {
        this.setId(id);
        this.setName(name);
        this.setBooks(books);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
