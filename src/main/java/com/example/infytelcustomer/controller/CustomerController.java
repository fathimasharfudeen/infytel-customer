package com.example.infytelcustomer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.infytelcustomer.dto.CustomerDTO;
import com.example.infytelcustomer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	
	@Autowired
	private CustomerService customerservice;
	
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getCustomerall(){
		
		
		List<CustomerDTO> customerlist=new ArrayList<>();
		
		customerlist=customerservice.getallCustomers();
		
		return ResponseEntity.ok().body(customerlist);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id")int id){
		
		
		return ResponseEntity.ok().body(customerservice.getCustomerById(id));
		
		
		
	}

	
	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerdto){
		
		System.out.println(" i am in th epost mapping");
		
		System.out.println(customerdto);
		return ResponseEntity.ok().body(customerservice.createCustomer(customerdto));
		
		
		
	}
}
