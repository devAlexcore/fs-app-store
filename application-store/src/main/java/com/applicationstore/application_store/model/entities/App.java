package com.applicationstore.application_store.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "apps")
public class App {

  @Id
  @GeneratedValue
  @Column( columnDefinition = "uuid", updatable = false )
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "developerCompany", nullable = false)
  private String developerCompany;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "average_rating", nullable = true)
  private Double averageRating;

  @Column(name = "image", nullable = true)
  private String image;

  @Column(name = "installed")
  private Boolean installed;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "app", fetch = FetchType.EAGER)
  private List<Review> reviews;
}
