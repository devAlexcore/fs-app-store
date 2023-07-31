package com.applicationstore.application_store.model.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppDTO {
  private UUID id;
  private String name;
  private String developerCompany;
  private String description;
  private Double price;
  private Double averageRating;
  private String image;
  private Boolean installed;
  private CategoryDTO category;
  private List<ReviewDTO> reviews;
}