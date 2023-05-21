package com.myproject.commoncode.commonCode.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.commoncode.commonCode.domain.CommonCodeDetailEntity;
import com.myproject.commoncode.commonCode.dto.CommonCodeDetailDto;

public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetailEntity, Long> {

    Page<CommonCodeDetailEntity> findAll(Pageable pageable);

    Page<CommonCodeDetailEntity> findAllByCommonCodeId(long commonCodeId, Pageable pageable);
}
