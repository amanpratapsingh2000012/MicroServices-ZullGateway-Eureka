package com.tcs.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServerApplication.class, args);
	}
	
	@RestController
	@RefreshScope
	class Message{
		@Value("${msg:Hello World}")
		String msg;
		
		@RequestMapping("/msg")
        String getmsg() {
            return this.msg;
        }
	}
	
	@Bean
    public RestTemplate getRest() {
        return new RestTemplate();
    }
}
