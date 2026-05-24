package com.bookcatalog.service;

import com.bookcatalog.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();

    Review getById(Long id);

    Review create(Review review);

    Review update(Long id, Review review);

    void delete(Long id);
}