package com.relx.microservice.customer.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.relx.microservice.customer.dao.CustomerJPARepository;
import com.relx.microservice.customer.entity.Customer;
import com.relx.microservice.customer.event.CustomerEvent;
	@Service
	public class StreamConsumer {
		@Autowired
		CustomerJPARepository customerJPARepository;
	    @KafkaListener(topics = "customer-new", groupId = "customergroup")
	    public void consume(CustomerEvent customerEvent) {
	        Customer customer = new Customer(customerEvent.getId(), customerEvent.getFirst_name(), customerEvent.getLast_name());
	        customerJPARepository.save(customer);
	    }
	}