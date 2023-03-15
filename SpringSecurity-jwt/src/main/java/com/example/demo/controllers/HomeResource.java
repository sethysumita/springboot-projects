package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AuthenticationRequest;
import com.example.demo.services.MyUserDetailsService;
import com.example.demo.utils.JwtUtil;

@RestController
public class HomeResource {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome Home";
	}
	
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e){
			throw new Exception("user not found");
		}
		
		
		String username = authenticationRequest.getUsername();
		UserDetails user = myUserDetailsService.loadUserByUsername(username);
		String generatedToken = jwtUtil.generateToken(user);
		System.out.println(generatedToken);
		return generatedToken;
		
	}

}
