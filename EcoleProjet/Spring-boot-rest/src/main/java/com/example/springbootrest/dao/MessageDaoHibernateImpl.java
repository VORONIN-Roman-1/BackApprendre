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
    @Transactional
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
}
