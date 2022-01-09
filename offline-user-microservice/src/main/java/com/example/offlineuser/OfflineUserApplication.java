package com.example.offlineuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OfflineUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfflineUserApplication.class, args);
	}

}
