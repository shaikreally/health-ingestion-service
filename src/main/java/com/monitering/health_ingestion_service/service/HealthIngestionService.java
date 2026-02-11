package com.monitering.health_ingestion_service.service;

import com.monitering.health_ingestion_service.dto.HealthPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class HealthIngestionService {

    private static final Logger log = LoggerFactory.getLogger(HealthIngestionService.class);

    public void process(HealthPayload payload) {

        // Future: publish to Kafka
        // For now: log only

        log.info("Received health report: tenant={}, service={}, status={}",
                payload.getTenantId(),
                payload.getServiceName(),
                payload.getStatus());
    }


}
