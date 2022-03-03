package com.tld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tld.dao.UserDao;
import com.tld.entities.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return dao.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		  dao.saveUser(user);
		
	}

	@Override
	@Transactional
	public User getUser(int id) {
		
		return dao.getUser(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.delete(id);
		
	}

}
