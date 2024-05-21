package com.ninjatrip.review.service;

import com.ninjatrip.review.dto.GetReviewResponse;
import com.ninjatrip.review.dto.Review;

import java.util.List;

public interface ReviewService {
    List<GetReviewResponse> getReviews(String placeName);
    void writeReview(Review review);
}
