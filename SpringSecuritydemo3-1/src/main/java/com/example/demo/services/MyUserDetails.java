package com.example.demo.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.MyUser;

public class MyUserDetails implements UserDetails {
	private String username;
	private String password;
	private List<GrantedAuthority> roles;

	public MyUserDetails(MyUser myUser) {

		this.username = myUser.getUsername();
		this.password = myUser.getPassword();

		// "USER,ADMIN" ---> ["USER","ADMIN"] ----> [new
		// SimpleGrantedAuthority("USER"),new SimpleGrantedAuthority("ADMIN")]
		this.roles = Arrays.asList(myUser.getRoles()
				.split(","))
				.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println(password);
		return password;
	}

	@Override
	public String getUsername() {
		System.out.println(username);
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
