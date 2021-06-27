package com.college.api_gateway.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.api_gateway.jwt.AuthRequest;
import com.college.api_gateway.jwt.AuthResponse;
import com.college.api_gateway.jwt.UtilJwtService;

@RestController
public class EndPointResource {
	
	@Autowired
	AuthenticationManager authMan;
	
	@Autowired
	AuthDetailsService ser;
	
	@Autowired
	UtilJwtService jwtUtil;
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public String endPoint() {
		try {
			return "Hello String";
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<AuthResponse> createAthenticationToken(@RequestBody AuthRequest req)throws Exception{
		try{
		authMan.authenticate(new UsernamePasswordAuthenticationToken(req.getUserName(), req.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid UserName and Password");
		}
		final UserDetails userDetails=ser.loadUserByUsername(req.getUserName());
		final String jwt=jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(jwt));
	}

}
