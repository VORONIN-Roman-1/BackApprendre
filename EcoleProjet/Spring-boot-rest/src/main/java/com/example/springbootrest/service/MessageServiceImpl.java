package com.example.springbootrest.service;

import com.example.springbootrest.dao.MessageDao;
import com.example.springbootrest.dao.MessageRepository;
import com.example.springbootrest.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService{
//    @Autowired
//    @Qualifier("messageDaoImplV2")
//    MessageDao messageDao;
    @Autowired
    MessageRepository messageDao;
    @Transactional
    public List<Message> findAll(){
        return messageDao.findAll();
    }
    @Transactional
    @Override
    public Message findById(int MessageId) {
        return messageDao.findById(MessageId);
    }
    @Transactional
    @Override
    public void save(Message message) {
        messageDao.save(message);
    }
    @Transactional
    @Override
    public void deleteById(int messageId) {
        messageDao.deleteById(messageId);
    }

}
