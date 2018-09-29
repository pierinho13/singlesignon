package com.sso.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class ClienteApplication {
	
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
	  
	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
}
