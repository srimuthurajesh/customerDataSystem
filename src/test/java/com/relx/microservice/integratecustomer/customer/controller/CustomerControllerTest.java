package com.relx.microservice.integratecustomer.customer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.relx.microservice.customer.entity.Customer;
import com.relx.microservice.customer.service.CustomerService;

import org.junit.Ignore;

@Ignore
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	CustomerService customerDao;

	@Test
	public void getCustomerbyFirstNameTest() throws Exception {
		Customer customer = new Customer(1, "testFirstName", "testLastName");
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);

		RequestBuilder request = MockMvcRequestBuilders.get("/customers");
		MvcResult result = mvc.perform(request).andReturn();
		Mockito.when(customerDao.getByFirstName("testFirstName")).thenReturn(customerList);
		assertEquals(200, result.getResponse().getStatus());

	}

	@Test
	public void getCustomerbyLastNameTest() throws Exception {
		Customer customer = new Customer(2, "testFirstName", "testLastName");
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);

		RequestBuilder request = MockMvcRequestBuilders.get("/customers");
		MvcResult result = mvc.perform(request).andReturn();
		Mockito.when(customerDao.getByLastName("testLastName")).thenReturn(customerList);
		assertEquals(200, result.getResponse().getStatus());

	}

}
