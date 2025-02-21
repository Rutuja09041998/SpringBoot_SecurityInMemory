package com.rutuja.SpringBoot_Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class config {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(resitry->{
			resitry.requestMatchers("Rutuja/Public").permitAll();
			resitry.requestMatchers("Rutuja/Admin").hasRole("Admin");
			resitry.requestMatchers("Rutuja/User").hasRole("User");
		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails1=User.builder().username("Rutuja").password(passwordEncoder().encode("Rutuja@123")).roles("Admin").build();
		UserDetails userDetails2=User.builder().username("Radhika").password(passwordEncoder().encode("Radhika@1234")).roles("User").build();
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
