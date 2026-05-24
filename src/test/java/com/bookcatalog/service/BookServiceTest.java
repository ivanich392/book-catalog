package com.bookcatalog.service;

import com.bookcatalog.dto.BookDto;
import com.bookcatalog.entity.Book;
import com.bookcatalog.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void getBookById_shouldReturnBookDto() {

        Book book = new Book();

        book.setTitle("Test Book");
        book.setDescription("Test Description");
        book.setPublicationYear(2025);

        when(bookRepository.findById(1L))
                .thenReturn(Optional.of(book));

        BookDto result = bookService.getBookById(1L);

        assertNotNull(result);

        assertEquals("Test Book", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        assertEquals(2025, result.getPublicationYear());
    }
}