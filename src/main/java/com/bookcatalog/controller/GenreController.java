package com.bookcatalog.controller;

import com.bookcatalog.entity.Genre;
import com.bookcatalog.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @PostMapping
    public Genre createGenre(
            @RequestBody Genre genre
    ) {
        return genreService.createGenre(genre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(
            @PathVariable Long id,
            @RequestBody Genre genre
    ) {
        return genreService.updateGenre(id, genre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(
            @PathVariable Long id
    ) {
        genreService.deleteGenre(id);
    }
}