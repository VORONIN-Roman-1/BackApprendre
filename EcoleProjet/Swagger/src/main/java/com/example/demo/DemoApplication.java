package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.MessageRepository;
import com.example.demo.entities.Message;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		 
	}

	@Autowired
	private MessageRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new Message( "titre 01", "voici le contenu de mon message ", "omer@gmail.com"));
		repo.save(new Message("titre 02", "sympa le chargement de données en base ", "obiwan@gmail.com"));

		repo.save(new Message("titre 03", "la télé ça paye les factures et les UV ", "bernard.montiel@hanouna.biz"));

	}

}
