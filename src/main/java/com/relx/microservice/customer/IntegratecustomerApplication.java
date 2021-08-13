package com.relx.microservice.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.relx.microservice.customer.dao")
public class IntegratecustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegratecustomerApplication.class, args);
	}
}
