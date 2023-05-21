package com.myproject.generalapi.commonCode.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.generalapi.commonCode.domain.CommonCodeDetailEntity;

public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetailEntity, Long> {

    Page<CommonCodeDetailEntity> findAll(Pageable pageable);

    Page<CommonCodeDetailEntity> findAllByCommonCodeId(long commonCodeId, Pageable pageable);
}
