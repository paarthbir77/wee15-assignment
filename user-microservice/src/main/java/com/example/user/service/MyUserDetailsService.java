package com.example.user.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user.clients.AdminClient;
import com.example.user.entity.MyUserDetails;
import com.example.user.entity.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	AdminClient adminClient;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = adminClient.loadUserBYEmail(email);
		//Optional<User> user = userRepository.findUserByIdLogin(email);
		if(user==null) {
			return null;
		}
		//Optional<User> user = userRepository.findByUserName(email);
		
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + email));

        return user.map(MyUserDetails::new).get();
	}

}
