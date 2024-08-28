package com.IT5.costumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class CostumerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CostumerServiceApplication.class, args);
	}
}
