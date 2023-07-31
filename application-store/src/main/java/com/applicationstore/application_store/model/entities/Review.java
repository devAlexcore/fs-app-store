package com.applicationstore.application_store.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue
  @Column(columnDefinition = "uuid", updatable = false )
  private UUID id;

  @Column(name = "comment", nullable = false)
  private String comment;

  @ManyToOne
  @JoinColumn(name = "app_id", nullable = false)
  private App app;
}
