package com.disha.demo.utility;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.disha.demo.model.Rewards;

@Component
public class OrderModel {


	//private int orderKey;
	

	private long orderNo;

	
	private long CustomerId;

	
	private Rewards reward;
	
	private String orderStatus;
	

	private int totalItems;

	private int orderTotal;
	

	private String currency;
	
	
	
	
	public Rewards getReward() {
		return reward;
	}


	public void setReward(Rewards reward) {
		this.reward = reward;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public int getTotalItems() {
		return totalItems;
	}


	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}


	public int getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public long getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}


	public long getCustomerId() {
		return CustomerId;
	}


	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	
}
