package com.monitering.health_ingestion_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;


@Getter
@Setter
public class HealthPayload {

    @NotBlank
    private String  tenantId;

    @NotBlank
    private String  agentId;

    @NotBlank
    private String  serviceName;

    @NotBlank
    private String  serviceInstanceId;

    @NotBlank
    private String  status;

    @NotNull
    private Instant timestamp;

    private Map<String, Object> details;
}

