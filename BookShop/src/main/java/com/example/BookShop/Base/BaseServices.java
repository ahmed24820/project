package com.example.BookShop.Base;


import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@MappedSuperclass
public class BaseServices <T extends BaseEntity<ID> ,ID> {
    @Autowired
    private BaseRepo<T,ID> baseRepo;

     public BaseServices(){

     }
    public T insert(T T){
        return baseRepo.save(T);
    }

    public List<T> getAll(){
        return baseRepo.findAll();
    }
    public List<T>insertAll(List<T> authors){
        return baseRepo.saveAll(authors);
    }
    public T getById(ID id){
        return baseRepo.findById(id).get();
    }
    public T update(T t){
        return baseRepo.save(t);
    }

    public void deleteById(ID id){
        T T= baseRepo.findById(id).get();
        if(T==null){
            throw new SqlScriptException("User is not founded");
        }
        baseRepo.deleteById(id);
    }
    
}
