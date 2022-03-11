package com.example.springbootrest.controller;

import com.example.springbootrest.dao.MessageDaoHibernateImpl;
import com.example.springbootrest.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    // définir l'attribut service (la dépendance du restController envers le
// MessageService)
    private MessageDaoHibernateImpl service;
    // constructor injection
    @Autowired
    public MessageRestController(MessageDaoHibernateImpl service) {
        this.service = service;
    }
    // exposer la méthode findAll via le endpoint /api/messages
    @GetMapping("/messages")
    public List<Message> findAll() {
        return service.findAll();
    }
}