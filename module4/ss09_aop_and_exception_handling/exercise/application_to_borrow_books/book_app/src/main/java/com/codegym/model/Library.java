package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long rentalCode;

    @ManyToOne
    @JoinColumn(name = "book_code", referencedColumnName = "id")
    private Book book;

    public Library() {
    }

    public Library(Long rentalCode, Book book) {
        this.rentalCode = rentalCode;
        this.book = book;
    }

    public Library(Long id, Long rentalCode, Book book) {
        this.id = id;
        this.rentalCode = rentalCode;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentalCode() {
        return rentalCode;
    }

    public void setRentalCode(Long rentalCode) {
        this.rentalCode = rentalCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
