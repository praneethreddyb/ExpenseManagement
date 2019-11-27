package com.expense.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppStart extends SpringBootServletInitializer{

private static final Logger log = LogManager.getLogger(AppStart.class);
	
	public static void main(String[] args) {
		log.info("Starting");
        SpringApplication.run(AppStart.class, args);
    }
}
