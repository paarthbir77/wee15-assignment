package com.example.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.admin.entity.FinancialReport;
import com.example.admin.entity.InventoryDetails;
import com.example.admin.entity.User;
import com.example.admin.service.AdminOnUserService;

@RestController
@RequestMapping("/admin-on-user-service")
public class AdminOnUserController {
	@Autowired
	AdminOnUserService adminService;
	
	@GetMapping("/createUser")
	public String createUser(String email, String type, String password) {
		return adminService.createUser(email, type, password);
	}
	@GetMapping("/viewUsers")
	public String viewUsers() {
		return adminService.viewUsers();
	}
	@GetMapping("/updateUsers")
	public String updateUsers(String email, String type) {
		return adminService.updateUser(email, type);
	}
	@GetMapping("/deleteUsers")
	public String deleteUser(String email) {
		return adminService.deleteUser(email);
	}
	@GetMapping("/loadUserByEmail")
	@ResponseBody
	public Optional<User> loadUserByEmail(@RequestParam("email")String email) {
		return adminService.loadUserByEmail(email);
	}
}


