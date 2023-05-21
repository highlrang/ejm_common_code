package com.myproject.generalapi.region.repository;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.myproject.generalapi.region.domain.QRegionEntity.*;

import java.util.List;

import com.myproject.generalapi.common.dto.PageDto;
import com.myproject.generalapi.region.dto.RegionPageDto;
import com.myproject.generalapi.region.dto.RegionRequestDto;
import com.myproject.generalapi.region.dto.RegionResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionQueryRepository {

    private final JPAQueryFactory jpaQueryFactory; 
    
    public RegionPageDto searchAll(RegionRequestDto regionRequestDto, Pageable pageable) {
        
        long regionCount = countAll();

        JPAQuery<RegionResponseDto> queryBuilder = jpaQueryFactory.select(
            Projections.constructor(RegionResponseDto.class, 
                regionEntity.regionId,
                regionEntity.regionName,
                regionEntity.regionDepth,
                regionEntity.regionParentId
            )
        )
        .from(regionEntity)
        .where(regionEntity.deleteYn.eq("N"));

        if(regionRequestDto != null){
            queryBuilder = queryBuilder.where(
                containsRegionName(regionRequestDto.getRegionName()),
                eqRegionParentId(regionRequestDto.getRegionParentId()),
                lowerRegionDepth(regionRequestDto.getRegionDepth())

            );
        }

        List<RegionResponseDto> regionDtos = queryBuilder.offset(pageable.getOffset())
                                                .limit(pageable.getPageSize())
                                                .fetch();

        PageImpl<RegionResponseDto> regionPages = new PageImpl<RegionResponseDto>(regionDtos, pageable, regionCount);

        PageDto pages = new PageDto(regionCount, regionPages.getTotalPages(), pageable.getPageNumber(), pageable.getPageSize());
        return new RegionPageDto(regionDtos, pages);
    }

    public long countAll() {
        return jpaQueryFactory.select(regionEntity.count())
                        .from(regionEntity)
                        .fetchOne();
    
    }

    private BooleanExpression containsRegionName(String regionName){

        if(regionName == null) return null;
        return regionEntity.regionName.contains(regionName);
    }

    private BooleanExpression eqRegionParentId(Long regionParentId){
        
        if (regionParentId == null) return null;
        return regionEntity.regionParentId.eq(regionParentId);
    }

    private BooleanExpression lowerRegionDepth(Integer regionDepth){

        if (regionDepth == null) return null;
        return regionEntity.regionDepth.goe(regionDepth);
    }
    
}
