package com.example.offlineuser.serviceImpl;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.offlineuser.entity.Feedback;
import com.example.offlineuser.entity.FinancialReport;
import com.example.offlineuser.entity.InventoryDetails;
import com.example.offlineuser.entity.Reservation;
import com.example.offlineuser.service.UserService;
import com.example.offlineuser.clients.AdminClient;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	AdminClient adminClient;
	
	@Override
	public String viewInventory() {
//		List<InventoryDetails> items = inventoryDetailsRepository.findAll();
//		String result="";
//		for(int i=0;i<items.size();i++) {
//			result+=items.get(i).toString()+"\n";
//		}
//		return result;
		return adminClient.getInventory();
	}
	
	
	
	@Override
	public String placeOrder(int orderId[], String city) {
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
		
		return adminClient.saveFinReport(username, bill, dateString.substring(8,10), dateString.substring(5, 7), dateString.substring(0, 4),city);
	}

	@Override
	public String makeReservation(String date, String month, String year, int members) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		String input = year+"/"+month+"/"+date;
		LocalDate inputDate = LocalDate.parse(input, dtf);
		
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
		if(Duration.between(now, inputDate.atStartOfDay()).toDays() >= 2) {
//			Reservation reservation = new Reservation(username, members, date, month, year);
//			reservation = saveReservation(reservation);
//			return reservation.toString();
			return adminClient.makeReservation(username, members, date, month, year);
		}
		
		return "Please give us notice atleast two days before!";
	}

	@Override
	public String giveFeedback(String feedbackContent) {
		// TODO Auto-generated method stub
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
//		Feedback feedback = new Feedback(username, feedbackContent);
//		feedback = saveFeedback(feedback);
		adminClient.giveFeedback(username, feedbackContent);
		return "Thank you for your feedback!";
	}
	
}
