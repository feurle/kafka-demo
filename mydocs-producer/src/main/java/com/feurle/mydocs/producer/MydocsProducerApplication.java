package com.feurle.mydocs.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MydocsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydocsProducerApplication.class, args);
	}

}
