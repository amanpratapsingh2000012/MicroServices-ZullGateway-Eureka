package com.tcs.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaServer
@SpringBootApplication
@RestController
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
	@RequestMapping("/actuator/info")
	public static String home() {
		String l1="Server Port:8761...started...";
		String l2="Eureka Server...";
		String l3=l1+"\n\n"+l2;
		return l3;
	}
}
