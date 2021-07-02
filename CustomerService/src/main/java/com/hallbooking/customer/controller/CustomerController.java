package com.hallbooking.customer.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hallbooking.customer.exception.CustomException;
import com.hallbooking.customer.exception.IDNotFoundException;
import com.hallbooking.customer.iclass.AdminVendor;
import com.hallbooking.customer.iclass.Bill;
import com.hallbooking.customer.iclass.ErrorInfo;
import com.hallbooking.customer.iclass.Offline;
import com.hallbooking.customer.iclass.Online;
import com.hallbooking.customer.iclass.SuccessInfo;
import com.hallbooking.customer.iclass.Supervisor;
import com.hallbooking.customer.model.Customer;
import com.hallbooking.customer.model.CustomerBookStatus;
import com.hallbooking.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="This Is The REST Controller For Customer")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	BookStatusController csb;
	Logger log=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService cserv;
	
	@Autowired 
	RestTemplate restTemp;
	
	
	
	@ApiOperation(value="This Resource Will be used to search halls of particular location")
	@GetMapping("/searchhalls/{location}")
	public List searchHalls(@PathVariable("location") String location){
		return restTemp.getForObject("http://admin-supervisor/adminsupervisor/gethalls/"+location, List.class); 
	}
	@ApiOperation(value="This Resource Will be used to search vendors in the particular city")
	@GetMapping("/searchvendors/{city}")
	public List searchVendors(@PathVariable("city") String city){
		return restTemp.getForObject("http://admin-vendor/adminvendor/vendorcity/"+city,List.class);
		
	}
	
	@ApiOperation(value="This Resource Will tell if the hall is available or not")
	@GetMapping("/checkhallbooking/{supervisorId}/{date}")
	public ResponseEntity<SuccessInfo> checkHall(@PathVariable("supervisorId") String supervisorId,@PathVariable("date") String date) throws ParseException{
		log.info("Checking Hall Status");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(date);
		Date current=new Date();
		if(date1.before(current)){
			SuccessInfo err=new SuccessInfo("Error","The Date Is Not Valid");
			return new ResponseEntity<SuccessInfo>(err,HttpStatus.CREATED);
		} else {
			String res=restTemp.getForObject("http://booking/booking/hallavailability/"+supervisorId+"/"+date, String.class);
			SuccessInfo inf=new SuccessInfo("Success",res);
			return new ResponseEntity<SuccessInfo>(inf,HttpStatus.CREATED);
		}
		
	}
	@ApiOperation(value="This Resource Will help us to book the hall")
	@GetMapping("/bookhall/{supervisorId}/{date}")
	public ResponseEntity<SuccessInfo> bookHall(@PathVariable("supervisorId") String supervisorId,@PathVariable("date") String date) throws ParseException{
		log.info("Booking the Hall");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = format.parse(date);
		Date current=new Date();
		if(date1.before(current)){
			SuccessInfo err=new SuccessInfo("Error","The Date Is Not Valid");
			return new ResponseEntity<SuccessInfo>(err,HttpStatus.CREATED);
		} else {
			String str=restTemp.getForObject("http://booking/booking/"+supervisorId+"/"+date, String.class);
			SuccessInfo inf=new SuccessInfo("Success",str);
			return new ResponseEntity<SuccessInfo>(inf,HttpStatus.CREATED);
		}
	}
	@ApiOperation(value="This Resource will choose the vendors of customers choice")
	@GetMapping("/choosevendors/{date}/{supervisorId}/{customerId}/{v1Id}/{v2Id}/{v3Id}/{v4Id}")
	public ResponseEntity<SuccessInfo> selectVendors(@PathVariable("date") String date,@PathVariable("customerId") String customerId,@PathVariable("supervisorId") String supervisorId,@PathVariable("v1Id") String vendor1Id,@PathVariable("v2Id") String vendor2Id,@PathVariable("v3Id") String vendor3Id,@PathVariable("v4Id") String vendor4Id){
		log.info("Selecting the vendors");
		AdminVendor v1=restTemp.getForObject("http://admin-vendor/adminvendor/"+vendor1Id, AdminVendor.class);
		AdminVendor v2=restTemp.getForObject("http://admin-vendor/adminvendor/"+vendor2Id, AdminVendor.class);
		AdminVendor v3=restTemp.getForObject("http://admin-vendor/adminvendor/"+vendor3Id, AdminVendor.class);
		AdminVendor v4=restTemp.getForObject("http://admin-vendor/adminvendor/"+vendor4Id, AdminVendor.class);
		Supervisor s1=restTemp.getForObject("http://admin-supervisor/adminsupervisor/"+supervisorId, Supervisor.class);
		CustomerBookStatus cb=new CustomerBookStatus(supervisorId,date,customerId,s1.getHallPrice(),vendor1Id,v1.getPrice(),vendor2Id,v2.getPrice(),vendor3Id,v3.getPrice(),vendor4Id,v4.getPrice());
		csb.addNewStatus(cb);
		SuccessInfo inf=new SuccessInfo("Success","The Vendors With Ids "+vendor1Id+" "+vendor2Id+" "+vendor3Id+" "+vendor4Id+" Are Selected And Sent For Billing");
		return new ResponseEntity<SuccessInfo>(inf,HttpStatus.CREATED);
	}
	@ApiOperation(value="This Resource Will get the bill")
	@GetMapping("/getbill/{customerId}")
	public ResponseEntity<Bill> getBill(@PathVariable("customerId") String customerId){
		log.info("Generate the bill for booked Hall");
		Bill b=restTemp.getForObject("http://supervisor-service/generatebill/"+customerId, Bill.class);
		return new ResponseEntity<>(b,HttpStatus.FOUND);
	}
	@ApiOperation(value="This Resource provide us the option to pay the bill online")
	@GetMapping("/paybill/online/{billno}")
	public ResponseEntity<Online> payOnline(@PathVariable("billno")int billNo){
		log.info("Paying bill online");
		Bill b=restTemp.getForObject("http://supervisor-service/billbyno/"+billNo, Bill.class);
		
		Online o=new Online(b.getCustomerId(),b.getBillNo(),b.getSupervisorId(),b.getDate(),"Online Payment",b.getTotalBill());
		return new ResponseEntity<>(o,HttpStatus.FOUND);
		
	}
	@ApiOperation(value="This Resource provide us the option to pay the bill offline")
	@GetMapping("/paybill/offline/{billno}")
	public ResponseEntity<Offline> payOffline(@PathVariable("billno")int billNo){
		log.info("Paying bill offline");
		Bill b=restTemp.getForObject("http://supervisor-service/billbyno/"+billNo, Bill.class);
		Offline of=new Offline(b.getCustomerId(),b.getBillNo(),b.getSupervisorId(),b.getDate(),"Offline Payment Cash",b.getTotalBill());
		return new ResponseEntity<>(of,HttpStatus.FOUND);
		
	}
	
	
	@ApiOperation(value="This resource will return all customers")
	@GetMapping("/getall")
	public List<Customer> getAllCustomers(){
		return cserv.getAllCustomers();
	}
	
	@ApiOperation(value="This resource will return a customer based on its ID")
	@GetMapping("/{id}")
	public Optional<Customer> getACustomers(@PathVariable("id") String id)  {
		if(!cserv.checkById(id)) {
			throw new IDNotFoundException("Id does not exist");
		}
		return cserv.readCustomer(id);	
	}
	
	@ApiOperation(value="This resource will update customer")
	@PutMapping("/update")
	public ResponseEntity<String> updCustomer(@RequestBody Customer c){
		cserv.updateCustomer(c,c.getCustomerId());
		return new ResponseEntity<>("Customer With "+c.getCustomerId()+" has been updated Successfully",HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value="This Resource Will Enter New Customer")
	@PostMapping("/addcustomer")
	public ResponseEntity<String> addNewCustomer(@Valid @RequestBody Customer c ,BindingResult res){
		if(res.hasErrors()) {
			throw new CustomException("Did not pass the criteriato be added ");
		}
		cserv.addCustomer(c);
		return new ResponseEntity<>("New Customer Added with Id "+c.getCustomerId(),HttpStatus.CREATED);
	}
	
	@ApiOperation(value="This Resource Will Delete a Customer")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id){
		if(cserv.checkById(id))
			cserv.deleteCustomer(id);
		else
			throw new IDNotFoundException("Id does not exist");
		return  new ResponseEntity<>("Customer with "+id+" is Deleted !!!",HttpStatus.OK);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
