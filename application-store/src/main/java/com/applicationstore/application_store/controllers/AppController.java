package com.applicationstore.application_store.controllers;

import com.applicationstore.application_store.model.DTOs.AppDTO;
import com.applicationstore.application_store.model.DTOs.UpdateAppRatingRequest;
import com.applicationstore.application_store.services.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/app")
@RequiredArgsConstructor
public class AppController {

  private final AppService appService;

  @GetMapping("all")
  public ResponseEntity<List<AppDTO>> getAllApps() {
    List<AppDTO> apps = appService.getAllApps();
    return ResponseEntity.ok(apps);
  }
  @PostMapping("/create")
  public ResponseEntity<AppDTO> createApp(@RequestBody AppDTO appDTO) {
    return new ResponseEntity<>(appService.createApp(appDTO), HttpStatus.CREATED);
  }

  @PutMapping("/updateRating")
  public ResponseEntity<AppDTO> updateAverageRating(@RequestBody UpdateAppRatingRequest request) {
    AppDTO updatedApp = appService.updateAverageRating(request.getId(), request.getAverageRating());
    return ResponseEntity.ok(updatedApp);
  }
}
