package com.example.springbootrest.dao;

import com.example.springbootrest.entity.Message;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

@Repository
public class MessageDaoHibernateImpl implements MessageDao {

    private EntityManager entityManager;

    @Autowired
    public MessageDaoHibernateImpl(EntityManager em) {
        entityManager = em;
    }

    @Override
    public List<Message> findAll() {
        // récupérer la session hibernate courante
        Session currentSession = entityManager.unwrap(Session.class);
        // créer une query (une requête)
        Query query = currentSession.createQuery("from Message", Message.class);
        // executer la requête et récupérer le résultat
        List<Message> messages = query.getResultList();
        // retourner le résultat
        return messages;
    }

    @Override
    public Message findById(int MessageId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Message message=  currentSession.get(Message.class, MessageId);
        return message;
    }

    @Override
    public void save(Message message) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(message);
    }

    @Override
    public void deleteById(int messageId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query= currentSession.createQuery("delete from Message where id=:unId");
        query.setParameter("unId", messageId);
        query.executeUpdate();
    }
}
