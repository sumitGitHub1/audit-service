package com.auditservice.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.auditservice.main.AuditServiceApplicationStarter;

import event.generator.EventGenerator;

public class EventToXml {
	public static void main(String[] args) throws Exception {

		EventGenerator eG = new EventGenerator();
		String eventXML = eG.generateEvent("Sumit12", "Login-Module", "login", "additional", "Sumit", "passed",
				LocalDateTime.now(ZoneId.systemDefault()), LocalDateTime.now(ZoneId.systemDefault()));
		System.out.println(eventXML);
		ApplicationContext ctx = SpringApplication.run(
				AuditServiceApplicationStarter.class, args);
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		jms.convertAndSend("event.queue", eventXML);
		
	}
}
