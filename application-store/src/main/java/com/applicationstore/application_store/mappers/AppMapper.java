package com.applicationstore.application_store.mappers;

import com.applicationstore.application_store.model.DTOs.AppDTO;
import com.applicationstore.application_store.model.entities.App;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReviewMapper.class)
public interface AppMapper {

  @Mapping(source = "averageRating", target = "averageRating")
  @Mapping(source = "reviews", target = "reviews")
  AppDTO toDTO(App app, @Context CycleAvoidingMappingContext context);

  App toEntity(AppDTO appDTO, @Context CycleAvoidingMappingContext context);

  List<AppDTO> toDTOs(List<App> apps, @Context CycleAvoidingMappingContext context);

  List<App> toEntities(List<AppDTO> appDTOs, @Context CycleAvoidingMappingContext context);
}
