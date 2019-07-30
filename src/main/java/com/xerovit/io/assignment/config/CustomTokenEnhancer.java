package com.xerovit.io.assignment.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.xerovit.io.assignment.model.AuthUser;


public class CustomTokenEnhancer implements TokenEnhancer{
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		AuthUser user = (AuthUser) authentication.getPrincipal();
        final Map<String,Object> auxInfo = new HashMap<String,Object>();
        auxInfo.put("user",user);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(auxInfo);
        return accessToken;
	}

}
