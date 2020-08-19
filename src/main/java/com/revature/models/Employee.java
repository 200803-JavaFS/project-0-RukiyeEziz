package com.revature.models;

import java.io.Serializable;


public class Employee implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	// employee_id, status, user_name_fk
	private int employeeId;
	private String employeeStatus; //employee, admin
	private String employeeUserName;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeStatus, String employeeUserName) {
		super();
		this.employeeId = employeeId;
		this.employeeStatus = employeeStatus;
		this.employeeUserName = employeeUserName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((employeeStatus == null) ? 0 : employeeStatus.hashCode());
		result = prime * result + ((employeeUserName == null) ? 0 : employeeUserName.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeStatus == null) {
			if (other.employeeStatus != null)
				return false;
		} else if (!employeeStatus.equals(other.employeeStatus))
			return false;
		if (employeeUserName == null) {
			if (other.employeeUserName != null)
				return false;
		} else if (!employeeUserName.equals(other.employeeUserName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + "\t, employeeStatus=" + employeeStatus + "\t, employeeUserName="
				+ employeeUserName + "]";
	}
	
	
	
}
