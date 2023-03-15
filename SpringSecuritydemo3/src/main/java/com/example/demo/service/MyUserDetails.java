package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.MyUser;

public class MyUserDetails implements UserDetails{
	
	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	
	public MyUserDetails(MyUser user) {
	this.username=user.getUsername();
	this.password=user.getPassword();
		this.roles=Arrays.asList(user.getRoles()
				.split(","))
				.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
