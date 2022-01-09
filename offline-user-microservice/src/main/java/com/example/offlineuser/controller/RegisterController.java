package com.example.offlineuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.offlineuser.service.RegisterService;

@RestController
public class RegisterController {
	@Autowired
	RegisterService adminService;
	@GetMapping("/Register")
	public String createUser(String email, String password) {
		return adminService.createUser(email, password);
	}

}
