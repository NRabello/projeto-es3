package com.nrabello.back.domain;

import jakarta.persistence.*;

@Entity
@Table(name="Motivos_Ativacao_Desativacao")
public class ReasonActivationDeactivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mad_id")
    private Long id;
    @Column(name="mad_descricao")
    private String description;

    @Column(name="mad_tipo")
    private String type;

    @ManyToOne()
    @JoinColumn(name = "mad_liv_id", referencedColumnName = "liv_id")
    private Book book;

    public ReasonActivationDeactivation() {
    }

    public ReasonActivationDeactivation(Long id, String description, Book book, String type) {
        this.setId(id);
        this.setDescription(description);
        this.setBook(book);
        this.setType(type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
