package com.sp.micro.user_s.services;

import java.util.List;

import com.sp.micro.user_s.entities.User;

public interface UserService {
	
	User saveUser(User u);
	
	List<User> getAllUsers();
	
	User getUser(String id);
}
