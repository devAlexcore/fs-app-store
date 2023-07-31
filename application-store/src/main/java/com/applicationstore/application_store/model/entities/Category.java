package com.applicationstore.application_store.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue
  @Column( columnDefinition = "uuid", updatable = false )
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(mappedBy = "category")
  private List<App> apps;

}
