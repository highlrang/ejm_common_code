package com.myproject.generalapi.common.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {
    
    private String deleteYn;
    private String createBy;
    private LocalDateTime createDate;
    private String updateBy;
    private LocalDateTime updateDate;

    @PrePersist
    public void prePersis(){
        this.deleteYn = "N";
        this.createBy = "SYSTEM";
        this.createDate = LocalDateTime.now();
        this.updateBy = "SYSTEM";
        this.updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = LocalDateTime.now();
    }

    public void delete(){
        this.deleteYn = "Y";
    }
}
