package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;

@RestController
public class AdminController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo repo;
//	@Autowired
//	PasswordEncoder passwordEncoder;
	/*
	 * @PostMapping("/admin/add") public String addUserByAdmin(@RequestBody User
	 * user) { String pwd = user.getPassword(); String encrytPwd =
	 * passwordEncoder.encode(pwd); user.setPassword(encrytPwd);
	 * userRepo.save(user);
	 * 
	 * return "user saved successfully"; }
	 */
	/*
	 * @PreAuthorize("hasAnyRole('ADMIN')")
	 * 
	 * @GetMapping("/admin/all") public String home() { return "secured hello";
	 * 
	 * }
	 */
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		User saved= userRepo.save(user);
		System.out.println(saved);
		return saved;
		
	}
	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		Role savedRole = repo.save(role);
		System.out.println(savedRole);
		return savedRole ;
	}
}
