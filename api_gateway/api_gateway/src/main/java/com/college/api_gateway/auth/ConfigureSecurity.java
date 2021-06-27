package com.college.api_gateway.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.college.api_gateway.zuul.JWTFilter;


@Configuration
@EnableWebSecurity
public class ConfigureSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthDetailsService authDetailsService;
	
	@Autowired
	JWTFilter filter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{

		auth.userDetailsService(authDetailsService);
	}
	
	//csrf=cross side request forgery
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll().anyRequest().authenticated().
		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

	}
	
	//added this method as on server startup it gives error as deprecated auth manager
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean()throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passEnc() {
		return NoOpPasswordEncoder.getInstance();
	}

}
