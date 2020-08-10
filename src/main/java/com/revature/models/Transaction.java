package com.revature.models;

import java.util.Date;
import java.util.UUID;

public class Transaction {
	
	private UUID id;
	private Long fromAccountNumber;
	private Long toAccountNumber;
	private Date txnDateTime;	
	private String txnType;	
	private Double txnAmount;	
	// Deposit, Withdraw, Transfer
	public Transaction(UUID id, 
						Long fromAccountNumber, 
						Long toAccountNumber, 
						Date txnDateTime, 
						String txnType,
						Double txnAmount) {
		super();
		this.id = id;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.txnDateTime = txnDateTime;
		this.txnType = txnType;
		this.txnAmount = txnAmount;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public Date getTxnDateTime() {
		return txnDateTime;
	}
	public void setTxnDateTime(Date txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
}
