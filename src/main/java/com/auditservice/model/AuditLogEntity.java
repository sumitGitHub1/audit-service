package com.auditservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.auditservice.converter.LocalDateTimeConverter;

@Entity
@Table(name = "audit_logs")
public class AuditLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "user_Id")
	private String userId;

	@Column(name = "system_id")
	private String systemId;

	@Column(name = "event_id")
	private long eventId;

	@Column(name = "event_datetime")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime eventDateTime;

	@Column(name = "event_parameters")
	private String eventParameters;

	@Column(name = "event_status")
	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_datetime")
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public LocalDateTime getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(LocalDateTime eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public long getEventId() {
		return eventId;
	}

	public String getEventParameters() {
		return eventParameters;
	}

	public void setEventId(long l) {
		this.eventId = l;
	}

	public void setEventParameters(String eventParameters) {
		this.eventParameters = eventParameters;
	}

	@Override
	public String toString() {
		return "AuditLogEntity [id=" + id + ", userId=" + userId + ", systemId=" + systemId + ", eventId=" + eventId
				+ ", eventDateTime=" + eventDateTime + ", eventParameters=" + eventParameters + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdDateTime=" + createdDateTime + "]";
	}

}
