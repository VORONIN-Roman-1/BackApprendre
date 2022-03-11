package com.example.springbootrest.service;

import com.example.springbootrest.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> findAll();
    public Message findById(int MessageId);
    public void save (Message message);

    void deleteById(int messageId);
}
