package com.example.springbootrest.controller;

import com.example.springbootrest.entity.Message;
import com.example.springbootrest.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    // définir l'attribut service (la dépendance du restController envers le
// MessageService)
    private MessageService service;
    // constructor injection
    @Autowired
    public MessageRestController(MessageService service) {
        this.service = service;
    }
    // exposer la méthode findAll via le endpoint /api/messages
    @GetMapping("/messages")
    public List<Message> findAll() {
        return service.findAll();
    }
    // add mapping for GET /messages/{messageId}
    @GetMapping("/messages/{messageId}")
    public Message getMessageById(@PathVariable int messageId) {
        Message message = service.findById(messageId);
        if (message == null) {
            throw new RuntimeException("Message id not found - " + messageId);
        } return message;
    }
    // add mapping for POST /messages - add new message
    @PostMapping(value="/messages")
    public Message addMessage(@RequestBody Message message) {
// juste au cas où le client passe un id dans le JSON . . . on le set à 0
// cela sauvegardera un nouvel élément, … au lieu de mettre à jour
        service.save(message);
        return message;
    }
    // mapping du PUT /messages - update existing message
    @PutMapping("/messages")
    public Message updateEmployee(@RequestBody Message message) {
        service.save(message);
        return message;
    }
    // mapping du DELETE /messages/{messageId} - delete message
    @DeleteMapping("/messages/{messageId}")
    public String deleteMessage(@PathVariable int messageId ) {
        Message tempMessage = service.findById(messageId);
// throw exception if null
        if(tempMessage == null) throw new RuntimeException ("this message id not found - "
                +messageId);
        service.deleteById(messageId);
        return "Deleted message id - "+ messageId;
    }
}