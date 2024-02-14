package com.example.BookShop.Config;

import com.example.BookShop.Models.Author;
import com.example.BookShop.Models.Book;
import com.example.BookShop.Services.AuthorService;
import com.example.BookShop.Services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class Configuration implements CommandLineRunner {
 @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {

        Author author1=new Author();
        author1.setId(1L);
        author1.setName("ahmed");

        Author author2=new Author();
        author2.setId(2L);
        author2.setName("mohamed");
        authorService.insertAll(Arrays.asList(author1,author2));


        Book book1=new Book();
        book1.setId(1L);
        book1.setName("php");
        book1.setPrice(200.0);
        book1.setAuthor(authorService.getById(author1.getId()));

        Book book2=new Book();
        book2.setId(2L);
        book2.setName("java");
        book2.setPrice(200.0);
        book2.setAuthor(authorService.getById(author2.getId()));

        bookService.insertAll(Arrays.asList(book1,book2));
    }
}
