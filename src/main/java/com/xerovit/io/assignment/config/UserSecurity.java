package com.xerovit.io.assignment.config;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.xerovit.io.assignment.model.AuthUser;

@Service
public class UserSecurity {

	public boolean hasUserName(OAuth2Authentication authentication, Integer id) {
		AuthUser user = (AuthUser) authentication.getPrincipal();
		return user.getUserId() == id;
	}
}
