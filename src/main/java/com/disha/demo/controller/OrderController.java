package com.disha.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.disha.demo.Repo.CustomerRepository;
import com.disha.demo.Repo.OrderRepository;
import com.disha.demo.Repo.RewardsRepository;
import com.disha.demo.model.Customer;
import com.disha.demo.model.Order;
import com.disha.demo.model.Rewards;
import com.disha.demo.utility.OrderModel;


@RestController
@RequestMapping("/rest")
public class OrderController {


    @Autowired
	OrderRepository repo;
    
    @Autowired
    CustomerRepository crepo;
    
    @Autowired
    RewardsRepository rrepo;
    
    
	
	public OrderController(OrderRepository repo) {
		super();
		this.repo = repo;
	}
	
	@GetMapping(value="/orders")
	public List<Order> getAll(){
	
		return  repo.findAll();
		
	}
	
	/*
	@GetMapping(value="/orders/update")
	public List<Order> update(){
		
		Customer c = new Customer();
		c.setCustomerId(8888);
		c.setFirstName("modi");
		c.setLastName("ji");
		c.setAddressLine1("op");
		c.setAddressLine2("po");
		c.setCity("surat");
		c.setState("Gujarat");
		c.setZipCode(2377);
		c.setCountry("india");
		c.setPhoneNo("+1 4432123577");
		c.setEmailId("modiji@gmail.com");
		c.setStatus("Active");
		
		Order o= new Order();
		o.setCustomer(c);
		o.setOrderNo(98812);
		
		repo.save(o);
		

		Order or= new Order();
		or.setCustomer(c);
		or.setOrderNo(98814);
		
		repo.save(or);
		
		return repo.findAll();
		
	}
	*/
	
	
	
	@GetMapping("/orders/ph/{id}")
	public List<Order> getOrderByPhone(@PathVariable("id") String ph){
		
		//List<Order> l= odrepo.findByPhoneNo();
		Customer customer = crepo.findByPhoneNo(ph);
		
		/*
		//1st method
		List<Order> od= repo.findAll();
		
		List<Order> g = new ArrayList<Order>();
		
		od.forEach(i->{
			if(i.getCustomer().getCustomerId()==l.getCustomerId() && l.getPhoneNo().contains(ph)) {
				g.add(i);
				
			}
		});	
		return g;
		
		*/
		
		
		//2nd method
		List<Order> orders= repo.findAll();
		
		List<Order> list = orders.stream().filter(i->i.getCustomer().getCustomerId()==customer.getCustomerId()).collect(Collectors.toList());
		
		return list;
		
		
		/*
		//3rd method
		List<Order>o=new ArrayList<Order>();
		List<Order>op= repo.findAll();
		for(Order e:op) {
			if(e.getCustomer().getCustomerId()==l.getCustomerId()) {
				o.add(e);
			}
			
		}
		return o;
		*/
		
		
	}
	
	
	
	
	@PostMapping("/orders")
	public Order addOrder(@RequestBody OrderModel od) {
		
		//repo.save(od);
		
		//Order o= repo.findByOrderNo()
		//o.setOrderNo(od.getOrderNo());
		//o.getCustomer().setCustomerId(od.getCustomerId());
		
		//od.forEach(i->{repo.save(i);});
		
		
		Customer customer =crepo.findByCustomerId(od.getCustomerId());
		//od.getReward().getOrder().getOrderNo();
		//Order or= repo.findByOrderNo(od.getOrderNo());
		
		
		Rewards r = new Rewards();
		r.setRewardsId(od.getReward().getRewardsId());
		//r.setRewards(or);
		r.setOrderNo(od.getOrderNo());
		r.setCustomer(customer);
		r.setRewardsEarned(od.getReward().getRewardsEarned());
		r.setRewardsRedeemed(od.getReward().getRewardsRedeemed());
		//r.setRewardsBalance(od.getReward().getRewardsBalance());
		int i= od.getReward().getRewardsEarned()-od.getReward().getRewardsRedeemed();
		
		r.setRewardsBalance(i);
		
		
		
		
		Order order= new Order();
		order.setOrderNo(od.getOrderNo());
		order.setCustomer(customer);
		order.setReward(r);
		//order.setOrderStatus(od.getOrderStatus());
		order.setOrderStatus("Created");
		order.setTotalItems(od.getTotalItems());
		order.setOrderTotal(od.getOrderTotal());
		order.setCurrency(od.getCurrency());
		
		
		
		repo.save(order);
		return order;
	}
    
	
	@PutMapping("/orders/{id}")
	public Order updateOrder(@RequestBody Order o,@PathVariable("id") long OrderNo) {
		
		Order order = repo.findByOrderNo(OrderNo);
		
		if(order.getOrderNo()==OrderNo) {
			
			order.setOrderStatus(o.getOrderStatus());
			order.setLastModifiedTS(new Date(System.currentTimeMillis()));
		}
		repo.save(order);
		return order;
	}
	
	
	
	
	
	@DeleteMapping("/orders/{id}")
	public String deleteOrder(@PathVariable("id") long orderNo){
	
		Order cd = repo.findByOrderNo(orderNo);
		

		//Date b= cd.getLastModifiedTS();
		
		//Date n= new Date(System.currentTimeMillis());
	
		//LocalDateTime now = LocalDateTime.now();
		
	
		//System.out.println(ChronoUnit.between(b,f);
		
		repo.delete(cd);
		return "Deleted";
		
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrders(@PathVariable("id") long orderNo){
	
		Order order = repo.findByOrderNo(orderNo);
		

		return order;
		
		
	}
	
}
