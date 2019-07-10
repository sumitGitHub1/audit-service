package com.auditservice.model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.auditservice.converter.LocalDateTimeAdapter;

@XmlRootElement(name = "event")
public class Event {

	@XmlElement(name = "userid")
	private String userId;
	@XmlElement(name = "systemid")
	private String systemId;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "eventdatetime")
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	private LocalDateTime eventDateTime;
	@XmlElement(name = "additionalinfo")
	private String additionalInfo;
	@XmlElement(name = "status")
	private String status;
	@XmlElement(name = "createdby")
	private String createdBy;
	@XmlElement(name = "createddatetime")
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	private LocalDateTime createdDateTime;

	public Event() {
	}

	public Event(String userId, String systemId, String name, LocalDateTime eventDateTime, String additionalInfo,
			String status, String createdBy, LocalDateTime createdDateTime) {
		super();
		this.userId = userId;
		this.systemId = systemId;
		this.name = name;
		this.eventDateTime = eventDateTime;
		this.additionalInfo = additionalInfo;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDateTime = createdDateTime;
	}

	@Override
	public String toString() {
		return "Event [userId=" + userId + ", systemId=" + systemId + ", name=" + name + ", eventDateTime="
				+ eventDateTime + ", additionalInfo=" + additionalInfo + ", status=" + status + ", createdBy="
				+ createdBy + ", createdDateTime=" + createdDateTime + "]";
	}

	public String getUserId() {
		return userId;
	}

	public String getSystemId() {
		return systemId;
	}

	public LocalDateTime getEventDateTime() {
		return eventDateTime;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getStatus() {
		return status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public String getName() {
		return name;
	}

}
