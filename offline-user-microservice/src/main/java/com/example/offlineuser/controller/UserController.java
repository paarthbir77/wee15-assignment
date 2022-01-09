package com.example.offlineuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.offlineuser.entity.FinancialReport;
import com.example.offlineuser.entity.InventoryDetails;
import com.example.offlineuser.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/viewInventory")
	public String viewInventory() {
		return userService.viewInventory();
	}

	@PostMapping("/placeOrder")
	public String placeOrder(int orderId[], String city) {
		return userService.placeOrder(orderId, city);
	}
	
	@PostMapping("/makeReservation")
	public String makeReservation(String date, String month, String year, int members) {
		return userService.makeReservation(date, month, year, members);
	}
	
	@PostMapping("/giveFeedback")
	public String giveFeedback(String feedback) {
		return userService.giveFeedback(feedback);
	}

}
