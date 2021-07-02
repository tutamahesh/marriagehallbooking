package com.hallbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hallbooking.customer.dao.CustomerBookingDao;
import com.hallbooking.customer.model.CustomerBookStatus;

@Service("cbserv")
public class CustomerBookingService {
	
	@Autowired
	CustomerBookingDao cbdao;
	
	public List<CustomerBookStatus> allBookStatus(){
		return cbdao.findAll();
	}
	
	public Optional<CustomerBookStatus> findById(String supervisorId) {
		return cbdao.findById(supervisorId);
	}
	
	public void updateBookStatus(CustomerBookStatus cb) {
		cbdao.save(cb);
	}
	public void deleteBookStatus(String supervisorId) {
		cbdao.deleteById(supervisorId);
	} 
	public void addBookStatus(CustomerBookStatus cb) {
		cbdao.save(cb);
	}

}
