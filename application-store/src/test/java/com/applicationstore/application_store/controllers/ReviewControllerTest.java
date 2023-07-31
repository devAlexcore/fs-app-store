package com.applicationstore.application_store.controllers;

import com.applicationstore.application_store.model.DTOs.ReviewDTO;
import com.applicationstore.application_store.services.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewControllerTest {

  @Mock
  private ReviewService reviewService;

  @InjectMocks
  private ReviewController reviewController;

  @Test
  void testCreateReview() {
    UUID mockReviewId = UUID.randomUUID();
    UUID mockAppId = UUID.randomUUID();
    ReviewDTO reviewDTO = new ReviewDTO(mockReviewId, "Example Review", mockAppId);
    when(reviewService.createReview(any(ReviewDTO.class))).thenReturn(reviewDTO);
    ResponseEntity<ReviewDTO> response = reviewController.createReview(reviewDTO);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(reviewDTO, response.getBody());
  }
}
