package com.applicationstore.application_store.repositories;

import com.applicationstore.application_store.model.entities.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppRepository extends JpaRepository<App, UUID> {
  Optional<App> findByName(String name);
}
