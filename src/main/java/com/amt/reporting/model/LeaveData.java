package com.amt.reporting.model;

public class LeaveData {

	private String leaveType;
	private int applied;
	private int entitled;
	private int granted;
	private int balance;

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getApplied() {
		return applied;
	}

	public void setApplied(int applied) {
		this.applied = applied;
	}

	public int getEntitled() {
		return entitled;
	}

	public void setEntitled(int entitled) {
		this.entitled = entitled;
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
