package com.auditservice.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.auditservice.model.EventDetailsEntity;

public interface EventDetailsRepository extends CrudRepository<EventDetailsEntity, Long> {

	@Query("SELECT event FROM EventDetailsEntity event WHERE event.eventType = :eventType")
	EventDetailsEntity findEventByType(@Param("eventType") String eventType);
	
	
	
}

