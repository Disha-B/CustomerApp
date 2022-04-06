package com.disha.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.disha.demo.Repo.CustomerRepository;
import com.disha.demo.Repo.RewardsRepository;
import com.disha.demo.model.Customer;
import com.disha.demo.model.Rewards;

@RestController
public class RewardsController {

	@Autowired
	RewardsRepository repo;
	
	@Autowired
	CustomerRepository crepo;
	
	int sum;
	
	@GetMapping("/rewards/{id}")
	public List<Rewards> getRewardsByCustomerId(@PathVariable("id") long CustomerId) {
		
		//Customer c= crepo.findByCustomerId(CustomerId);
		
		List<Rewards> rewardList = repo.findAll();
		
		/*
		List<Rewards> re=new ArrayList<Rewards>();
		rewardList.forEach(i->{
			if(i.getCustomer().getCustomerId()==CustomerId) {
				re.add(i);
				
			}
		});
		*/
		
		List<Rewards> list = rewardList.stream().filter(i->i.getCustomer().getCustomerId()==CustomerId).collect(Collectors.toList());
		return list;
	}
	
	@GetMapping("/rewards/rewardbalance/{id}")
	public String getRewardsBalance(@PathVariable("id") long customerId) {
		
		 sum=0;
		
		List<Rewards> listReward= repo.findAll();
		
		listReward.forEach(i->{
			if(i.getCustomer().getCustomerId()==customerId) {
				sum=sum+i.getRewardsBalance();
			}
			
		});
		
		return "RewardBalance is " + sum;
	}
}
