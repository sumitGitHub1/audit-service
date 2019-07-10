package com.auditservice.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
	
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v,formatter);
    }

    public String marshal(LocalDateTime v) throws Exception {
        return v.toString();
    }
}

