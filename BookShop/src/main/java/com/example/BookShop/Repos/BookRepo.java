package com.example.BookShop.Repos;

import com.example.BookShop.Base.BaseRepo;
import com.example.BookShop.Models.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepo extends BaseRepo<Book,Long> {
  @Query(value = "Select book from Book book where book.price >= :price")
   List<Book>findByPrice(double price);

       // this also help us to avoid the conflict that will happen in the lazy load cycle
       @Query(value = "select book from Book book where book.id =:id")
      @EntityGraph(attributePaths = {"author"})
       Book findById(long id);


}
