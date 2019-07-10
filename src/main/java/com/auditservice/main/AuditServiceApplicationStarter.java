package com.auditservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@ComponentScan("com.auditservice")
@EnableJpaRepositories("com.auditservice")
@EntityScan("com.auditservice")
public class AuditServiceApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(AuditServiceApplicationStarter.class, args);
    }

}