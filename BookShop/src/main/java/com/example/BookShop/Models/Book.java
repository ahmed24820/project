package com.example.BookShop.Models;

import com.example.BookShop.Base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends BaseEntity<Long> {

    private String name;

    private double price;

    @Formula("(select count(*) from books )")
    private int count;

//    @Formula ( "(SELECT price * 0.25 FROM bookshop.books where id =id)")
  @Transient
    private double discount;

    @JsonBackReference
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;



//    @PostLoad
//     private void CalcDiscount(){
//        this.setDiscount(price * .25);
//    }


}
