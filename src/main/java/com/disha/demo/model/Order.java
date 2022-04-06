package com.disha.demo.model;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderKey;
	
	@Column(nullable=false, unique=true)
	private long orderNo;

	@ManyToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName="customerId")
	private Customer customer;
	
	
	@OneToOne(targetEntity=Rewards.class,cascade=CascadeType.ALL)
	@JoinColumn(name="rewardsId",referencedColumnName="rewardsId")
	private Rewards reward;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date(System.currentTimeMillis());
	
	@Column(nullable=false)
	private String orderStatus;
	
	
	@Column(nullable=false)
	private int totalItems;
	
	@Column(nullable=false)
	private int orderTotal;
	
	@Column(nullable=false)
	private String currency;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedTS = new Date(System.currentTimeMillis());

	
	
	
	
	public int getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(int orderKey) {
		this.orderKey = orderKey;
	}

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

	
	
	
	public Rewards getReward() {
		return reward;
	}

	public void setReward(Rewards reward) {
		this.reward = reward;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public Date getLastModifiedTS() {
		return lastModifiedTS;
	}

	public void setLastModifiedTS(Date lastModifiedTS) {
		this.lastModifiedTS = lastModifiedTS;
	}

	public Order() {
		super();
	}

	
	
	public Order(int orderKey, long orderNo, Customer customer, Date orderDate, String orderStatus, int totalItems,
			int orderTotal, String currency, Date lastModifiedTS) {
		super();
		this.orderKey = orderKey;
		this.orderNo = orderNo;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalItems = totalItems;
		this.orderTotal = orderTotal;
		this.currency = currency;
		this.lastModifiedTS = lastModifiedTS;
	}

	public Order(int orderKey, long orderNo, Date orderDate, String orderStatus, int totalItems, int orderTotal,
			String currency, Date lastModifiedTS) {
		super();
		this.orderKey = orderKey;
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalItems = totalItems;
		this.orderTotal = orderTotal;
		this.currency = currency;
		this.lastModifiedTS = lastModifiedTS;
	}

	@Override
	public String toString() {
		return "Order [orderKey=" + orderKey + ", orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderStatus="
				+ orderStatus + ", totalItems=" + totalItems + ", orderTotal=" + orderTotal + ", currency=" + currency
				+ ", lastModifiedTS=" + lastModifiedTS + "]";
	}

}
