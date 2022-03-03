package com.tld.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tld.entities.User;

@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from User order by lastName", User.class);
		 
		List<User>  users =  query.getResultList();
		return users;
	}

	@Override
	public void saveUser(User user ) {
		Session session = sessionFactory.getCurrentSession();
	//	session.save(user);
	//	if(user.getId() ==0)session.save(user);
	//	else session.update(user);
		session.saveOrUpdate(user);
		
	}

	@Override
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from User where id=:unId");
		query.setParameter("unId", id);
		query.executeUpdate();
		
		
	}

}
