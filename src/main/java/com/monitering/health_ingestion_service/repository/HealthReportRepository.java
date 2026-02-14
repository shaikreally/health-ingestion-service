package com.monitering.health_ingestion_service.repository;

import com.monitering.health_ingestion_service.domain.entity.HealthReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//@Repository
public interface HealthReportRepository extends JpaRepository<HealthReportEntity, UUID> {

}
