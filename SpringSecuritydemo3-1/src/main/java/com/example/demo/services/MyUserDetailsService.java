package com.example.demo.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MyUser;
import com.example.demo.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<MyUser> userOptional = userRepository.findByUsername(username);
		userOptional.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		return new MyUserDetails(userOptional.get());
	}

}
