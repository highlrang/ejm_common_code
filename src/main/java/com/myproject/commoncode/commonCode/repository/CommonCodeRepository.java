package com.myproject.commoncode.commonCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.commoncode.commonCode.domain.CommonCodeEntity;

public interface CommonCodeRepository extends JpaRepository<CommonCodeEntity, Long>{
    
}
