package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MessageRepository;
import com.example.demo.entities.Message;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired 
	private MessageRepository dao;
	
	@Override
	public List<Message> getAllMessages() {
		 
		return dao.findAll();
	}

}
