package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.MessageService;



@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MessageService service;

	
	@Test
	void contextLoads() {
	}

	@Test
	void testServiceFindAll() {
		Assertions.assertEquals(3, service.getAllMessages().size());
	}
	
}
