package com.amt.reporting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amt.reporting.model.LeaveApplyEntity;

@Repository
public interface LeaveApplyRepo extends JpaRepository<LeaveApplyEntity, Integer> {
	
	List<LeaveApplyEntity> findByEmpId(Integer empId);
	

}
