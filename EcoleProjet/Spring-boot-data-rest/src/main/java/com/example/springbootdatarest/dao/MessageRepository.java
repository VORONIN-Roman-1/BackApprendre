package com.example.springbootdatarest.dao;

import com.example.springbootdatarest.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "articles") //http://localhost:8080/articles
public interface MessageRepository extends JpaRepository<Message, Integer> {

//    public Message findById(int id);
//
//    // find =select
//    public List<Message> findBySignature(String signature);
//
//    public List<Message> findByContentContains(String cdc);
//
//    public List<Message> findByContentContainsAndTitle(String cdc, String title);
//
//    // chercher un message dont le titre contient x et dont la signature contient y
//// via une requête HQL
//    @Query("select m from Message m where m.title like :x and m.signature like :y ")
//    public List<Message> searchMessage(@Param("x") String cdc1, @Param("y") String cdc2);
}


