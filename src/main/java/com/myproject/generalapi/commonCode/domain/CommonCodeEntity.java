package com.myproject.generalapi.commonCode.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.myproject.generalapi.common.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO 확인
/*
 * common_code_detail과 일대다 관계
 * common_code_detail이 주인 테이블
 * JPA 연관관계를 추가한다면
 * @OneToMany(mappedBy="commonCode", cascade=CascadeType.PERSIST)
 * private List<CommonCodeDetailEntity> commonCodeDetails = new ArrayList<>();
 */
@Getter
@Entity
@Table(name = "COMMON_CODE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commonCodeId;

    @NotNull
    private String commonCodeName;

    @NotNull
    private String commonCodeDisplayName;

    public void update(String commonCodeName, String commonCodeDisplayName){
        this.commonCodeName = commonCodeName;
        this.commonCodeDisplayName = commonCodeDisplayName;
    }
}
