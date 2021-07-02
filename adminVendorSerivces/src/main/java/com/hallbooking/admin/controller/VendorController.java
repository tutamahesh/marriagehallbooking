package com.hallbooking.admin.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hallbooking.admin.exception.IDNotFoundException;
import com.hallbooking.admin.inter.Vendor;
import com.hallbooking.admin.model.AdminVendor;
import com.hallbooking.admin.services.VendorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="This Controller Is For Supervisor")
@RestController
@RequestMapping("/adminvendor")
public class VendorController {	 
	Logger log =LoggerFactory.getLogger(VendorController.class);
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	VendorService vserv;	
	
	@ApiOperation(value="Insert Vendor Details",response=AdminVendor.class)
	@GetMapping("/add/{vendorId}")
	public ResponseEntity<String> addVendor(@PathVariable("vendorId") String vendorId )
	{		
		Vendor v=	restTemplate.getForObject("http://vendor-service/vendor/findidby/"+vendorId,Vendor.class);
		AdminVendor av=new AdminVendor(v.getVendorId(),v.getCity(),v.getTypeOfVendor(),v.getPrice());
		vserv.addVendor(av);
		return new ResponseEntity<String>("Vendor Added Succesful",HttpStatus.CREATED);		
	}
	@ApiOperation(value="Delete Vendor Details",response=AdminVendor.class)
	  @DeleteMapping("/{vendorId}")	
	  public ResponseEntity<String>deleteVendor(@PathVariable("vendorId") String vendorId)
	  {if(vserv.existsById(vendorId))
	  { vserv.deleteVendor(vendorId);}
	  else 
	  { throw new IDNotFoundException("Record Not Found For Vendor Id : "+vendorId);}
		log.info("Vendor Deleted From database Successfully ");
		return new ResponseEntity<String>("Vendor Deleted Successfully",HttpStatus.OK);		  
	  }  
	@ApiOperation(value="Update Vendor Details",response=AdminVendor.class)
	  @PutMapping("/{vendorId}")
	  public ResponseEntity<String>updateInTable(@RequestBody AdminVendor vendor,@PathVariable("vendorId") String vendorId)
	  {
		  vserv.updateVendor(vendorId, vendor);
		  log.info("Vendor Updated Into database Successfully ");
		  return new ResponseEntity<String>("Vendor Updated Successfully",HttpStatus.OK);
	  }	 
	@ApiOperation(value="Find Vendor Details By Id",response=AdminVendor.class)
	  @GetMapping("/{vendorId}")
	  public Optional<AdminVendor> findVendorById(@PathVariable("vendorId")String vendorId)
	  {
		
		log.info("Vendor Returned By Id");
		  return vserv.findVendorById(vendorId);
	  }	  
	@ApiOperation(value="Find Vendor Details By city",response=AdminVendor.class)
	  @GetMapping("/vendorcity/{city}")
	  public List<AdminVendor> findVendorByCity(@PathVariable("city") String city)
	  {
		log.info("Vendor Returned By City");
		  return vserv.findVendorByCity(city);
	  }
}