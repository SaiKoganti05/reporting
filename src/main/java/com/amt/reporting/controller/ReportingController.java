package com.amt.reporting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amt.reporting.model.EmployeeDetailsEntity;
import com.amt.reporting.model.LeaveStatusModel;
import com.amt.reporting.service.EmployeeDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ReportingController {

	@Autowired
	EmployeeDetailsServiceImpl employeeDetailsServiceImpl;

	@GetMapping("/getEmployees")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<EmployeeDetailsEntity>> getEmployee() {
		List<EmployeeDetailsEntity> emps = employeeDetailsServiceImpl.getEmployees();
		if (CollectionUtils.isEmpty(emps)) {
			System.out.println("No emp details found");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<EmployeeDetailsEntity>>(emps, HttpStatus.OK);
		}
	}

	@GetMapping("/getEmployees/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<EmployeeDetailsEntity> getEmployeeById(@PathVariable String id) {
		EmployeeDetailsEntity empDetailsEntity = employeeDetailsServiceImpl.getEmployeeById(id);
		if (empDetailsEntity == null) {
			System.out.println("No emp details found");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<EmployeeDetailsEntity>(empDetailsEntity, HttpStatus.OK);
		}

	}
	
	@GetMapping("/getLeavestatusDetails/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<LeaveStatusModel> getLeaveStatusDetails(@PathVariable String id) {
		return null;
	}

}
