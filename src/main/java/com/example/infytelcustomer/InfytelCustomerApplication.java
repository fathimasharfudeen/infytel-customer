package com.example.infytelcustomer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfytelCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfytelCustomerApplication.class, args);
	}

	
	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper;
		
	}
}
