package com.applicationstore.application_store.services;


import com.applicationstore.application_store.mappers.CycleAvoidingMappingContext;
import com.applicationstore.application_store.mappers.ReviewMapper;
import com.applicationstore.application_store.model.DTOs.ReviewDTO;
import com.applicationstore.application_store.model.entities.App;
import com.applicationstore.application_store.model.entities.Review;
import com.applicationstore.application_store.repositories.AppRepository;
import com.applicationstore.application_store.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final AppRepository appRepository;
  private final ReviewMapper reviewMapper;

  public ReviewDTO createReview(ReviewDTO reviewDTO) {
    Review review = reviewMapper.toEntity(reviewDTO, new CycleAvoidingMappingContext());
    App app = appRepository.findById(reviewDTO.getAppId()).orElseThrow(() -> new RuntimeException("App not found"));
    review.setApp(app);
    Review savedReview = reviewRepository.save(review);
    return reviewMapper.toDTO(savedReview, new CycleAvoidingMappingContext());
  }
}