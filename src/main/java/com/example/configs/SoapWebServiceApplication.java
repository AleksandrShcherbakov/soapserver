package com.example.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.*"})
public class SoapWebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoapWebServiceApplication.class, args);
	}

}
