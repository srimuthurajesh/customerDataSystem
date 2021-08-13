package com.relx.microservice.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.relx.microservice.customer.dao.CustomerJPARepository;
import com.relx.microservice.customer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerJPARepository customerJPARepository;

	@Override
	public List<Customer> getByFirstName(String firstName) {
		return customerJPARepository.findByFirstNameIgnoreCase(firstName);
	}

	@Override
	public List<Customer> getByLastName(String lastName) {
		return customerJPARepository.findByLastNameIgnoreCase(lastName);
	}

}