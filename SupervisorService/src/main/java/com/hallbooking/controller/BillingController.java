package com.hallbooking.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hallbooking.model.Bill;
import com.hallbooking.model.CustomerBookStatus;
import com.hallbooking.services.BillingService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BillingController {
	@Autowired
	BillingService billingService;
	@Autowired
	RestTemplate rtemp;
	
	Logger logger=LoggerFactory.getLogger(BillingController.class);
	
	@ApiOperation(value="Add the total bill", response=CustomerBookStatus.class)
	@GetMapping("/bill/{supervisorId}/{date}")
	public ResponseEntity<String>addBillingAmount(@PathVariable("supervisorId") String supervisorId,@PathVariable String date) {
		logger.info("Adding Billing Amount to database!!!");
		CustomerBookStatus cbs=rtemp.getForObject("http://customer/bookstatus/bstatus/"+supervisorId, CustomerBookStatus.class);
		billingService.addBillingAmount(cbs);
		return new ResponseEntity<String>("Bill Amount are Added Successfully!!!!!!",HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Fetch the total bill", response=Bill.class)
	@GetMapping("/generatebill/{customerId}")
	public Optional<Bill> getBillingAmount(@PathVariable("customerId") String customerId) {
		logger.info("Genrating Bill for Customer!!!");
		return billingService.getBill(customerId);
	}
	
	@ApiOperation(value="Fetch By billno")
	@GetMapping("/billbyno/{billNo}")
	public Optional<Bill> billByBillNo(@PathVariable("billNo") int billno) {
		return billingService.getBillByBillNo(billno);
	}
	
	
}
