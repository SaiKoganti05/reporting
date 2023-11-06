package com.amt.reporting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_employee_dtls")
@Data
public class EmployeeDetailsEntity {
	
	@Id
	@GeneratedValue
	private Integer emp_id;
	
	private String name;
	
	private String address;
	
	private String mobile_no;
	
	private String email;
	
	private String designation;
	
//	@OneToOne
//	@JoinColumn(name = "band_id")
//	private BandDetailsEntity bandDetailsEntity;
	
	private Integer band_Id;

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getBand_Id() {
		return band_Id;
	}

	public void setBand_Id(Integer band_Id) {
		this.band_Id = band_Id;
	}
	
	
	
//	@OneToOne
//	private BandDetailsEntity bandDetailsEntity;
	
	

}
