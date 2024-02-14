package com.example.BookShop.Controller;

import com.example.BookShop.Models.Author;
import com.example.BookShop.Repos.AuthorSearch;
import com.example.BookShop.Services.AuthorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
        @Autowired
            private AuthorService authorService;

        @GetMapping()
        public ResponseEntity<?>GetAll(){
           return ResponseEntity.ok(authorService.getAll());
        }
        @GetMapping("/{id}")
        public ResponseEntity<?>GetById(@PathVariable("id") long id){
           return ResponseEntity.ok(authorService.getById(id));
        }
        @PostMapping("/add_Author")
        public ResponseEntity<?>Adding(@RequestBody Author author){
            return ResponseEntity.ok(authorService.insert(author));
        }
        @Transactional
        @PutMapping("/update")
          public ResponseEntity<?>Update(@RequestBody Author author){
            return ResponseEntity.ok(authorService.update(author));
        }
        @Transactional
       @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable("id") long id){
            authorService.deleteById(id);
        }
        @PostMapping("/spec")
        public ResponseEntity<?>searchspec(@RequestBody AuthorSearch authorSearch ){
            return ResponseEntity.ok(authorService.SearchSpec(authorSearch));
        }


}
