package com.example.springbootrest.dao;

import com.example.springbootrest.entity.Message;

import java.util.List;

public interface MessageDao {
    public List<Message> findAll();
    public Message findById(int MessageId);
    public void save (Message message);
    void deleteById(int messageId);
}
