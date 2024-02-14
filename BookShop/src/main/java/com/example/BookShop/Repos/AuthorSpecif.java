package com.example.BookShop.Repos;

import com.example.BookShop.Models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 this class help us dedict what we will add to prdicates
predicate --> are like where in sql
that help us to search dynamic not for only one attribute
*/

@AllArgsConstructor
public class AuthorSpecif implements Specification<Author> {

    private AuthorSearch search;
    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
        List<Predicate>predicates=new ArrayList<>();
        if (search.getName()!=null &&!search.getName().isEmpty()){
          predicates.add(cb.like(root.get("name"),search.getName()));
        }
        if (search.getEmail()!=null &&!search.getEmail().isEmpty()){
            predicates.add(cb.like(root.get("email"),search.getEmail()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
