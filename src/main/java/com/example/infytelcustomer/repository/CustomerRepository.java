package com.example.infytelcustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infytelcustomer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
