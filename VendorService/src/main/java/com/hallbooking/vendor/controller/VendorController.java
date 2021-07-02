 package com.hallbooking.vendor.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hallbooking.vendor.exception.VendorException;
import com.hallbooking.vendor.exception.VendorNotFoundException;
import com.hallbooking.vendor.exception.VendorTypeNotFoundException;
import com.hallbooking.vendor.model.Vendor;
import com.hallbooking.vendor.service.VendorService;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "/v1/vendor", tags = "Vendor Controller")
@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	Logger logger =  LoggerFactory.getLogger(VendorController.class);
	
	@ApiOperation(value = "add Vendors", response = Vendor.class)
	@PostMapping("/addvendor")
	public String addNewVendor(@RequestBody Vendor v){
		logger.info("[addNewVendor] info logger");
		
		vendorService.vendorRegistration(v);
		return "added !!!";
	}
	
	@ApiOperation(value = "Update Vendors", response = Vendor.class)
	@PutMapping("/updatevendor/{id}")
	public String updateVendor(@PathVariable("id") String id, @RequestBody Vendor var){
		logger.info("[updatevendor] info logger");
		vendorService.update(var);
		return  "updated !!!";
		
	}
	
	@ApiOperation(value = "Fetch all Vendors", response = Vendor.class)
	@GetMapping("/vendorlist/{city}")
	public List<Vendor> findVendorByCity(@PathVariable("city")  String city) throws VendorException{
		logger.info("[vendorlist] info logger");
		List<Vendor> list = vendorService.vendorlist(city);
		if(list==null)throw new VendorException("NO SUCH TO FOUND");
		return list;
	}
	
	@ApiOperation(value = "Delete Vendors", response = Vendor.class)
	@DeleteMapping("/deleteVendor/{id}")
	public String deleteVendor(@PathVariable ("id") String id) {
		logger.info("[deleteVendor] info logger");
		try {
		vendorService.findById(id);
		}catch(NoSuchElementException e) {
			throw new VendorNotFoundException("not founnd");
		}
		vendorService.delete(id);
		return "deleted!!!";
	}
	
	@ApiOperation(value = "findById Vendors", response = Vendor.class)
	@GetMapping("/findidby/{id}")
	public Vendor findById(@PathVariable ("id") String id) {
		logger.info("[deleteVendor] info logger");
		try {
      vendorService.findById(id);
	}catch (DataException e) {
	throw new VendorTypeNotFoundException("Id not found");
	}
		return vendorService.findById(id);
	
	}
	
	
	

}
