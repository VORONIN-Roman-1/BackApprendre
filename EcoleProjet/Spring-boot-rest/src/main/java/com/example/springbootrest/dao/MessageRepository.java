package com.example.springbootrest.dao;

import com.example.springbootrest.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    public Message findById(int id);

    // find =select
    public List<Message> findBySignature(String signature);

    public List<Message> findByContentContains(String cdc);

    public List<Message> findByContentContainsAndTitle(String cdc, String title);

    // chercher un message dont le titre contient x et dont la signature contient y
// via une requête HQL
    @Query("select m from Message m where m.title like :x and m.signature like :y ")
    public List<Message> searchMessage(@Param("x") String cdc1, @Param("y") String cdc2);
}


