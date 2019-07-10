package com.auditservice.converter;

import java.io.FileNotFoundException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.auditservice.jaxb.Event;



@Component
public class XmlToEvent {	 
	   public Event convertMsgToEvent(String eventMessage) throws JAXBException, FileNotFoundException {
	        JAXBContext jaxbContext = JAXBContext.newInstance(Event.class);
	        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	        Event event = (Event) unmarshaller.unmarshal(new StringReader(eventMessage));
	        return event;
	       
	    }

}
