package com.applicationstore.application_store.services;
import com.applicationstore.application_store.mappers.CategoryMapper;
import com.applicationstore.application_store.model.DTOs.CategoryDTO;
import com.applicationstore.application_store.model.entities.Category;
import com.applicationstore.application_store.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

  @Mock
  private CategoryRepository categoryRepository;

  @Mock
  private CategoryMapper categoryMapper;

  @Test
  void testGetAllCategories() {
    Category category1 = new Category();
    category1.setId(UUID.randomUUID());
    category1.setName("Category 1");

    Category category2 = new Category();
    category2.setId(UUID.randomUUID());
    category2.setName("Category 2");

    CategoryDTO categoryDTO1 = new CategoryDTO(category1.getId(), category1.getName(), null);
    CategoryDTO categoryDTO2 = new CategoryDTO(category2.getId(), category2.getName(), null);

    when(categoryMapper.toDTO(any(), any())).thenAnswer(invocation -> {
      Category category = invocation.getArgument(0);
      if (category.getName().equals(category1.getName())) {
        return categoryDTO1;
      } else {
        return categoryDTO2;
      }
    });

    when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));

    CategoryService categoryService = new CategoryService(categoryRepository, categoryMapper);

    List<CategoryDTO> result = categoryService.getAllCategories();

    assertEquals(2, result.size());
    assertEquals(categoryDTO1, result.get(0));
    assertEquals(categoryDTO2, result.get(1));

    Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
    Mockito.verify(categoryMapper, Mockito.times(2)).toDTO(any(), any());
  }
}