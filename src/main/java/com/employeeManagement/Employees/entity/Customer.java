package com.employeeManagement.Employees.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "cust_details")
public class Customer {

	@Id
	private int customerId;
	private String Name;
	private String Address;
	private String emailId;
	private long contact;
		
	public int getCustomerId() {
		return customerId;
		}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
		}
	public String getName() {
		return Name;
		}
	public void setName(String name) {
		Name = name;
		}
	public String getAddress() {
		return Address;
		}
	public void setAddress(String address) {
		Address = address;
		}
	public String getEmailId() {
		return emailId;
		}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
		}
	public long getContact() {
		return contact;
		}
	public void setContact(long contact) {
		this.contact = contact;
		}
	}


