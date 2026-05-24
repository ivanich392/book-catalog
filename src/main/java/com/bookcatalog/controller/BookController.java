package com.bookcatalog.controller;

import com.bookcatalog.dto.BookDto;
import com.bookcatalog.entity.Book;
import com.bookcatalog.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Получить все книги
    @GetMapping
    public Page<BookDto> getAllBooks(Pageable pageable) {
        return bookService.getAllBooks(pageable);
    }

    // Получить книгу по ID
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Создать книгу
    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.createBook(book);
    }

    // Обновить книгу
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id,
                              @Valid @RequestBody Book updatedBook) {

        return bookService.updateBook(id, updatedBook);
    }

    // Удалить книгу
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<BookDto> searchBooks(@RequestParam String title) {

        return bookService.searchBooks(title);
    }
}