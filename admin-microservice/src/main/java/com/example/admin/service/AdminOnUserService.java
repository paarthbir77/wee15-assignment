package com.example.admin.service;

import java.util.Optional;

import com.example.admin.entity.User;

public interface AdminOnUserService {
	
	String createUser(String email, String type, String password);
	String viewUsers();
	String updateUser(String email, String type);
	String deleteUser(String email);
	Optional<User> loadUserByEmail(String email);
}
