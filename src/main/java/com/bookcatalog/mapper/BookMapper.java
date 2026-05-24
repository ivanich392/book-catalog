package com.bookcatalog.mapper;

import com.bookcatalog.dto.BookDto;
import com.bookcatalog.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book) {

        BookDto dto = new BookDto();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setPublicationYear(book.getPublicationYear());

        if (book.getAuthor() != null) {
            dto.setAuthorName(book.getAuthor().getFullName());
        }

        if (book.getGenre() != null) {
            dto.setGenreName(book.getGenre().getName());
        }

        return dto;
    }
}