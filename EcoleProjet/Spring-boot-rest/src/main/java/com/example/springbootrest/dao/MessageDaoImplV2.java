package com.example.springbootrest.dao;

import com.example.springbootrest.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MessageDaoImplV2 implements MessageDao {
    private EntityManager entityManager;

    @Autowired
    public MessageDaoImplV2(EntityManager em) {
        entityManager = em;
    }

    @Override
    public List<Message> findAll() {
        // create typedQuery to fet all Messages
        TypedQuery<Message> typedQuery = entityManager.createQuery("from Message", Message.class);
        //execute typedQuery and get the result List
        List<Message> messages = typedQuery.getResultList();
        //return the List
        return messages;
    }

    @Override
    public Message findById(int id) {
        //get one message from the given id
        Message message = entityManager.find(Message.class, id);
        return message;
    }

    public void save(Message message) {
        // save or update the message
        Message storedMessage = entityManager.merge(message);
        // update with id from db
        message.setId(storedMessage.getId());
    }

    @Override
    public void deleteById(int id) {
//delete object with primary key
        Query query = entityManager.createQuery("delete from Message where id=:messageId");
        query.setParameter("messageId", id);
        query.executeUpdate();
    }
}
