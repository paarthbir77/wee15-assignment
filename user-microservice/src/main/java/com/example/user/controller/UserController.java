package com.example.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/viewInventory")
	public String viewInventory() {
		return userService.viewInventory();
	}

	@PostMapping("/placeOrder")
	public String placeOrder(int orderId[], String code, String city) {
		return userService.placeOrder(orderId, code, city);
	}

}
