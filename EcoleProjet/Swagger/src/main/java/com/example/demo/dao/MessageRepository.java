package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
