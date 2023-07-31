package com.applicationstore.application_store.services;

import com.applicationstore.application_store.exceptions.ConflictException;
import com.applicationstore.application_store.exceptions.ResourceNotFoundException;
import com.applicationstore.application_store.mappers.AppMapper;
import com.applicationstore.application_store.mappers.CycleAvoidingMappingContext;
import com.applicationstore.application_store.mappers.ReviewMapper;
import com.applicationstore.application_store.model.DTOs.AppDTO;
import com.applicationstore.application_store.model.DTOs.CategoryDTO;
import com.applicationstore.application_store.model.entities.App;
import com.applicationstore.application_store.model.entities.Category;
import com.applicationstore.application_store.repositories.AppRepository;
import com.applicationstore.application_store.repositories.CategoryRepository;
import com.applicationstore.application_store.repositories.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppServiceTest {

  @Mock
  AppRepository appRepository;

  @Mock
  CategoryRepository categoryRepository;

  @Mock
  ReviewRepository reviewRepository;

  @Mock
  AppMapper appMapper;

  @Mock
  ReviewMapper reviewMapper;

  @InjectMocks
  AppService appService;

  @Test
  void getAllApps() {
    App app = new App();
    app.setId(UUID.randomUUID());
    when(appRepository.findAll()).thenReturn(Collections.singletonList(app));
    when(appMapper.toDTO(any(), any())).thenReturn(new AppDTO());
    when(reviewRepository.findByAppId(any())).thenReturn(Collections.emptyList());

    List<AppDTO> appDTOs = appService.getAllApps();

    assertEquals(1, appDTOs.size());
    verify(appRepository, times(1)).findAll();
    verify(appMapper, times(1)).toDTO(any(), any());
    verify(reviewRepository, times(1)).findByAppId(any());
  }

  @Test
  void createApp() {
    AppDTO appDTO = new AppDTO();
    appDTO.setName("AppTest");
    appDTO.setCategory(new CategoryDTO());

    when(appRepository.findByName(any())).thenReturn(Optional.empty());
    when(categoryRepository.findById(any())).thenReturn(Optional.of(new Category()));
    when(appMapper.toEntity(any(), any())).thenReturn(new App());
    when(appRepository.save(any())).thenReturn(new App());
    when(appMapper.toDTO(any(), any())).thenReturn(new AppDTO());

    AppDTO createdAppDTO = appService.createApp(appDTO);

    verify(appRepository, times(1)).findByName(any());
    verify(categoryRepository, times(1)).findById(any());
    verify(appMapper, times(1)).toEntity(any(), any());
    verify(appRepository, times(1)).save(any());
    verify(appMapper, times(1)).toDTO(any(), any());
  }

  @Test
  void getAppById() {
    UUID appId = UUID.randomUUID();
    App app = new App();
    app.setId(appId);
    when(appRepository.findById(appId)).thenReturn(Optional.of(app));
    when(appMapper.toDTO(any(), any())).thenReturn(new AppDTO());
    when(reviewRepository.findByAppId(appId)).thenReturn(Collections.emptyList());

    AppDTO appDTO = appService.getAppById(appId);

    verify(appRepository, times(1)).findById(appId);
    verify(appMapper, times(1)).toDTO(any(), any());
    verify(reviewRepository, times(1)).findByAppId(appId);
  }

  @Test
  void getAppByIdNotFound() {
    UUID appId = UUID.randomUUID();
    when(appRepository.findById(appId)).thenReturn(Optional.empty());

    try {
      AppDTO appDTO = appService.getAppById(appId);
    } catch (Exception e) {
      assertEquals(ResourceNotFoundException.class, e.getClass());
    }

    verify(appRepository, times(1)).findById(appId);
  }

  @Test
  void createAppConflict() {
    AppDTO appDTO = new AppDTO();
    appDTO.setName("AppTest");
    appDTO.setCategory(new CategoryDTO());

    when(appRepository.findByName(any())).thenReturn(Optional.of(new App()));

    try {
      AppDTO createdAppDTO = appService.createApp(appDTO);
    } catch (Exception e) {
      assertEquals(ConflictException.class, e.getClass());
    }

    verify(appRepository, times(1)).findByName(any());
  }

  @Test
  void updateAverageRating() {
    // Arrange
    UUID appId = UUID.randomUUID();
    double newAverageRating = 4.2;

    App app = new App();
    app.setId(appId);

    AppDTO appDTO = new AppDTO();
    appDTO.setId(appId);
    appDTO.setAverageRating(newAverageRating);

    when(appRepository.findById(appId)).thenReturn(Optional.of(app));
    when(appRepository.save(app)).thenReturn(app);
    when(appMapper.toDTO(ArgumentMatchers.any(App.class), ArgumentMatchers.any(CycleAvoidingMappingContext.class))).thenReturn(appDTO);

    // Act
    AppDTO updatedAppDTO = appService.updateAverageRating(appId, newAverageRating);

    // Assert
    assertEquals(appId, updatedAppDTO.getId());
    assertEquals(newAverageRating, updatedAppDTO.getAverageRating());

    verify(appRepository, times(1)).findById(appId);
    verify(appRepository, times(1)).save(app);
    verify(appMapper, times(1)).toDTO(ArgumentMatchers.any(App.class), ArgumentMatchers.any(CycleAvoidingMappingContext.class));
  }
}