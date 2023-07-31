package com.applicationstore.application_store.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAppRatingRequest {
  private UUID id;
  private Double averageRating;
}