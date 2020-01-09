package com.shreeya.task1.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Customer")
public class Customer {
	
	@Id
	private String id;
	private String name;
	private String address;
	private String membershipId;
	
	public Customer() {
		super();
	}
	
	public Customer(String id, String name, String address, String membershipId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.membershipId = membershipId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", membershipId=" + membershipId
				+ "]";
	}

}