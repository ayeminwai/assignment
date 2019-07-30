package com.xerovit.io.assignment.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xerovit.io.assignment.entity.User;
import com.xerovit.io.assignment.model.AuthUser;
import com.xerovit.io.assignment.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//User user = userRepository.findByUsername(username);
		User user = new User().setUserId(1).setUsername(username).setPassword("$2a$10$hYG93u7Ghkn7VpKQRJ9JAeH3FNhuwLmrmuov4w6aMnY5h/EYSY5ga");
			if (user == null)
				throw new UsernameNotFoundException("User not found.");
			
			return new AuthUser(
					user.getUserId(),
					user.getUsername(),
					user.getPassword(),
					true,
					true,
					true,
					true,
					Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

}