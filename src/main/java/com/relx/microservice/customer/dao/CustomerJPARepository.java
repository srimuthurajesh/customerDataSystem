
package com.relx.microservice.customer.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.relx.microservice.customer.entity.Customer;

public interface CustomerJPARepository extends JpaRepository<Customer, Long> {
	List<Customer> findByFirstNameIgnoreCase(String firstName);

	List<Customer> findByLastNameIgnoreCase(String secoundName);
}
