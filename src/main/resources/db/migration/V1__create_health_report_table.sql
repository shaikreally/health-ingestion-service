CREATE TABLE health_report (
    id UUID PRIMARY KEY,
    tenant_id VARCHAR(100) NOT NULL,
    agent_id VARCHAR(100) NOT NULL,
    service_name VARCHAR(150) NOT NULL,
    service_instance_id VARCHAR(150) NOT NULL,
    status VARCHAR(20) NOT NULL,
    details JSONB,
    event_timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_health_tenant ON health_report(tenant_id);
CREATE INDEX idx_health_service ON health_report(service_name);
CREATE INDEX idx_health_timestamp ON health_report(event_timestamp);
