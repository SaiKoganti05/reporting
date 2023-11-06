package com.amt.reporting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amt.reporting.model.LeaveAllocationEntity;

@Repository
public interface LeaveAllocationRepo extends JpaRepository<LeaveAllocationEntity, Integer>{
	
	List<LeaveAllocationEntity> findByBandId(int band_id);

}
