package com.college.api_gateway.zuul;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.college.api_gateway.auth.AuthDetailsService;
import com.college.api_gateway.jwt.UtilJwtService;

@Component
public class JWTFilter extends OncePerRequestFilter{
	
	//code added to apply and validate token
	@Autowired
	AuthDetailsService authDetailsService;
	
	@Autowired
	UtilJwtService jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		final String authHeader=req.getHeader("Authorization");
		String userName=null;
		String jwt=null;
		
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			jwt=authHeader.substring(7);
			userName=jwtUtil.getUsernameFromToken(jwt);
		}
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=this.authDetailsService.loadUserByUsername(userName);
			if(jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken uptoken=
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				uptoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
				SecurityContextHolder.getContext().setAuthentication(uptoken);
			}
		}
		chain.doFilter(req, res);
		
	}

}
