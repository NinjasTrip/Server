package com.ninjatrip.review.service;

import com.ninjatrip.review.dto.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(String placeName);
    void writeReview(Review review);
}
