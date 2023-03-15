package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
	.withUser("sumita")
	.password("1998")
	.roles("USER")
	.and()
	.withUser("mummy")
	.password("1971")
	.roles("ADMIN")
	.and()
	.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder (){ return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
   @Override
protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeHttpRequests()
	   .antMatchers("/admin").hasRole("ADMIN")
	   .antMatchers("/user").hasAnyRole("ADMIN","USER")
	  .antMatchers("/hello").permitAll()
	  .and()
	  .formLogin();
	  
	  
   }
}
