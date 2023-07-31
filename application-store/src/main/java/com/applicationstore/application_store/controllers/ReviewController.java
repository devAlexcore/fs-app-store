package com.applicationstore.application_store.controllers;

import com.applicationstore.application_store.model.DTOs.ReviewDTO;
import com.applicationstore.application_store.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService reviewService;

  @PostMapping("/create")
  public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
    return new ResponseEntity<>(reviewService.createReview(reviewDTO), HttpStatus.CREATED);
  }
}