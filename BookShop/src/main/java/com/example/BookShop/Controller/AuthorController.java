package com.example.BookShop.Controller;

import com.example.BookShop.Models.Author;
import com.example.BookShop.Repos.AuthorSearch;
import com.example.BookShop.Services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ToStringSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
        @Autowired
            private AuthorService authorService;

      @Operation(summary = "Getting all authors that in the system")
        @GetMapping()
        public ResponseEntity<?>GetAll(){
           return ResponseEntity.ok(authorService.getAll());
        }
      @Operation(summary = "Getting the author by its id")
      @ApiResponses(value = {
              @ApiResponse(responseCode = "200", description = "Found the author",
                      content = { @Content(mediaType = "application/json",
                              schema = @Schema(implementation = Author.class)) }),
              @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                      content = @Content),
              @ApiResponse(responseCode = "404", description = "author not found",
                      content = @Content) })
        @GetMapping("/{id}")
        public ResponseEntity<?>GetById(  @Parameter(required = true,example = "3") @Max(1000) @PathVariable("id") long id){
           return ResponseEntity.ok(authorService.getById(id));
        }
         @Operation(summary = "adding new author")

        @PostMapping("/add_Author")
        public ResponseEntity<?>Adding(@RequestBody Author author){
            return ResponseEntity.ok(authorService.insert(author));
        }
    @Operation(summary = "Updating the author")

        @Transactional
        @PutMapping("/update")
          public ResponseEntity<?>Update(@RequestBody Author author){
            return ResponseEntity.ok(authorService.update(author));
        }
    @Operation(summary = "Delete the author")
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
