package com.dambroski.GameListProject.user;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathParam("userId") Long userId) {
		return service.getUserById(userId);
	}
	
	@PostMapping("/post")
	public User postUser(@RequestBody User user) {
		return service.postUser(user);
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathParam("userId") long userId) {
		return service.deleteById(userId);
	}
	
	@PutMapping("/put/{userId}")
	public User putUser(@PathParam("userId") long userId, @RequestBody User user) {
		return service.putUser(userId,user);
	}
}
