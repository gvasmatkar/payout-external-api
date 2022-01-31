package com.paymaya.payout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.paymaya.payout.model.UserJsonResponse;

@SpringBootApplication
public class PayoutExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayoutExternalApiApplication.class, args);
    }
    
    @Bean
	public UserJsonResponse getUserJsonResponse() {
	    return new UserJsonResponse();
	}

}
