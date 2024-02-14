package com.example.BookShop.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;
@NoRepositoryBean
public interface BaseRepo<T,ID> extends JpaRepository<T, ID> {
    @Modifying
    @Transactional
    @Query(value = "update #{#entityName} s set s.name =:name where s.id=:id ")
    void updateName(ID id ,String name);

}
