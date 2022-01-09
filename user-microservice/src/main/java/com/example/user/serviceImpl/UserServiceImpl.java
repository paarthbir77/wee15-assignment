package com.example.user.serviceImpl;


import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.user.service.UserService;
import com.example.user.clients.AdminClient;
import com.example.user.clients.DiscountServiceClient;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	DiscountServiceClient discountClient;
	
	@Autowired
	AdminClient adminClient;
	
	
	@Override
	public String viewInventory() {
//		List<InventoryDetails> items = adminClient.getInventory();
//		String result="";
//		for(int i=0;i<items.size();i++) {
//			result+=items.get(i).toString()+"\n";
//		}
//		return result;
		return adminClient.getInventory();
	}
	
	@Override
	public String placeOrder(int orderId[], String code, String city) {
		int bill=0;
		for(int i=0;i<orderId.length;i++) {
			if(adminClient.checkInventoryforItem(orderId[i])) {
				bill += adminClient.findPriceforItem(orderId[i]);
			}
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		String dateString= now.toString();
		String username="";
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		if(discountClient.invokeDiscountService(code)) {
			bill = bill/2;
		}

		return adminClient.saveFinReport(username, bill, dateString.substring(8,10), dateString.substring(5, 7), dateString.substring(0, 4), city);
	}
	
}
