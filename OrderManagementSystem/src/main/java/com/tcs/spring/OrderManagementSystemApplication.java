package com.tcs.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class OrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}

	@RequestMapping("/actuator/info")
	public static String home() {
		String l1="Client Port:8080...started...";
		String l2="Order Management System...";
		String l3=l1+"\n\n"+l2;
		return l3;
	}
}
