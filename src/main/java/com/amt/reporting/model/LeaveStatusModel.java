package com.amt.reporting.model;

import java.util.Map;

public class LeaveStatusModel {
	
	private String employeeName;
	
	private String designation;
	
	private String email;
	
	private String mobileNumber;
	
	private String band;
	
	private Map<String,Integer> leaveType;
	
	private int entitled;
	
	private int applied;
	
	private int granted;
	
	private int balance;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public Map<String,Integer> getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(Map<String,Integer> leaveType) {
		this.leaveType = leaveType;
	}

	public int getEntitled() {
		return entitled;
	}

	public void setEntitled(int entitled) {
		this.entitled = entitled;
	}

	public int getApplied() {
		return applied;
	}

	public void setApplied(int applied) {
		this.applied = applied;
	}

	public int getGranted() {
		return granted;
	}

	public void setGranted(int granted) {
		this.granted = granted;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
}
