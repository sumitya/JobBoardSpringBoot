package org.example.jobboardspringboot.review;

import org.example.jobboardspringboot.job.Job;

import java.util.List;

public interface ReviewService {
    Review getReview(Long companyId,Long reviewId);
    List<Review> getAllReviews(Long id);
    void addReview(Long companyId, Review review);
}
