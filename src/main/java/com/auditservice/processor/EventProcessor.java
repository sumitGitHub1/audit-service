package com.auditservice.processor;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auditservice.dao.repository.AuditLogRepository;
import com.auditservice.dao.repository.EventDetailsRepository;
import com.auditservice.jaxb.Event;
import com.auditservice.model.AuditLogEntity;
import com.auditservice.model.EventDetailsEntity;

@Component
public class EventProcessor {

	@Autowired
	AuditLogRepository eventRepository;

	@Autowired
	EventDetailsRepository eventDetailsRepository;

	Function<Event, AuditLogEntity> eventToEntity = new Function<Event, AuditLogEntity>() {

		public AuditLogEntity apply(Event t) {
			AuditLogEntity entity = new AuditLogEntity();
 
			entity.setUserId(t.getUserid());
			entity.setSystemId(t.getSystemid());

			EventDetailsEntity ed = getIdByEvent(t.getName());
			entity.setEventId(ed.getId());

			entity.setEventParameters(t.getAdditionalinfo());
			entity.setStatus(t.getStatus());

			entity.setEventDateTime(t.getEventdatetime());
			entity.setCreatedBy(t.getCreatedby());
			entity.setCreatedDateTime(t.getCreateddatetime());
			return entity;
		}

		private EventDetailsEntity getIdByEvent(String name) {
			return eventDetailsRepository.findEventByType(name);

		}
	};

	public void processEvent(Event event) {
		eventRepository.save(eventToEntity.apply(event));
		System.out.println(event);
	}
}
