package com.example.infytelcustomer.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDTO {
	
	
	private int id;
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", email=" + email + ", plan=" + plan + ", name=" + name + "]";
	}
	private String email;
	private String plan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	

}
