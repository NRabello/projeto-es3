package com.nrabello.back.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="liv_id")
    private Long id;
    @Column(name="liv_titulo")
    private String title;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="liv_aut_id", referencedColumnName = "aut_id")
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Livros_Categorias",
            joinColumns = @JoinColumn(name = "liv_id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id"))
    private List<Category> categories = new ArrayList<>();
    @Column(name="liv_ano")
    private String year;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="liv_edi_id", referencedColumnName = "edi_id")
    private PublishingCompany publishingCompany;
    @Column(name="liv_valorAquisicao")
    private String acquisitionValue;
    @Column(name="liv_edicao")
    private String edition;
    @Column(name="liv_isbn")
    private String isbn;
    @Column(name="liv_paginas")
    private Integer pages;
    @Column(name="liv_sinopse")
    private String synopsis;
    @OneToOne(mappedBy = "book",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Dimension dimensions;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="liv_grp_id", referencedColumnName = "grp_id")
    private PricingGroup pricingGroup;
    @Column(name="liv_codigoBarra")
    private String barcode;
    @Column(name="liv_ativo")
    private Boolean active;

    public Book() {
    }

    public Book(Long id, String title, Author author, String acquisitionValue, String synopsis, List<Category> categories, String year, PublishingCompany publishingCompany, String edition, String isbn, Integer pages, Dimension dimensions, PricingGroup pricingGroup, String barcode,Boolean active) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setAcquisitionValue(acquisitionValue);
        this.setSynopsis(synopsis);
        this.setCategories(categories);
        this.setYear(year);
        this.setPublishingCompany(publishingCompany);
        this.setEdition(edition);
        this.setIsbn(isbn);
        this.setPages(pages);
        this.setDimensions(dimensions);
        this.setPricingGroup(pricingGroup);
        this.setBarcode(barcode);
        this.setActive(active);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getAcquisitionValue() {
        return acquisitionValue;
    }

    public void setAcquisitionValue(String acquisitionValue) {
        this.acquisitionValue = acquisitionValue;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public PublishingCompany getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(PublishingCompany publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

    public PricingGroup getPricingGroup() {
        return pricingGroup;
    }

    public void setPricingGroup(PricingGroup pricingGroup) {
        this.pricingGroup = pricingGroup;
    }

    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
