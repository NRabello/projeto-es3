package com.nrabello.back.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Grupos_Precificacao")
public class PricingGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="grp_id")
    private Long id;
    @Column(name="grp_name")
    private String name;
    @Column(name="grp_desconto")
    private Double discount;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public PricingGroup() {
    }

    public PricingGroup(Long id, String name, Double discount) {
        this.setId(id);
        this.setName(name);
        this.setDiscount(discount);
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
