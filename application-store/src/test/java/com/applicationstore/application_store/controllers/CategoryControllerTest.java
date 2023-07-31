package com.applicationstore.application_store.controllers;

import com.applicationstore.application_store.model.DTOs.CategoryDTO;
import com.applicationstore.application_store.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
  @Mock
  private CategoryService categoryService;

  @InjectMocks
  private CategoryController categoryController;

  @Test
  void testGetAllCategories() {
    UUID mockCatId1 = UUID.randomUUID();
    UUID mockCatId2 = UUID.randomUUID();

    CategoryDTO category1 = new CategoryDTO(mockCatId1, "Category 1", null);
    CategoryDTO category2 = new CategoryDTO(mockCatId2, "Category 2", null);

    List<CategoryDTO> mockCategories = List.of(category1, category2);
    when(categoryService.getAllCategories()).thenReturn(mockCategories);

    ResponseEntity<List<CategoryDTO>> response = categoryController.getAllCategories();
    assertEquals(HttpStatus.OK, response.getStatusCode());

    List<CategoryDTO> responseCategories = response.getBody();
    assertEquals(mockCategories.size(), responseCategories.size());
    assertEquals(mockCategories, responseCategories);
  }

}