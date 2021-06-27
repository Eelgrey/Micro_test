package com.college.api_gateway.jwt;

import org.springframework.stereotype.Component;

@Component
public class AuthResponse {
	
	private String tokenJWT;
	
	public AuthResponse() {
	}

	public AuthResponse(String tokenJWT) {
		this.tokenJWT = tokenJWT;
	}

	public String getTokenJWT() {
		return tokenJWT;
	}

	public void setTokenJWT(String tokenJWT) {
		this.tokenJWT = tokenJWT;
	}


	

}
