package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_title")
    private String bookTitle;
    private String author;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    List<Library> libraryList;

    public Book() {
    }

    public Book(String bookTitle, String author, Integer quantity, List<Library> libraryList) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.quantity = quantity;
        this.libraryList = libraryList;
    }

    public Book(Integer id, String bookTitle, String author, Integer quantity, List<Library> libraryList) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.quantity = quantity;
        this.libraryList = libraryList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer bookCode) {
        this.id = bookCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }
}
