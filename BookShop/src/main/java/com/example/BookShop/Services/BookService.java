package com.example.BookShop.Services;

import com.example.BookShop.Base.BaseServices;
import com.example.BookShop.Models.Book;
import com.example.BookShop.Repos.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseServices<Book,Long> {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book update1 (Book book){
        Book book1=getById(book.getId());
        book1.setName(book.getName());
        return update(book1);
    }

    public List<Book>get_salary(double price){
        return bookRepo.findByPrice(price);
    }

    @Override
    public Book insert(Book T) {
        return bookRepo.save(T);
    }
}
