package com.bookcatalog.controller;

import com.bookcatalog.entity.Review;
import com.bookcatalog.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(
            ReviewRepository reviewRepository
    ) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @PostMapping
    public Review create(
            @RequestBody Review review
    ) {
        return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    public Review update(
            @PathVariable Long id,
            @RequestBody Review updated
    ) {

        Review review =
                reviewRepository.findById(id)
                        .orElseThrow();

        review.setRating(updated.getRating());
        review.setComment(updated.getComment());

        return reviewRepository.save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }
}