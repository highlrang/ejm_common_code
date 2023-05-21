package com.myproject.generalapi.commonCode.repository;

import static com.myproject.generalapi.commonCode.domain.QCommonCodeDetailEntity.*;
import static com.myproject.generalapi.commonCode.domain.QCommonCodeEntity.*;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.myproject.generalapi.commonCode.dto.CommonCodeDetailResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;


public class CommonCodeDetailQueryRepositoryImpl implements CommonCodeDetailQueryRepository{

    private EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;

    public CommonCodeDetailQueryRepositoryImpl(
        EntityManager entityManager,
        JPAQueryFactory jpaQueryFactory
    ){
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Transactional
    public long deleteAllByCommonCodeId(long commonCodeId) {
        
        long execute = jpaQueryFactory.update(commonCodeDetailEntity)
            .set(commonCodeDetailEntity.deleteYn, "Y")
            .where(commonCodeDetailEntity.commonCodeId.eq(commonCodeId))
            .execute();
        
        entityManager.flush();

        return execute;
    }

    public CommonCodeDetailResponseDto findByCommonCodeDetailId(long commonCodeDetailId) {
        
        return jpaQueryFactory.select(
            Projections.constructor(CommonCodeDetailResponseDto.class,
                                    commonCodeDetailEntity.commonCodeDetailId,
                                    commonCodeEntity.commonCodeId,
                                    commonCodeEntity.commonCodeName,
                                    commonCodeDetailEntity.commonCodeDetailName,
                                    commonCodeDetailEntity.commonCodeDetailDisplayName
                                   )
        )
        .from(commonCodeDetailEntity)
        .where(commonCodeDetailEntity.deleteYn.eq("N"))
        .innerJoin(commonCodeEntity)
        .fetchOne();
        
    }
    
}
