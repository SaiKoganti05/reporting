package com.amt.reporting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amt.reporting.model.BandDetailsEntity;
import com.amt.reporting.model.EmployeeDetailsEntity;
import com.amt.reporting.model.LeaveAllocationEntity;
import com.amt.reporting.model.LeaveStatusModel;
import com.amt.reporting.repository.BandDetailsRepo;
import com.amt.reporting.repository.EmployeeDetailsRepository;
import com.amt.reporting.repository.LeaveAllocationRepo;

@Service
public class EmployeeDetailsServiceImpl {
	
	@Autowired
	EmployeeDetailsRepository empDetailsRepo;
	
	@Autowired
	BandDetailsRepo bandDetailsRepo;
	
	@Autowired
	LeaveAllocationRepo leaveAllocationRepo;
	
	public EmployeeDetailsEntity getEmployeeById(String empId) {
		return empDetailsRepo.findById(Integer.valueOf(empId)).orElse(null);
	}
	
	public List<EmployeeDetailsEntity> getEmployees() {
		return empDetailsRepo.findAll();
	}
	
	public LeaveStatusModel getLeaveStatusInfo(String empId) {
		LeaveStatusModel leaveStatusModel = new LeaveStatusModel();
		EmployeeDetailsEntity empDetails = empDetailsRepo.findById(Integer.valueOf(empId)).orElse(null);
		if (empDetails!=null) {
			leaveStatusModel.setEmail(empDetails.getEmail());
			leaveStatusModel.setEmployeeName(empDetails.getName());
			leaveStatusModel.setDesignation(empDetails.getDesignation());
			leaveStatusModel.setMobileNumber(empDetails.getMobile_no());
			BandDetailsEntity bandDetails = bandDetailsRepo.findById(empDetails.getBand_Id()).orElse(null);
			if (bandDetails!=null && null!=bandDetails.getBand_id()) {
				leaveStatusModel.setBand(bandDetails.getBand_name());
				List<LeaveAllocationEntity> leaveAllocationEntities = leaveAllocationRepo.findByBandId(bandDetails.getBand_id());
			}
		}
		
		return null;
		
	}

}
