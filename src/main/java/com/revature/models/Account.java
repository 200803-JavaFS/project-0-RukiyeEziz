package com.revature.models;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable{	
	private static final long serialVersionUID = 1L;	
	
	// account_id, account_name, account_type, balance, 
	// status, customer_id_fk, internal_memo, created_date_time
	private Long accountId;			//PK
	private String accountName;
	private String accountType; 	// checking , saving
	private double accountBalance;
	private String status; 			// approved, denied, pending
	private int customerId;			// FK
	private String internalMemo; 	// this is for internally used by employee and admin
	private String createdDateTime;
	
	public Account() {
		super();
	}

	public Account(
			Long accountId, 
			String accountName, 
			String accountType, 
			double accountBalance, 
			String status,
			int customerId, 
			String internalMemo, 
			String createdDateTime) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.status = status;
		this.customerId = customerId;
		this.internalMemo = internalMemo;
		this.createdDateTime = createdDateTime;
	}
	
	public Account(String accountName, String accountType, double accountBalance, String status, int customerId,
			String internalMemo, String createdDateTime) {
		super();
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.status = status;
		this.customerId = customerId;
		this.internalMemo = internalMemo;
		this.createdDateTime = createdDateTime;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getInternalMemo() {
		return internalMemo;
	}

	public void setInternalMemo(String internalMemo) {
		this.internalMemo = internalMemo;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((createdDateTime == null) ? 0 : createdDateTime.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((internalMemo == null) ? 0 : internalMemo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (createdDateTime == null) {
			if (other.createdDateTime != null)
				return false;
		} else if (!createdDateTime.equals(other.createdDateTime))
			return false;
		if (customerId != other.customerId)
			return false;
		if (internalMemo == null) {
			if (other.internalMemo != null)
				return false;
		} else if (!internalMemo.equals(other.internalMemo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", status=" + status + ", customerId=" + customerId
				+ ", internalMemo=" + internalMemo + ", createdDateTime=" + createdDateTime + "]";
	}

}
