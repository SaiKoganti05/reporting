package com.amt.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amt.reporting.model.EmployeeDetailsEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetailsEntity, Integer> {
	
	
	
	
	

}
