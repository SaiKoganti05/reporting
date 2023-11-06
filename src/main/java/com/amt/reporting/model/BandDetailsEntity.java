package com.amt.reporting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_emp_band")
@Data
public class BandDetailsEntity {
	
	@Id
	@GeneratedValue
	private Integer band_id;
	
	private String band_name;

	public Integer getBand_id() {
		return band_id;
	}

	public void setBand_id(Integer band_id) {
		this.band_id = band_id;
	}

	public String getBand_name() {
		return band_name;
	}

	public void setBand_name(String band_name) {
		this.band_name = band_name;
	}
	
	

}
