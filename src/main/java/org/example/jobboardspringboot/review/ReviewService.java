package org.example.jobboardspringboot.review;

import org.example.jobboardspringboot.job.Job;

import java.util.List;

public interface ReviewService {
    public Review getReviewById(Long id);
    public List<Review> getAllReviews(Long id);
    void addReview(Long companyId, Review review);
}
