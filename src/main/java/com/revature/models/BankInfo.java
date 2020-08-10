package com.revature.models;

import java.util.UUID;

public class BankInfo {
	
	private UUID id;	
	private String branchName;
	private Integer branchCode;
	private Integer routingNumber;
	private Address branchAddress;
	
	public BankInfo(UUID id, 
					String branchName, 
					Integer branchCode, 
					Integer routingNumber, 
					Address branchAddress) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.routingNumber = routingNumber;
		this.branchAddress = branchAddress;
	}	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Integer getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}
	public Integer getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(Integer routingNumber) {
		this.routingNumber = routingNumber;
	}
	public Address getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}
}
