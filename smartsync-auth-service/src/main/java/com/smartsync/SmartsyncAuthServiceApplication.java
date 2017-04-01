package com.smartsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SmartsyncAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartsyncAuthServiceApplication.class, args);
	}
}
