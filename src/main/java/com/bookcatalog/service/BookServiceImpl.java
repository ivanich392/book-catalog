package com.bookcatalog.service;

import com.bookcatalog.dto.BookDto;
import com.bookcatalog.entity.Book;
import com.bookcatalog.mapper.BookMapper;
import com.bookcatalog.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger =
            LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<BookDto> getAllBooks(Pageable pageable) {

        System.out.println("=== GET ALL BOOKS ===");
        logger.info("Getting all books");

        Page<Book> booksPage = bookRepository.findAll(pageable);

        List<BookDto> dtoList = booksPage.getContent()
                .stream()
                .map(BookMapper::toDto)
                .toList();

        return new PageImpl<>(
                dtoList,
                pageable,
                booksPage.getTotalElements()
        );
    }

    @Override
    public BookDto getBookById(Long id) {

        System.out.println("=== GET BOOK BY ID ===");
        logger.info("Getting book by id: {}", id);

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return BookMapper.toDto(book);
    }

    @Override
    public Book createBook(Book book) {

        System.out.println("=== CREATE BOOK ===");
        logger.info("Creating new book: {}", book.getTitle());

        return bookRepository.save(book);
    }

    @Override
    public BookDto updateBook(Long id, Book updatedBook) {

        System.out.println("=== UPDATE BOOK ===");
        logger.info("Updating book with id: {}", id);

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());

        Book savedBook = bookRepository.save(existingBook);

        return BookMapper.toDto(savedBook);
    }

    @Override
    public void deleteBook(Long id) {

        System.out.println("=== DELETE BOOK ===");
        logger.info("Deleting book with id: {}", id);

        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> searchBooks(String title) {

        System.out.println("=== SEARCH BOOKS ===");
        logger.info("Searching books by title: {}", title);

        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(BookMapper::toDto)
                .toList();
    }
}