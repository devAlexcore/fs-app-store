package com.applicationstore.application_store.mappers;

import com.applicationstore.application_store.model.DTOs.ReviewDTO;
import com.applicationstore.application_store.model.entities.Review;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

  @Mapping(source = "app.id", target = "appId")
  ReviewDTO toDTO(Review review, @Context CycleAvoidingMappingContext context);

  Review toEntity(ReviewDTO reviewDTO, @Context CycleAvoidingMappingContext context);

  List<ReviewDTO> toDTOs(List<Review> reviews, @Context CycleAvoidingMappingContext context);

  List<Review> toEntities(List<ReviewDTO> reviewDTOs, @Context CycleAvoidingMappingContext context);
}

