package com.monitering.health_ingestion_service.controller;

import monitoring_event_contract.event.HealthEvent;
import com.monitering.health_ingestion_service.service.HealthIngestionService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Void> reportHealth(@Valid @RequestBody HealthEvent payload) {
        ingestionService.processHealthReport(payload);
        return ResponseEntity.accepted().build();
    }


}
