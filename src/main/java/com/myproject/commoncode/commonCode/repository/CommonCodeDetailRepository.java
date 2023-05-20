package com.myproject.commoncode.commonCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.commoncode.commonCode.domain.CommonCodeDetailEntity;

public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetailEntity, Long> {
    
}
