package com.example.BookShop.Controller;
import com.example.BookShop.Models.Book;
import com.example.BookShop.Services.BookService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<?> GetAll(){
        return ResponseEntity.ok(bookService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>GetById(@PathVariable("id") long id){
        return ResponseEntity.ok(bookService.getById(id));
    }
    @PostMapping("/add-book")
    public ResponseEntity<?>Adding(@RequestBody Book book){
        return ResponseEntity.ok(bookService.insert(book));
    }
    @Transactional
    @PutMapping("/update")
    public ResponseEntity<?>Update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update1(book));
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        bookService.deleteById(id);
    }
    @GetMapping("/get-By-Price")
    public List<Book> get_salary(@RequestParam double price){
        return bookService.get_salary(price);
    }




}
