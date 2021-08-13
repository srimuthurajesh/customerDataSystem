package com.relx.microservice.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.relx.microservice.customer.entity.Customer;
import com.relx.microservice.customer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private CustomerService customerService;

	@Autowired
	public void setCustomerServicer(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("getByFirstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
		return customerService.getByFirstName(firstName);
	}

	@GetMapping("getByLastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
		return customerService.getByLastName(lastName);
	}

}