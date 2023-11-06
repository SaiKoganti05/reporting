package com.amt.reporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amt.reporting.model.BandDetailsEntity;

@Repository
public interface BandDetailsRepo extends JpaRepository<BandDetailsEntity, Integer>{

}
