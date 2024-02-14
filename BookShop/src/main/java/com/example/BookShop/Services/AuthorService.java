package com.example.BookShop.Services;

import com.example.BookShop.Base.BaseRepo;
import com.example.BookShop.Base.BaseServices;
import com.example.BookShop.Models.Author;
import com.example.BookShop.Repos.AuthorRepo;
import com.example.BookShop.Repos.AuthorSearch;
import com.example.BookShop.Repos.AuthorSpecif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService extends BaseServices<Author,Long> {

@Autowired
    private AuthorRepo authorRepo;
     @Override
    public Author update (Author author){
        Author author1=getById(author.getId());
        author1.setName(author.getName());
        return super.update(author1);
    }
    public List<Author> SearchSpec(AuthorSearch authorSearch){
        AuthorSpecif authorSpecif =new AuthorSpecif(authorSearch);
        return authorRepo.findAll(authorSpecif);
    }


}
