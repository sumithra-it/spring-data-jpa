package com.kaavya.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaavya.springdatajpa.model.User;
import com.kaavya.springdatajpa.repo.UserRepository;
import org.springframework.data.domain.Sort;
@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepo; 

	public User addNewUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> fetchAll(){
		 Iterable<User> iterable = userRepo.findAll(); //returns a iterable from the repository
		 List<User> ulist = new ArrayList<User>();
		 iterable.forEach(ulist :: add);
		 return ulist;
	}
	
	public List<User> fetchByName(String name){
		return userRepo.findByName(name);
	}
	public List<User> fetchByEmail(String email){
		return userRepo.findByEmail(email);
	}
	
	public List<User> customfindUserByEmailAddress(String email) {
		Sort sort = Sort.by("email").ascending().and(Sort.by("name"));
		return userRepo.findUserByEmailAddressSorted(email, sort);
	}
	
	public List<User> findUserByLikeName(){
		return userRepo.findUserByLikeName();
	}
	public List<User> sorted(){
		//By using dynamic sorting, you can choose the sorting column and direction at runtime to sort the query results. 
		List<User> userList = new ArrayList<>();
		userRepo.findAll(Sort.by(Sort.Direction.ASC, "name"))
							.forEach(userList::add);
		
		userRepo.findAll(Sort.by("name").ascending().and(
						Sort.by("email")))
						.forEach(userList :: add);
		return userList;
	}
	
}
