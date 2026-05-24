package com.bookcatalog.service;

import com.bookcatalog.entity.Review;
import com.bookcatalog.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Review not found"));
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long id, Review review) {

        Review existing = getById(id);

        existing.setComment(review.getComment());
        existing.setRating(review.getRating());

        return reviewRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}