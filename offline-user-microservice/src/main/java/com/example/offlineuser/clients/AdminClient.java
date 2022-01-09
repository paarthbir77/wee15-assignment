package com.example.offlineuser.clients;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.offlineuser.entity.User;

@Service
public class AdminClient {
	@Autowired
	private RestTemplate template;
	
	public String getInventory() {
		String url = "https://localhost:8081/admin-service/getInventory/";
		return template.getForObject(url, String.class);
	}
	public String saveFinReport(String username,int bill,String date,String month,String year, String city) {
		String url = "https://localhost:8081/admin-service/saveFinancialReport?bill="+bill+"&city="+city+"&date="+date+"&month="+month+"&username="+username+"&year="+year;
		return template.getForObject(url, String.class);
	}
	public boolean checkInventoryforItem(int id) {
		String url = "https://localhost:8081/admin-service/checkInventoryforItem/" + id;
		return template.getForObject(url, boolean.class);
	}
	public int findPriceforItem(int id) {
		String url = "https://localhost:8081/admin-service/findPriceforItem/" + id;
		return template.getForObject(url, int.class);
	}
	public String saveUser(String email, String type, String password) {
		String url = "https://localhost:8081/admin-on-user-service/createUser?email="+email+"&password="+password+"&type="+type;
		return template.getForObject(url, String.class);
	}
	public Optional<User> loadUserBYEmail(String email) {
		String url = "https://localhost:8081/admin-on-user-service/loadUserByEmail?email="+email;
		User user= template.getForObject(url, User.class);
		return Optional.ofNullable(user);	
	}
	public String makeReservation(String username, int members , String date, String month, String year) {
		String url = "https://localhost:8081/admin-service/makeReservation?date="+date+"&members="+members+"&month="+month+"&username="+username+"&year="+year;
		return template.getForObject(url, String.class);
	}
	public String giveFeedback(String username, String feedbackContent) {
		String url = "https://localhost:8081/admin-service/giveFeedback?feedbackContent="+feedbackContent+"&username="+username;
		return template.getForObject(url, String.class);
	}
	
}
