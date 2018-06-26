package com.dev.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ram").password("ram").roles("ADMIN","USER");
		
		auth.inMemoryAuthentication().withUser("ma").password("ma").roles("USER");
	}
	
	
	@Override
 protected void configure(HttpSecurity http) throws Exception {
	http.formLogin();
	
	http.authorizeRequests().antMatchers("/enterprise").hasRole("ADMIN");
	http.authorizeRequests().antMatchers("/enterprise","/tax","/").hasRole("USER");
		
}
	
	
	
	
	

}
