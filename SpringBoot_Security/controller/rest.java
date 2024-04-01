package com.rutuja.SpringBoot_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rutuja")
public class rest {

	@GetMapping("/Public")
	public String publicUser(){
		return "I am public user";
	}
	
	@GetMapping("/Admin")
	public String adminUser(){
		return "I am admin user";
	}
	
	@GetMapping("/User")
	public String user(){
		return "I am API user";
	}
}
