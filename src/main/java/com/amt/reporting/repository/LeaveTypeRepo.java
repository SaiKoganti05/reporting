package com.amt.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amt.reporting.model.LeaveTypeEntity;

@Repository
public interface LeaveTypeRepo extends JpaRepository<LeaveTypeEntity, Integer>{

}
