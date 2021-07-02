package com.hallbooking.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hallbooking.customer.model.CustomerBookStatus;
import com.hallbooking.service.CustomerBookingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/bookstatus")
public class BookStatusController {

	@Autowired
	CustomerBookingService cbserv;

	@ApiOperation(value="This Resource will return the object of customerBook")
	@GetMapping("/bstatus/{supervisorId}")
	public Optional<CustomerBookStatus> getStatus(@PathVariable("supervisorId") String supervisorId){
		return cbserv.findById(supervisorId);
		
	}
	
	@ApiOperation(value="This Resource Will Enter New booking entity")
	@PostMapping("/addcustomer")
	public CustomerBookStatus addNewStatus(@RequestBody CustomerBookStatus cb){
		cbserv.addBookStatus(cb);
		return cb;
	}
}
