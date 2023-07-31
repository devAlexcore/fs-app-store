package com.applicationstore.application_store.repositories;

import com.applicationstore.application_store.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
  List<Review> findByAppId(UUID appId);

}
