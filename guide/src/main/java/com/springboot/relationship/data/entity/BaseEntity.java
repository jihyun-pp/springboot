package com.springboot.relationship.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    // JPA Auditing Entity field

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt;

//    @CreatedBy
//    @Column(updatable = false)
//    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

//    @LastModifiedBy
//    private String updatedBy;

}
