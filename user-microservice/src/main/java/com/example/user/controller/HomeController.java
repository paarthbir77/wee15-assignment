package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		//http://localhost:8080/viewMonthlyFinancials
		String homePage="";
		homePage+="<h1> Surabi Restraunts - user</h1>";
		homePage+="<a href=\"https://localhost:8082/login\" target=\"_blank\">Login</a><br>";
		homePage+="<a href=\"https://localhost:8082/logout\" target=\"_blank\">Logout</a><br>";
		homePage+="<a href=\"https://localhost:8082/swagger-ui.html#/register-controller/createUserUsingGET_1\" target=\"_blank\">Register</a><br>";
		homePage+="<a href=\"https://localhost:8082/swagger-ui.html#\" target=\"_blank\">Swagger for user</a><br>";
		homePage+="Directions: <br>";
		homePage+="open localhost:8082<br>";
		homePage+="click register button, will redirect to swagger tool. Use register controller<br>";
		homePage+="re-open localhost, click login and enter credentials<br>";
		homePage+="Go to swagger tool to continue<br>";
		homePage+="Enter code diwali for discount<br>";
		return homePage;
	}
	

}
