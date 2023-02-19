package com.sp.micro.user_s.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.micro.user_s.entities.User;
import com.sp.micro.user_s.services.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User u){
		User u1=userService.saveUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable String id){
		User u1=userService.getUser(id);
		return ResponseEntity.ok(u1);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> u1=userService.getAllUsers();
		return ResponseEntity.ok(u1);
	}
}
