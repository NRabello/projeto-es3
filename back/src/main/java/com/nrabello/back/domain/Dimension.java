package com.nrabello.back.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Dimensoes")
public class Dimension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dim_id")
    private Long id;
    @Column(name="dim_altura")
    private Double height;

    @Column(name="dim_largura")
    private Double width;

    @Column(name="dim_profundidade")
    private Double depth;

    @Column(name="dim_peso")
    private Double weight;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="dim_liv_id", referencedColumnName = "liv_id")
    @JsonIgnore
    private Book book;

    public Dimension() {
    }

    public Dimension(Long id, Double height, Double width, Double depth, Double weight, Book book) {
        this.setId(id);
        this.setHeight(height);
        this.setWidth(width);
        this.setDepth(depth);
        this.setWeight(weight);
        this.setBook(book);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}
