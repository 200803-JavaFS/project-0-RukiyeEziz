package com.revature.models;

import java.util.Date;
import java.util.UUID;

public class Account {
	
	private UUID id;	
	private Long accountNumber;
	private BankInfo bankInfo;
	private String accountType;
	private Double accountBalance;
	private Date createdDateTime;
	private Date updatedDateTime;
	private Boolean approved;
	
	public Account(UUID id, 
					Long accountNumber,
					BankInfo bankInfo, 
					String accountType, 
					Double accountBalance,
					Date createdDateTime,
					Date updatedDateTime,
					Boolean approved) 
	{
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.bankInfo = bankInfo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
		this.approved = approved;
	}
	public UUID getId() {
		return id;
	}	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public BankInfo getBankInfo() {
		return bankInfo;
	}
	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}	
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", bankInfo=" + bankInfo + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + ", createdDateTime=" + createdDateTime
				+ ", updatedDateTime=" + updatedDateTime + ", approved=" + approved + "]";
	}
	
}
