package com.example.offlineuser.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.offlineuser.entity.User;
import com.example.offlineuser.service.RegisterService;
import com.example.offlineuser.clients.AdminClient;
@Service
public class RegisterServiceImpl implements RegisterService{
//	@Autowired
//	UserRepository userRepository;
	@Autowired
	AdminClient adminClient;
//	@Transactional
//	public User saveUser(User user) {
//		User userResponse = userRepository.save(user);
//		return userResponse;
//	}
	
	@Override
	public String createUser(String email, String password) {
//		User user = new User(email, "Offline Customer", password);
//		user = saveUser(user);
//		return user.toString();
		return adminClient.saveUser(email, "Offline Customer", password);
	}

}
