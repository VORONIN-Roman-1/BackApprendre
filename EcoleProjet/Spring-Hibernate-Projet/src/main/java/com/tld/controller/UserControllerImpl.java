package com.tld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tld.dao.UserDao;
import com.tld.entities.User;
import com.tld.service.UserService;

@Controller 
@RequestMapping("/users")
public class UserControllerImpl implements UserController{

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/list")
	public String listAllUsers( Model theModel) {
		List<User> users=   userService.getUsers();
		theModel.addAttribute("users", users);
		
		 
		return "list-users";
	}
	
	@GetMapping("/montrerFormulaireCreate")
	public String showUserForm(Model  model) {	
		User user =new User();
		model.addAttribute("user", user);
		return "form-user";
	}
	
	@PostMapping("/sauvegarderUser")
	public String saveUser(@ModelAttribute ("user" ) User user) {
		userService.saveUser(user);
		return "redirect:/users/list";
		
	}
	
	@GetMapping("/montrerFormulaireEdition")
	public  String montrerFormulaireEdition(@RequestParam("id") int id, Model model) {
		
		User userToEdit = userService.getUser(id);
		model.addAttribute("user", userToEdit);
		return "form-user";
		
	}
	
	@GetMapping("/deleteById")
	public String deleteUser (@RequestParam ("id") int id ) {
		userService.delete(id);
		
		return "redirect:/users/list";
	}
	
	
}
