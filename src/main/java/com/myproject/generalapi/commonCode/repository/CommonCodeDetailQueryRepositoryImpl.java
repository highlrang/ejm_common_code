package com.myproject.generalapi.commonCode.repository;

import static com.myproject.generalapi.commonCode.domain.QCommonCodeDetailEntity.*;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

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
    
}
