package com.relx.microservice.customer.service;

import java.util.List;

import com.relx.microservice.customer.entity.Customer;

public interface CustomerService {

	List<Customer> getByFirstName(String firstName);

	List<Customer> getByLastName(String lastName);
}
