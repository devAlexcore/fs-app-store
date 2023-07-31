package com.applicationstore.application_store.mappers;

import com.applicationstore.application_store.model.DTOs.CategoryDTO;
import com.applicationstore.application_store.model.entities.Category;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mapping(target = "apps", ignore = true)
  CategoryDTO toDTO(Category category, @Context CycleAvoidingMappingContext context);

  Category toEntity(CategoryDTO categoryDTO, @Context CycleAvoidingMappingContext context);

  List<CategoryDTO> toDTOs(List<Category> categories, @Context CycleAvoidingMappingContext context);

  List<Category> toEntities(List<CategoryDTO> categoryDTOs, @Context CycleAvoidingMappingContext context);
}
