package com.example.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		String homePage="";
		homePage+="<h1> Surabi Restraunts Admin appication</h1>";
		homePage+="<a href=\"https://localhost:8081/login\" target=\"_blank\">Login</a><br>";
		homePage+="<a href=\"https://localhost:8081/logout\" target=\"_blank\">Logout</a><br>";
		homePage+="<a href=\"https://localhost:8081/swagger-ui.html#/\" target=\"_blank\">Swagger</a><br>";
		homePage+="Directions: <br>";
		homePage+="open localhost:8081<br>";
		homePage+="click login and enter credentials: admin@rest.com, password: admin<br>";
		homePage+="Go to swagger tool to continue<br>";
		return homePage;
	}
	

}
