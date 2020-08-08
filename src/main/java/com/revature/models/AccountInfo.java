package com.revature.models;

import java.util.Date;
import java.util.UUID;

public class AccountInfo {
	
	private UUID id;
	
	private BankInfo bankInfo;
	private String accountStatus;
	private String accountType;
	private Double accountBalance;
	private Date createdDateTime;

}
