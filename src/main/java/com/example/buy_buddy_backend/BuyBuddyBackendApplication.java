package com.example.buy_buddy_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BuyBuddyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyBuddyBackendApplication.class, args);
	}

}
