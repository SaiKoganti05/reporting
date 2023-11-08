package com.amt.reporting.model;

import java.util.List;

public class LeaveStatusDetails {
	
	private String employeeName;

	private String designation;

	private String email;

	private String mobileNumber;

	private String band;
	
	private List<LeaveData> leaveData;

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

	public List<LeaveData> getLeaveData() {
		return leaveData;
	}

	public void setLeaveData(List<LeaveData> leaveData) {
		this.leaveData = leaveData;
	}

	
}
