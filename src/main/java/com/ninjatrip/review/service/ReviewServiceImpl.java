package com.ninjatrip.review.service;

import com.ninjatrip.review.dto.Review;
import com.ninjatrip.review.mapper.ReviewMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper mapper;

    public ReviewServiceImpl(ReviewMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Review> getReviews(String placeName) {
        return mapper.getReviews(placeName);
    }

    @Override
    public void writeReview(Review review) {
        review.setTotal(
                (int) Math.round((review.getFood() + review.getTraffic() + review.getTravel()) / 3)
        );
        mapper.writeReview(review);
    }
}
