package com.example.BookShop.Services;

import com.example.BookShop.Base.BaseRepo;
import com.example.BookShop.Base.BaseServices;
import com.example.BookShop.Exceptions.Notfounded;
import com.example.BookShop.Models.Author;
import com.example.BookShop.Repos.AuthorRepo;
import com.example.BookShop.Repos.AuthorSearch;
import com.example.BookShop.Repos.AuthorSpecif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService extends BaseServices<Author,Long> {

@Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author getById(Long id) {
       Optional<Author> author=authorRepo.findById(id);
       if(author.isPresent()){
        return super.getById(id);
    }else {
           throw new Notfounded("this id is not founded" + "->" +id);
       }
    }

    @Override
    public Author insert(Author T) {
      if(!T.getEmail().isEmpty()&& T.getEmail()!=null) {
       Optional<Author> author=findByEmail(T.getEmail());
       if(author.isPresent()){
           throw new Notfounded("this email is already used before");
       }}
        return super.insert(T);
    }

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
     public Optional<Author> findByEmail(String email){
      return authorRepo.findByEmail(email);
     }


}
