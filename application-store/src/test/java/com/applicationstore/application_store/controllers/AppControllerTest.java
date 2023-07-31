package com.applicationstore.application_store.controllers;

import com.applicationstore.application_store.model.DTOs.AppDTO;
import com.applicationstore.application_store.services.AppService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppControllerTest {

  @InjectMocks
  private AppController appController;

  @Mock
  private AppService appService;

  @Test
  void testGetAllApps() {
    List<AppDTO> mockAppSet = Collections.singletonList(new AppDTO());
    when(appService.getAllApps()).thenReturn(mockAppSet);
    ResponseEntity<List<AppDTO>> response = appController.getAllApps();
    assertEquals (HttpStatus.OK, response.getStatusCode());
    assertEquals(mockAppSet, response.getBody());
  }

  @Test
  void testCreateApp() {
    AppDTO appDTO = new AppDTO();
    appDTO.setName("Test App");
    appDTO.setDescription("This is a test app");
    UUID mockAppId = UUID.randomUUID();
    AppDTO mockCreatedApp = new AppDTO();
    mockCreatedApp.setId(mockAppId);
    mockCreatedApp.setName("Test App");
    mockCreatedApp.setDescription("This is a test app");
    when(appService.createApp(appDTO)).thenReturn(mockCreatedApp);
    ResponseEntity<AppDTO> response = appController.createApp(appDTO);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(mockCreatedApp, response.getBody());
  }


}