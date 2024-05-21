package com.ninjatrip.review.mapper;

import com.ninjatrip.review.dto.GetReviewResponse;
import com.ninjatrip.review.dto.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<GetReviewResponse> getReviews(String place);
    void writeReview(Review review);
}
