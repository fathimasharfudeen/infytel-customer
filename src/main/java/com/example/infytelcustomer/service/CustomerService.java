package com.example.infytelcustomer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.infytelcustomer.dto.CustomerDTO;
import com.example.infytelcustomer.entity.Customer;
import com.example.infytelcustomer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository customerrepository;
	
	private ModelMapper modelMapper; 
	
	public List<CustomerDTO> getallCustomers(){
		
		List<CustomerDTO> customerdto=new ArrayList<>();
		List<Customer> cl=customerrepository.findAll();
		
		for(Customer c:cl) {
			
			
			customerdto.add(modelMapper.map(c,CustomerDTO.class));
			
		}
		
		
		return customerdto;
		
		
	}
	
	public CustomerDTO getCustomerById(int id) {
		
		Customer cus=null;
		
		Optional<Customer> c= customerrepository.findById(id);
		if(c.isPresent()) {
			
			cus=c.get();
		}
		else {
			
			cus.setId(9);
			cus.setName("hahaha");
			cus.setPlan("verizon");
			cus.setEmail("haha@gmail.com");
		}
		
		return modelMapper.map(c,CustomerDTO.class);
		}
	
	

}
