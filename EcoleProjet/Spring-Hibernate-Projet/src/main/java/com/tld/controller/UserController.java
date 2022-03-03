package com.tld.controller;

import org.springframework.ui.Model;

import com.tld.entities.User;

public interface UserController {

	public String listAllUsers( Model theModel) ;
	public String saveUser(User user);
}
