package com.disha.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rewards implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rewardsKey;
	
	@Column(nullable=false,unique=true)
	private long rewardsId;
	
	/*
	@OneToOne(targetEntity=Order.class,cascade=CascadeType.ALL)
	@JoinColumn(name="orderNo",referencedColumnName="orderNo")
	private Order order;
	*/
	
	@Column(nullable=false)
	private long orderNo;
	
	
	
	@ManyToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName="customerId")
	private Customer customer;
	
	@Column(nullable=false)
	private int rewardsEarned;
	
	@Column(nullable=false)
	private int rewardsRedeemed;
	
	@Column(nullable=false)
	private int rewardsBalance;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date rewardsDate = new Date(System.currentTimeMillis());

	
	

	public int getRewardsKey() {
		return rewardsKey;
	}


	public void setRewardsKey(int rewardsKey) {
		this.rewardsKey = rewardsKey;
	}


	public long getRewardsId() {
		return rewardsId;
	}


	public void setRewardsId(long rewardsId) {
		this.rewardsId = rewardsId;
	}
	

/*
	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
*/

	public long getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public int getRewardsEarned() {
		return rewardsEarned;
	}


	public void setRewardsEarned(int rewardsEarned) {
		this.rewardsEarned = rewardsEarned;
	}


	public int getRewardsRedeemed() {
		return rewardsRedeemed;
	}


	public void setRewardsRedeemed(int rewardsRedeemed) {
		this.rewardsRedeemed = rewardsRedeemed;
	}


	public int getRewardsBalance() {
		return rewardsBalance;
	}


	public void setRewardsBalance(int rewardsBalance) {
		this.rewardsBalance = rewardsBalance;
	}


	public Date getRewardsDate() {
		return rewardsDate;
	}


	public void setRewardsDate(Date rewardsDate) {
		this.rewardsDate = rewardsDate;
	}


	public Rewards() {
		super();
	}


	public Rewards(int rewardsKey, long rewardsId, long orderNo, Customer customer, int rewardsEarned,
			int rewardsRedeemed, int rewardsBalance, Date rewardsDate) {
		super();
		this.rewardsKey = rewardsKey;
		this.rewardsId = rewardsId;
		this.orderNo = orderNo;
		this.customer = customer;
		this.rewardsEarned = rewardsEarned;
		this.rewardsRedeemed = rewardsRedeemed;
		this.rewardsBalance = rewardsBalance;
		this.rewardsDate = rewardsDate;
	}


	public Rewards(long rewardsId, long orderNo, Customer customer, int rewardsEarned, int rewardsRedeemed,
			int rewardsBalance, Date rewardsDate) {
		super();
		this.rewardsId = rewardsId;
		this.orderNo = orderNo;
		this.customer = customer;
		this.rewardsEarned = rewardsEarned;
		this.rewardsRedeemed = rewardsRedeemed;
		this.rewardsBalance = rewardsBalance;
		this.rewardsDate = rewardsDate;
	}


	@Override
	public String toString() {
		return "Rewards [rewardsKey=" + rewardsKey + ", rewardsId=" + rewardsId + ", orderNo=" + orderNo + ", customer="
				+ customer + ", rewardsEarned=" + rewardsEarned + ", rewardsRedeemed=" + rewardsRedeemed
				+ ", rewardsBalance=" + rewardsBalance + ", rewardsDate=" + rewardsDate + "]";
	}

}
