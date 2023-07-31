package com.applicationstore.application_store.services;

import com.applicationstore.application_store.mappers.CategoryMapper;
import com.applicationstore.application_store.mappers.CycleAvoidingMappingContext;
import com.applicationstore.application_store.model.DTOs.CategoryDTO;
import com.applicationstore.application_store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  public List<CategoryDTO> getAllCategories() {
    return categoryRepository.findAll().stream()
        .map(category -> categoryMapper.toDTO(category, new CycleAvoidingMappingContext()))
        .toList();
  }
}
