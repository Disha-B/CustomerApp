package com.disha.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.disha.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query(value="select * from order",nativeQuery=true)
	List<Order> findAllOne();
    
	Order findByOrderNo(long OrderNo);
	
	
	//List<Order> findByCustomerId(long CustomerId);
	
	//@Query("select * from ord WHERE ord.getCustomer().getCustomerId()=:n")
	//List<Order> getCustomerById(@Param("n") long customerId);
}
