package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Message;
import com.example.demo.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageControllerRest {

	@Autowired 
	private MessageService service;
	
	@GetMapping()
	public List<Message> lister(){
		return service.getAllMessages();
	}
}
