package com.amt.reporting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amt.reporting.model.EmployeeDetailsEntity;
import com.amt.reporting.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsServiceImpl {
	
	@Autowired
	EmployeeDetailsRepository empDetailsRepo;
	
	public EmployeeDetailsEntity getEmployeeById(String empId) {
		return empDetailsRepo.findById(Integer.valueOf(empId)).orElse(null);
	}
	
	public List<EmployeeDetailsEntity> getEmployees() {
		return empDetailsRepo.findAll();
	}

}
