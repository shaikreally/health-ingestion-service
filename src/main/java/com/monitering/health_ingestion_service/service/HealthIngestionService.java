package com.monitering.health_ingestion_service.service;

import com.monitering.health_ingestion_service.domain.entity.HealthReportEntity;
import com.monitering.health_ingestion_service.dto.HealthPayload;
import com.monitering.health_ingestion_service.repository.HealthReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HealthIngestionService {

    private final HealthReportRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "health-reports";

    public void processHealthReport(HealthPayload payload) {

        HealthReportEntity entity = mapToEntity(payload);

        // 1️⃣ Persist first (durability)
        repository.save(entity);

        // 2️⃣ Publish event async
        try {
            kafkaTemplate.send(TOPIC, entity);
        } catch (Exception ex) {
            log.error("Kafka publish failed but ingestion persisted", ex);
        }

        log.info("Health report persisted and published. tenant={}, service={}",
                payload.getTenantId(),
                payload.getServiceName());
    }

    private HealthReportEntity mapToEntity(HealthPayload payload) {

        HealthReportEntity entity = new HealthReportEntity();
        entity.setId(UUID.randomUUID());
        entity.setTenantId(payload.getTenantId());
        entity.setAgentId(payload.getAgentId());
        entity.setServiceName(payload.getServiceName());
        entity.setServiceInstanceId(payload.getServiceInstanceId());
        entity.setStatus(payload.getStatus());
        entity.setEventTimestamp(payload.getTimestamp());
        entity.setDetails(payload.getDetails());

        return entity;
    }
}
