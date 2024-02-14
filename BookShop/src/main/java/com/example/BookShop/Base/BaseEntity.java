package com.example.BookShop.Base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import static jakarta.persistence.GenerationType.IDENTITY;
@MappedSuperclass
@Setter
@Getter
@EntityListeners({AuditingEntityListener.class})
public  abstract class BaseEntity <ID> {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private ID id;

    @CreatedBy
    private String CreatedBy;
    @CreatedDate
    private LocalDate CreatedDate;
    @LastModifiedBy
    private String LastModified;
    @LastModifiedDate
    private LocalDate LastModifiedDate;
}
