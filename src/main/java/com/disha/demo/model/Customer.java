package com.disha.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerkey;
	
	@Column(nullable = false, unique = true)
	private long customerId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String addressLine1;
	
	private String addressLine2;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private long zipCode;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false, unique = true)
	private String phoneNo;
	
	@Column(nullable = false, unique = true)
	private String emailId;
	
	@Column(nullable = false)
	private String status;

	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Order> order; 
	
	/*
	public List<Order> getOd() {
		return order;
	}
	 */
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Rewards> reward; 
	
	
	/*
	public List<Rewards> getReward() {
		return reward;
	}
	*/



	public void setReward(List<Rewards> reward) {
		this.reward = reward;
	}




	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
	
	
	public Customer() {
		super();
	}

	public Customer(int customerkey, long customerId, String firstName, String lastName, String addressLine1,
			String addressLine2, String city, String state, long zipCode, String country, String phoneNo,
			String emailId, String status) {
		super();
		this.customerkey = customerkey;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.status = status;
	}

	public int getCustomerkey() {
		return customerkey;
	}

	public void setCustomerkey(int customerkey) {
		this.customerkey = customerkey;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Customer [customerkey=" + customerkey + ", customerId=" + customerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + ", phoneNo="
				+ phoneNo + ", emailId=" + emailId + ", status=" + status + "]";
	}

	
	
	
}
