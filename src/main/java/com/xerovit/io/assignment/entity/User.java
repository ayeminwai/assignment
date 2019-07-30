package com.xerovit.io.assignment.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String telephone;

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public User setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getTelephone() {
		return telephone;
	}

	public User setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}
}
