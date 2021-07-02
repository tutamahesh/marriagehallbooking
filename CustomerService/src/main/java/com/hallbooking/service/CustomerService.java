package com.hallbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hallbooking.customer.dao.CustomerDao;

import com.hallbooking.customer.model.Customer;

@Service("cserv")
public class CustomerService {
	@Autowired
	CustomerDao cdao;
	
	public boolean checkById(String id) {
		return cdao.existsById(id);
	}
	
	public List<Customer> getAllCustomers(){
		return cdao.findAll();
	}
	
	public void addCustomer(Customer c) {
		cdao.save(c);
	}
	
	public void deleteCustomer(String id) {
			cdao.deleteById(id);
	}
	
	public String updateCustomer(Customer c,String id) {
		cdao.save(c);
		return "Customer Updated with id- "+id;
	}
	
	public Optional<Customer> readCustomer(String id) {
		
		return cdao.findById(id);	
			
	}
}
