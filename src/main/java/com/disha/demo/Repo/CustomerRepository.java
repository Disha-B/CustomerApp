package com.disha.demo.Repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disha.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmailId(String emailId);

	List<Customer> findByStatus(String status);

	Customer findByCustomerId(long CustomerId);

		
	Customer findByPhoneNo(String phoneNo);
	
}
