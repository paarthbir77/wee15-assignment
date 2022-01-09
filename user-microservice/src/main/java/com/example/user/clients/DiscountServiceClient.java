package com.example.user.clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiscountServiceClient {
	@Autowired
	private RestTemplate template;
	
	public boolean invokeDiscountService(String code) {
		String url = "https://localhost:8084/discount-provider/checkCode/" + code;
		return template.getForObject(url, boolean.class);
	}
}
