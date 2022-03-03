package org.example.dao;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<User> getUsers() {
        // récupérer une session hibernate
        Session session = sessionFactory.getCurrentSession();
// créer une requête
        Query query = session.createQuery("from User", User.class);
        //Query<User> query= session.createQuery("select u from User u", User.class);
//executer la requête , récupérer son résultat
        List<User> users = query.getResultList();
        return users;
    }
}
