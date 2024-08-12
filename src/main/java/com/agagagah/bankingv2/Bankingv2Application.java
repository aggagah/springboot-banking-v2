package com.agagagah.bankingv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Bankingv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bankingv2Application.class, args);
	}

}
