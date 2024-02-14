package com.example.BookShop.Repos;

import com.example.BookShop.Base.BaseRepo;
import com.example.BookShop.Models.Author;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends BaseRepo<Author,Long> , JpaSpecificationExecutor<Author> {
}
