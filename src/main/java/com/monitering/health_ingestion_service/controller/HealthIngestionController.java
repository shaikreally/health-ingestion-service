package com.monitering.health_ingestion_service.controller;

import com.monitering.health_ingestion_service.dto.HealthPayload;
import com.monitering.health_ingestion_service.service.HealthIngestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/health")
public class HealthIngestionController {

    private final HealthIngestionService ingestionService;

    public HealthIngestionController(HealthIngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/report")
    public ResponseEntity<Void> reportHealth(@Valid @RequestBody HealthPayload payload) {
        ingestionService.process(payload);
        return ResponseEntity.accepted().build();
    }


}
