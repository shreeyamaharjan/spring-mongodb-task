package com.shreeya.task1.membership;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Membership")
public class Membership {

	@Id
	public String membershipId;
	private String membershipType;
	private int annualRate;
	

	public Membership() {
		super();
	}
	
	public String getMembershipId() {
		return membershipId;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public int getAnnualRate() {
		return annualRate;
	}
	public void setAnnualRate(int annualRate) {
		this.annualRate = annualRate;
	}
	
	@Override
	public String toString() {
		return "Membership [membershipId=" + membershipId + ", membershipType=" + membershipType + ", annualRate="
				+ annualRate + "]";
	}
}
