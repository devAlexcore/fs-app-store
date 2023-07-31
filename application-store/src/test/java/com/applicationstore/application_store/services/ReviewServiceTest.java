package com.applicationstore.application_store.services;

import com.applicationstore.application_store.mappers.CycleAvoidingMappingContext;
import com.applicationstore.application_store.mappers.ReviewMapper;
import com.applicationstore.application_store.model.DTOs.ReviewDTO;
import com.applicationstore.application_store.model.entities.App;
import com.applicationstore.application_store.model.entities.Review;
import com.applicationstore.application_store.repositories.AppRepository;
import com.applicationstore.application_store.repositories.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

  @Mock
  private ReviewRepository reviewRepository;

  @Mock
  private AppRepository appRepository;

  @Mock
  private ReviewMapper reviewMapper;

  private ReviewService reviewService;
  private CycleAvoidingMappingContext context;

  @BeforeEach
  void setup() {
    reviewService = new ReviewService(reviewRepository, appRepository, reviewMapper);
    context = new CycleAvoidingMappingContext();
  }

  @Test
  void testCreateReview() {
    ReviewDTO mockReviewDTO = new ReviewDTO();
    mockReviewDTO.setAppId(UUID.randomUUID());
    Review mockReview = new Review();
    App mockApp = new App();
    when(reviewMapper.toEntity(ArgumentMatchers.any(ReviewDTO.class), ArgumentMatchers.any(CycleAvoidingMappingContext.class))).thenReturn(mockReview);
    when(appRepository.findById(mockReviewDTO.getAppId())).thenReturn(Optional.of(mockApp));
    when(reviewRepository.save(mockReview)).thenReturn(mockReview);
    when(reviewMapper.toDTO(ArgumentMatchers.any(Review.class), ArgumentMatchers.any(CycleAvoidingMappingContext.class))).thenReturn(mockReviewDTO);

    ReviewDTO result = reviewService.createReview(mockReviewDTO);

    assertEquals(mockReviewDTO, result);
    verify(reviewRepository, times(1)).save(mockReview);
  }
}