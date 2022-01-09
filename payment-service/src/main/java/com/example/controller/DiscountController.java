package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount-provider")
public class DiscountController {

	@GetMapping("/checkCode/{code}")
	public boolean checkDiscount(@PathVariable String code) {
		if(code.equals("diwali")) {
			return true;
		}
		return false;
	}

}