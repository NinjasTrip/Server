package com.ninjatrip.review.controller;

import com.ninjatrip.review.dto.GetReviewResponse;
import com.ninjatrip.review.dto.Review;
import com.ninjatrip.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{placeName}")
    public ResponseEntity<Map<String, Object>> getReview(@PathVariable String placeName) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        try {
            List<GetReviewResponse> reviews = reviewService.getReviews(placeName);
            status = HttpStatus.OK;
            resultMap.put("reviewList", reviews);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/write")
    public ResponseEntity<Map<String, Object>> writeReview(@RequestBody Review review) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED;
        try {
            reviewService.writeReview(review);
            status = HttpStatus.OK;
            resultMap.put("status", status);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
