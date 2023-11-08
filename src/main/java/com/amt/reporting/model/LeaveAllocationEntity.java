package com.amt.reporting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_leave_allocation")
public class LeaveAllocationEntity {
	
	@Id
	@GeneratedValue
	private int allocation_id;
	
	private int leave_id;
	
	@Column(name = "band_id")
	private int bandId;
	
	private int total_leave;

	public int getAllocation_id() {
		return allocation_id;
	}

	public void setAllocation_id(int allocation_id) {
		this.allocation_id = allocation_id;
	}

	public int getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}

	
	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public int getTotal_leave() {
		return total_leave;
	}

	public void setTotal_leave(int total_leave) {
		this.total_leave = total_leave;
	}
	
	

}
