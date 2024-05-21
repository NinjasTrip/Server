package com.ninjatrip.review.mapper;

import com.ninjatrip.review.dto.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> getReviews(String place);
    void writeReview(Review review);
}
