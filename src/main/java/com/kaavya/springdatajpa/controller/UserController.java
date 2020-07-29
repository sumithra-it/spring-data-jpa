package com.kaavya.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaavya.springdatajpa.model.User;
import com.kaavya.springdatajpa.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	public UserService service; 
	
	@PostMapping
	public @ResponseBody String addNewUser(@RequestBody User user) {
		service.addNewUser(user);
		return "saved user";
	}
	
	@GetMapping("/all")
	public List<User> fetchAll() {
		 return service.fetchAll();
	}
	
	@GetMapping("/name/{name}")
	public List<User> fetchByName(@PathVariable("name") String name) {
		return service.fetchByName(name);
	}
	@GetMapping("/email/{email}")
	public List<User> fetchByEmail(@PathVariable("email") String email) {
		return service.fetchByEmail(email);
	}
	
	@GetMapping("/emailaddress/{email}")
	public List<User> customfindUserByEmailAddress(@PathVariable("email") String email) {
		return service.customfindUserByEmailAddress(email);
	}
	@GetMapping("/name/like")
	public List<User> findUserByLikeName(){
		return service.findUserByLikeName();
	}
}
