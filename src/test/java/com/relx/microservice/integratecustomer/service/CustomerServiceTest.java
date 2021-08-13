package com.relx.microservice.integratecustomer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.relx.microservice.customer.dao.CustomerJPARepository;
import com.relx.microservice.customer.entity.Customer;
import com.relx.microservice.customer.service.CustomerService;
import com.relx.microservice.customer.service.CustomerServiceImpl;

import org.junit.Ignore;

@Ignore
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CustomerServiceImpl.class)
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerJPARepository customerDao;

	@BeforeEach
	void init() {

	}

	@Test
	public void getByFirstName() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(1, "testFirstName", "testLastName"));

		Mockito.when(customerDao.findAll()).thenReturn(customerList);
		assertEquals(customerList, customerService.getByFirstName("testFirstName"));
	}

	@Test
	public void getByLastName() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer(1, "testFirstName", "testLastName"));

		Mockito.when(customerDao.findAll()).thenReturn(customerList);
		assertEquals(customerList, customerService.getByLastName("testLastName"));
	}

}