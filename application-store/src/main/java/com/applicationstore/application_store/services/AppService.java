package com.applicationstore.application_store.services;

import com.applicationstore.application_store.exceptions.ConflictException;
import com.applicationstore.application_store.exceptions.ResourceNotFoundException;
import com.applicationstore.application_store.mappers.AppMapper;
import com.applicationstore.application_store.mappers.CycleAvoidingMappingContext;
import com.applicationstore.application_store.mappers.ReviewMapper;
import com.applicationstore.application_store.model.DTOs.AppDTO;
import com.applicationstore.application_store.model.DTOs.ReviewDTO;
import com.applicationstore.application_store.model.entities.App;
import com.applicationstore.application_store.model.entities.Category;
import com.applicationstore.application_store.model.entities.Review;
import com.applicationstore.application_store.repositories.AppRepository;
import com.applicationstore.application_store.repositories.CategoryRepository;
import com.applicationstore.application_store.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppService {

  private final AppRepository appRepository;
  private final CategoryRepository categoryRepository;
  private final ReviewRepository reviewRepository;
  private final AppMapper appMapper;
  private final ReviewMapper reviewMapper;

  public List<AppDTO> getAllApps() {
    List<App> apps = appRepository.findAll();
    List<AppDTO> appDTOs = new ArrayList<>();

    if (apps != null) {
      appDTOs = apps.stream().map(app -> {
        AppDTO appDTO = appMapper.toDTO(app, new CycleAvoidingMappingContext());
        List<Review> reviews = new ArrayList<>(reviewRepository.findByAppId(app.getId()));
        List<ReviewDTO> reviewDTOs = reviews.stream()
            .map(review -> reviewMapper.toDTO(review, new CycleAvoidingMappingContext()))
            .collect(Collectors.toList());
        appDTO.setReviews(reviewDTOs);
        return appDTO;
      }).collect(Collectors.toList());
    }

    return appDTOs;
  }

  public AppDTO createApp(AppDTO appDTO) {
    appRepository.findByName(appDTO.getName()).ifPresent(app -> {throw new ConflictException("An app with the same name already exists");});
    Category category = categoryRepository.findById(appDTO.getCategory().getId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    App app = appMapper.toEntity(appDTO, new CycleAvoidingMappingContext());
    app.setCategory(category);
    App savedApp = appRepository.save(app);
    return appMapper.toDTO(savedApp, new CycleAvoidingMappingContext());
  }

  public AppDTO getAppById(UUID appId) {
    App app = appRepository.findById(appId).orElseThrow(() -> new ResourceNotFoundException("App not found"));
    AppDTO appDTO = appMapper.toDTO(app, new CycleAvoidingMappingContext());
    List<Review> reviews = new ArrayList<>(reviewRepository.findByAppId(app.getId()));
    List<ReviewDTO> reviewDTOs = reviews.stream()
        .map(review -> reviewMapper.toDTO(review, new CycleAvoidingMappingContext()))
        .collect(Collectors.toList());
    appDTO.setReviews(reviewDTOs);
    return appDTO;
  }

  @Transactional
  public AppDTO updateAverageRating(UUID appId, Double averageRating) {
    App app = appRepository.findById(appId).orElseThrow(() -> new ResourceNotFoundException("App not found"));
    app.setAverageRating(averageRating);
    App updatedApp = appRepository.save(app);
    return appMapper.toDTO(updatedApp, new CycleAvoidingMappingContext());
  }
}
