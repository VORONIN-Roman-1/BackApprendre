package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	 @Column(name="title")
	private String titre;

	 
	private String content;

	 
	private String signature;

	public Message(String titre, String content, String signature) {
		this.titre = titre;
		this.content = content;
		this.signature = signature;
	}

}
