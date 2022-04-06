package com.disha.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.disha.demo.Repo.CustomerRepository;
import com.disha.demo.exception.ResourceNotFoundException;
import com.disha.demo.model.Customer;

@RestController
public class CustomerController {

		@Autowired
		CustomerRepository repo;
		
		@PostMapping("/customers")
		public Customer addCustomer(@RequestBody Customer customer) {
			
			repo.save(customer);
			return customer;
		}
		
		@GetMapping("/customers")
		public List<Customer> getCustomer(){
			
			return repo.findAll();
		}
		
		
		@GetMapping("/customers/email/{emailid}")
		public Customer getCustomerByEmailId(@PathVariable("emailid") String emailId){
			
			//return this.repo.findByEmailId(emailId).orElseThrow(()->new ResourceNotFoundException("Email Not found"));
			return this.repo.findByEmailId(emailId).orElseThrow(()->new ResourceNotFoundException("Email Not found"));
		
		}
		
		
		@GetMapping("/customers/status/{stat}")
		public List<Customer> getCustomerByStatus(@PathVariable("stat") String status){
			
			return repo.findByStatus(status);
		}

		
		@PutMapping("/customers/{id}")
		public Customer updateCustomer(@RequestBody Customer cus,@PathVariable("id") long customerId){
			
			Customer c=repo.findByCustomerId(customerId);
		
				if(c.getCustomerId()==customerId) 
				{
					c.setFirstName(cus.getFirstName());
					c.setLastName(cus.getLastName());
					c.setAddressLine1(cus.getAddressLine1());
					c.setAddressLine2(cus.getAddressLine2());
					c.setCity(cus.getCity());
					c.setState(cus.getState());
					c.setZipCode(cus.getZipCode());
					c.setCountry(cus.getCountry());
					c.setPhoneNo(cus.getPhoneNo());
					c.setEmailId(cus.getEmailId());
					c.setStatus(cus.getStatus());
				}
				repo.save(c);
				return c;
		
				
			}
		
		
		@DeleteMapping("/customers/{id}")
		public String deleteCustomer(@PathVariable("id") long customerId){
			
			Customer cd = repo.findByCustomerId(customerId);
			
			
			if(cd.getStatus().contentEquals("Inactive"))
			{
			
				//System.out.println("deleted");
				repo.delete(cd);
				return "Deleted";
			}
			else {
				return "Cannot delete active Customer";
			}
			
		}

}
