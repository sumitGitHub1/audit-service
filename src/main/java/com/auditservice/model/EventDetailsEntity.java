package com.auditservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "events_detail")
public class EventDetailsEntity {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="event_type")
	private String eventType;
	
	@Column(name="event_desc")
	private String eventDesc;

	public long getId() {
		return id;
	}

	public String getEventType() {
		return eventType;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	

}
