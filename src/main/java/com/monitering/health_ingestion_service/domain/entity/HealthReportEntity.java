package com.monitering.health_ingestion_service.domain.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "health_report")
public class HealthReportEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String tenantId;

    @Column(nullable = false)
    private String agentId;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private String serviceInstanceId;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, Object> details;

    @Column(nullable = false)
    private Instant eventTimestamp;

    private Instant createdAt = Instant.now();
}
