package com.bookcatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}