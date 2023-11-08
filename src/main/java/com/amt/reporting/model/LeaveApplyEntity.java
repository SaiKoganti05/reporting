package com.amt.reporting.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_leave_apply")
public class LeaveApplyEntity {
	
	@Id
	@GeneratedValue
	private int leave_apply_id;
	
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "leave_id")
	private int leaveId;
	
	private Date applied_on;
	
	private String reason;
	
	private String status;

	public int getLeave_apply_id() {
		return leave_apply_id;
	}

	public void setLeave_apply_id(int leave_apply_id) {
		this.leave_apply_id = leave_apply_id;
	}

	public int getEmp_id() {
		return empId;
	}

	public void setEmp_id(int emp_id) {
		this.empId = emp_id;
	}

	public int getLeave_id() {
		return leaveId;
	}

	public void setLeave_id(int leave_id) {
		this.leaveId = leave_id;
	}

	public Date getApplied_on() {
		return applied_on;
	}

	public void setApplied_on(Date applied_on) {
		this.applied_on = applied_on;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
