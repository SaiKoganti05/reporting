package com.amt.reporting.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amt.reporting.model.BandDetailsEntity;
import com.amt.reporting.model.EmployeeDetailsEntity;
import com.amt.reporting.model.LeaveAllocationEntity;
import com.amt.reporting.model.LeaveApplyEntity;
import com.amt.reporting.model.LeaveData;
import com.amt.reporting.model.LeaveStatusDetails;
import com.amt.reporting.model.LeaveStatusModel;
import com.amt.reporting.model.LeaveType;
import com.amt.reporting.model.LeaveTypeEntity;
import com.amt.reporting.repository.BandDetailsRepo;
import com.amt.reporting.repository.EmployeeDetailsRepository;
import com.amt.reporting.repository.LeaveAllocationRepo;
import com.amt.reporting.repository.LeaveApplyRepo;
import com.amt.reporting.repository.LeaveTypeRepo;

@Service
public class EmployeeDetailsServiceImpl {

	@Autowired
	EmployeeDetailsRepository empDetailsRepo;

	@Autowired
	BandDetailsRepo bandDetailsRepo;

	@Autowired
	LeaveAllocationRepo leaveAllocationRepo;

	@Autowired
	LeaveTypeRepo leaveTypeRepo;

	@Autowired
	LeaveApplyRepo leaveApplyRepo;

	public EmployeeDetailsEntity getEmployeeById(String empId) {
		return empDetailsRepo.findById(Integer.valueOf(empId)).orElse(null);
	}

	public List<EmployeeDetailsEntity> getEmployees() {
		return empDetailsRepo.findAll();
	}

	public LeaveStatusModel getLeaveStatusInfo(String empId) {
		LeaveStatusModel leaveStatusModel = new LeaveStatusModel();
		Map<Integer, String> cacheLeaveType = new HashMap<>();
		List<LeaveTypeEntity> leaveEntities = leaveTypeRepo.findAll();
		leaveEntities.forEach(leaveEntity -> {
			cacheLeaveType.put(leaveEntity.getLeave_id(), leaveEntity.getLeave_type());
		});
		EmployeeDetailsEntity empDetails = empDetailsRepo.findById(Integer.valueOf(empId)).orElse(null);
		if (empDetails != null) {
			leaveStatusModel.setEmail(empDetails.getEmail());
			leaveStatusModel.setEmployeeName(empDetails.getName());
			leaveStatusModel.setDesignation(empDetails.getDesignation());
			leaveStatusModel.setMobileNumber(empDetails.getMobile_no());
			BandDetailsEntity bandDetails = bandDetailsRepo.findById(empDetails.getBand_Id()).orElse(null);
			if (bandDetails != null && null != bandDetails.getBand_id()) {
				leaveStatusModel.setBand(bandDetails.getBand_name());
				List<LeaveAllocationEntity> leaveAllocationEntities = leaveAllocationRepo
						.findByBandId(bandDetails.getBand_id());
				Map<String, Integer> leaveEntitledMap = new HashMap<>();
				leaveAllocationEntities.forEach(leaveAllocationEntity -> {
					leaveEntitledMap.put(cacheLeaveType.get(leaveAllocationEntity.getLeave_id()),
							leaveAllocationEntity.getTotal_leave());
				});

				udpateLeaveEntitled(leaveEntitledMap, leaveStatusModel);
				leaveStatusModel.setLeaveType(cacheLeaveType.values().stream().collect(Collectors.toList()));
			}
			
			  List<LeaveApplyEntity> leaveApplyEntities = leaveApplyRepo.findByEmpId(Integer.valueOf(empId));
			  Map<String,Integer> appliedMap = new HashMap<>();
			  Map<String,Integer> approvedMap = new HashMap<>();
			  cacheLeaveType.forEach((leaveId,leaveType)->{
				  int appliedCount = leaveApplyEntities.stream().filter(leaveApplyEntity->leaveId==leaveApplyEntity.getLeave_id()).collect(Collectors.toList()).size();
				  appliedMap.put(leaveType, appliedCount);
				  int approvedCount = leaveApplyEntities.stream().filter(leaveApplyEntity->leaveId==leaveApplyEntity.getLeave_id() && "Approved".equalsIgnoreCase(leaveApplyEntity.getStatus())).collect(Collectors.toList()).size();
				  approvedMap.put(leaveType, approvedCount);
			  });
			  udpateLeaveApplied(appliedMap,leaveStatusModel);
			  updateLeaveApproved(approvedMap,leaveStatusModel);
			  
			 leaveStatusModel.setcLBalance(leaveStatusModel.getcLEntitled()-leaveStatusModel.getcLGranted());
			 leaveStatusModel.setmLBalance(leaveStatusModel.getmLEntitled()-leaveStatusModel.getmLGranted());
			 leaveStatusModel.seteLBalance(leaveStatusModel.geteLEntitled()-leaveStatusModel.geteLGranted());
			 leaveStatusModel.setBalance(leaveStatusModel.getcLBalance()+leaveStatusModel.geteLBalance()+leaveStatusModel.getmLBalance());
			
			 leaveStatusModel.setEntitled(leaveStatusModel.getcLEntitled()+leaveStatusModel.geteLEntitled()+leaveStatusModel.getmLEntitled());
			 leaveStatusModel.setApplied(leaveStatusModel.getcLApplied()+leaveStatusModel.geteLApplied()+leaveStatusModel.getmLApplied());
			 leaveStatusModel.setGranted(leaveStatusModel.getcLGranted()+leaveStatusModel.geteLGranted()+leaveStatusModel.getmLGranted());
			 
		}

		return leaveStatusModel;

	}

	
	public LeaveStatusDetails convert(LeaveStatusModel leaveStatusModel) {
		LeaveStatusDetails leaveStatusDetails = new LeaveStatusDetails();
		leaveStatusDetails.setEmployeeName(leaveStatusModel.getEmployeeName());
		leaveStatusDetails.setDesignation(leaveStatusModel.getDesignation());
		leaveStatusDetails.setBand(leaveStatusModel.getBand());
		leaveStatusDetails.setEmail(leaveStatusModel.getEmail());
		leaveStatusDetails.setMobileNumber(leaveStatusModel.getMobileNumber());
		leaveStatusDetails.setLeaveData(new ArrayList<>());
		LeaveData clleaveData = new LeaveData();
		clleaveData.setLeaveType(LeaveType.CL.toString());
		clleaveData.setApplied(leaveStatusModel.getcLApplied());
		clleaveData.setEntitled(leaveStatusModel.getcLEntitled());
		clleaveData.setGranted(leaveStatusModel.getcLGranted());
		clleaveData.setBalance(leaveStatusModel.getcLBalance());
		leaveStatusDetails.getLeaveData().add(clleaveData);
		LeaveData elleaveData = new LeaveData();
		elleaveData.setLeaveType(LeaveType.EL.toString());
		elleaveData.setApplied(leaveStatusModel.geteLApplied());
		elleaveData.setEntitled(leaveStatusModel.geteLEntitled());
		elleaveData.setGranted(leaveStatusModel.geteLGranted());
		elleaveData.setBalance(leaveStatusModel.geteLBalance());
		leaveStatusDetails.getLeaveData().add(elleaveData);
		LeaveData mlleaveData = new LeaveData();
		mlleaveData.setLeaveType(LeaveType.ML.toString());
		mlleaveData.setApplied(leaveStatusModel.getmLApplied());
		mlleaveData.setEntitled(leaveStatusModel.getmLEntitled());
		mlleaveData.setGranted(leaveStatusModel.getmLGranted());
		mlleaveData.setBalance(leaveStatusModel.getmLBalance());
		leaveStatusDetails.getLeaveData().add(mlleaveData);
		LeaveData tlleaveData = new LeaveData();
		tlleaveData.setLeaveType(LeaveType.TOTAL.toString());
		tlleaveData.setApplied(leaveStatusModel.getApplied());
		tlleaveData.setEntitled(leaveStatusModel.getEntitled());
		tlleaveData.setGranted(leaveStatusModel.getGranted());
		tlleaveData.setBalance(leaveStatusModel.getBalance());
		leaveStatusDetails.getLeaveData().add(tlleaveData);
		 
		 return leaveStatusDetails;
	}
	
	private LeaveStatusModel udpateLeaveEntitled(Map<String, Integer> leaveMap, LeaveStatusModel leaveStatusModel) {
		leaveMap.forEach((leaveType, count) -> {
			if (leaveType.equalsIgnoreCase(LeaveType.CL.toString())) {
				leaveStatusModel.setcLEntitled(count);
			} else if (leaveType.equalsIgnoreCase(LeaveType.ML.toString())) {
				leaveStatusModel.setmLEntitled(count);
			} else if (leaveType.equalsIgnoreCase(LeaveType.EL.toString())) {
				leaveStatusModel.seteLEntitled(count);
			}
		});
		return leaveStatusModel;
	}
	
	private LeaveStatusModel udpateLeaveApplied(Map<String, Integer> leaveMap, LeaveStatusModel leaveStatusModel) {
		leaveMap.forEach((leaveType, count) -> {
			if (leaveType.equalsIgnoreCase(LeaveType.CL.toString())) {
				leaveStatusModel.setcLApplied(count);
			} else if (leaveType.equalsIgnoreCase(LeaveType.ML.toString())) {
				leaveStatusModel.setmLApplied(count);
			} else if (leaveType.equalsIgnoreCase(LeaveType.EL.toString())) {
				leaveStatusModel.seteLApplied(count);
			}
		});
		return leaveStatusModel;
	}
	
	private LeaveStatusModel updateLeaveApproved(Map<String, Integer> leaveMap, LeaveStatusModel leaveStatusModel) {
		leaveMap.forEach((leaveType, count) -> {
			if (leaveType.equalsIgnoreCase(LeaveType.CL.toString())) {
				leaveStatusModel.setcLGranted(count);
			} else if (leaveType.equalsIgnoreCase(LeaveType.ML.toString())) {
				leaveStatusModel.setmLGranted(count);
			} else if (leaveType.equalsIgnoreCase(LeaveType.EL.toString())) {
				leaveStatusModel.seteLGranted(count);
			}
		});
		return leaveStatusModel;
	}

}
