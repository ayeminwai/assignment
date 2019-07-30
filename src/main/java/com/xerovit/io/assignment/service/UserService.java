package com.xerovit.io.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xerovit.io.assignment.entity.User;
import com.xerovit.io.assignment.exception.DataExistException;
import com.xerovit.io.assignment.exception.NullException;
import com.xerovit.io.assignment.repository.UserRepository;

@Service
public class UserService implements CommonService<User> {
	@Autowired
	UserRepository userRepo;

	@Override
	public User insert(User user) {
		validateUser(user);
		return userRepo.save(user);
	}

	@Override
	public void delete(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public User get(int id) {
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	private void validateUser(User user) {
		if(user.getUsername() == null)
			throw new NullException("Invalid User Name");
		if(user.getPassword() == null)
			throw new NullException("Invalid Password");
		if(user.getEmail() == null)
			throw new NullException("Invalid Email");
		if(user.getTelephone() == null)
			throw new NullException("Invalid Telephone");
		checkUser(user);
	}
	
	private void checkUser(User user) {
		System.out.println(userRepo.existsByTelephone(user.getTelephone()));
		if(userRepo.existsByTelephone(user.getTelephone()))
			throw new DataExistException(DataExistException.PHONE_NUMBER_EXIST);
		if(userRepo.existsByEmail(user.getEmail()))
			throw new DataExistException(DataExistException.EMAIL_EXIST);
	}
}
