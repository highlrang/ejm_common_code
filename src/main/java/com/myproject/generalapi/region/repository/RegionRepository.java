package com.myproject.generalapi.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.generalapi.region.domain.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long>{
    
}
