package com.example.admin.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.admin.entity.FinancialReport;
import com.example.admin.entity.User;
import com.example.admin.repository.UserRepository;
import com.example.admin.service.AdminOnUserService;

@Service
public class AdminOnUserServiceImpl implements AdminOnUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		User userResponse = userRepository.save(user);
		return userResponse;
	}
	
	@Override
	public String createUser(String email, String type, String password) {
		User user = new User(email, type, password);
		user = saveUser(user);
		return user.toString();
	}

	@Override
	public String viewUsers() {
		List<User> users = userRepository.findAllUsers();
		String result="";
		for(int i=0;i<users.size();i++) {
			result+=users.get(i).toString()+"\n";
		}
		return result;
	}
	
	public List<User> getUsersforLogin(){
		return userRepository.findAllUsersforLogin();
	}

	@Override
	public String updateUser(String email, String type) {
		// TODO Auto-generated method stub
		User user = userRepository.findUserById(email);
		if(user == null) {
			return null;
		}
		user.setType(type);
		userRepository.save(user);
		return user.toString();
	}

	@Override
	public String deleteUser(String email) {
		// TODO Auto-generated method stub
//		userRepository.deleteById(null);
		User user = userRepository.findUserById(email);
		if(user == null) {
			return "user not found";
		}
		userRepository.delete(user);
		return "deleted "+email;
	}

	@Override
	public Optional<User> loadUserByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findUserByIdLogin(email);
		if(user==null) {
			return null;
		}
		return user;
	}
	
	

}
