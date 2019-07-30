package com.xerovit.io.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xerovit.io.assignment.entity.User;
import com.xerovit.io.assignment.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping(value="/")
	public User insert(@RequestBody User user) {
		return service.insert(user);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
	@GetMapping(value="/{id}")
	public User get(@PathVariable("id") Integer id) {
		return service.get(id);
	}
	
	@GetMapping(value="/")
	public List<User> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value="/get")
	public String getMsg() {
		return "Hi";
	}
}
