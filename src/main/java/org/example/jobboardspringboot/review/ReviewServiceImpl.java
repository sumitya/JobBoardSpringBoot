package org.example.jobboardspringboot.review;

import org.example.jobboardspringboot.company.Company;
import org.example.jobboardspringboot.company.CompanyService;
import org.example.jobboardspringboot.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepo repo;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepo repo,
                             CompanyService companyService) {
        this.repo = repo;
        this.companyService = companyService;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = repo.findByCompanyId(companyId);
        return reviews.stream()
                .filter( review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = repo.findByCompanyId(companyId);
        return  reviews;
    }

    @Override
    public void addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            repo.save(review);
        }
    }
}
