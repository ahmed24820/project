package com.example.BookShop.Models;

import com.example.BookShop.Base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
@Schema(name = "Author Entity")
@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author extends BaseEntity<Long>{

    private String name;

//    @Transient
    @Formula("(select count(*) from books book where book.author_id =id)")
    private int count;

    @Email
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private Set<Book> books=new HashSet<>();
}
