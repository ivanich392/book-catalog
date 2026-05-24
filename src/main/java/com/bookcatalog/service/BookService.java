package com.bookcatalog.service;

import com.bookcatalog.dto.BookDto;
import com.bookcatalog.entity.Book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<BookDto> getAllBooks(Pageable pageable);

    BookDto getBookById(Long id);

    Book createBook(Book book);

    BookDto updateBook(Long id, Book updatedBook);

    void deleteBook(Long id);

    List<BookDto> searchBooks(String title);
}