package com.example.BookShop.Repos;

import lombok.Getter;
import lombok.Setter;

/*
  this class for dedicting what we are going to search about
  that match with the class we search for
 */
@Getter
@Setter
public class AuthorSearch {

    private String name;
    private String email;

}
