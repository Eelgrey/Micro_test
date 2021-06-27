package com.college.api_gateway.auth;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthDetailsService implements UserDetailsService{

	@Autowired
	LoginDetails login;
	
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		return new User(login.getUserName(),login.getPassword(),new ArrayList<>());
	}

}
