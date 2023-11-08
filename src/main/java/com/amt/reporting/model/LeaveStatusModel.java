package com.amt.reporting.model;

import java.util.List;

public class LeaveStatusModel {

	private String employeeName;

	private String designation;

	private String email;

	private String mobileNumber;

	private String band;

	private List<String> leaveType;

	private int entitled;

	private int applied;

	private int granted;

	private int cLEntitled;

	private int cLApplied;

	private int cLGranted;

	private int cLBalance;

	private int mLEntitled;

	private int mLApplied;

	private int mLGranted;

	private int mLBalance;

	private int eLEntitled;

	private int eLApplied;

	private int eLGranted;

	private int eLBalance;

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

	public List<String> getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(List<String> leaveType) {
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

	public int getcLEntitled() {
		return cLEntitled;
	}

	public void setcLEntitled(int cLEntitled) {
		this.cLEntitled = cLEntitled;
	}

	public int getcLApplied() {
		return cLApplied;
	}

	public void setcLApplied(int cLApplied) {
		this.cLApplied = cLApplied;
	}

	public int getcLGranted() {
		return cLGranted;
	}

	public void setcLGranted(int cLGranted) {
		this.cLGranted = cLGranted;
	}

	public int getmLEntitled() {
		return mLEntitled;
	}

	public void setmLEntitled(int mLEntitled) {
		this.mLEntitled = mLEntitled;
	}

	public int getmLApplied() {
		return mLApplied;
	}

	public void setmLApplied(int mLApplied) {
		this.mLApplied = mLApplied;
	}

	public int getmLGranted() {
		return mLGranted;
	}

	public void setmLGranted(int mLGranted) {
		this.mLGranted = mLGranted;
	}

	public int geteLEntitled() {
		return eLEntitled;
	}

	public void seteLEntitled(int eLEntitled) {
		this.eLEntitled = eLEntitled;
	}

	public int geteLApplied() {
		return eLApplied;
	}

	public void seteLApplied(int eLApplied) {
		this.eLApplied = eLApplied;
	}

	public int geteLGranted() {
		return eLGranted;
	}

	public void seteLGranted(int eLGranted) {
		this.eLGranted = eLGranted;
	}

	public int getcLBalance() {
		return cLBalance;
	}

	public void setcLBalance(int cLBalance) {
		this.cLBalance = cLBalance;
	}

	public int getmLBalance() {
		return mLBalance;
	}

	public void setmLBalance(int mLBalance) {
		this.mLBalance = mLBalance;
	}

	public int geteLBalance() {
		return eLBalance;
	}

	public void seteLBalance(int eLBalance) {
		this.eLBalance = eLBalance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
