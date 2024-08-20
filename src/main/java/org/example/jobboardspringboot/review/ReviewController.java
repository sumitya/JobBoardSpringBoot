package org.example.jobboardspringboot.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        List<Review> review = reviewService.getAllReviews(companyId);
        if(review != null) return ResponseEntity.ok(review);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public  ResponseEntity<String> createReview(@PathVariable Long companyId,
                                                @RequestBody Review review) {
       reviewService.addReview(companyId,review);
       return new ResponseEntity<>("Review Added ",HttpStatus.OK);
    }
}
