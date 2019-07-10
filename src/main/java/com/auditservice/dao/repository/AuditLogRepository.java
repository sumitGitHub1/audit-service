package com.auditservice.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auditservice.model.AuditLogEntity;
@Repository
public interface AuditLogRepository extends CrudRepository<AuditLogEntity, Long> {

	AuditLogEntity save(AuditLogEntity event);
}
