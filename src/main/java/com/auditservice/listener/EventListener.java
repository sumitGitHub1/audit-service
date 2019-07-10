package com.auditservice.listener;

import java.io.FileNotFoundException;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.auditservice.converter.XmlToEvent;
import com.auditservice.model.Event;
import com.auditservice.processor.EventProcessor;

@Component
public class EventListener {

	@Autowired
	XmlToEvent xmlToEvent;

	@Autowired
	EventProcessor eventProcessor;

	@JmsListener(destination = "${activemq.queue}", containerFactory="jmsFactory")
	public void receiveMessage(final Message eventMessage) {
		String messageData = null;
		System.out.println("Received message " + eventMessage);
		if (eventMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) eventMessage;
			try {
				messageData = textMessage.getText();
				Event event = xmlToEvent.convertMsgToEvent(messageData);
				eventProcessor.processEvent(event);

			} catch (JMSException | FileNotFoundException | JAXBException e) {
				e.printStackTrace();
			}

		}
	}

}