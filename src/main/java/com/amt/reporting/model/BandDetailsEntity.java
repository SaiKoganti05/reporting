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
	

}
