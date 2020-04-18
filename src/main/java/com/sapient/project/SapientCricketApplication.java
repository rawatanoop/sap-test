package com.sapient.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SapientCricketApplication {
	private static final Logger log = LoggerFactory.getLogger(SapientCricketApplication.class);
	public static void main(String[] args) {
		log.info("Application Starting ");
		SpringApplication.run(SapientCricketApplication.class, args);
		log.info("Application Started ");
	}

}
