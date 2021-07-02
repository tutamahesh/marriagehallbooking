package com.hallbooking.booking.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hallbooking.booking.exceptions.IDNotFoundException;
import com.hallbooking.booking.model.Booking;
import com.hallbooking.booking.model.Hall;
import com.hallbooking.booking.model.Supervisor;
import com.hallbooking.booking.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="This Is The REST Controller For Booking")
@RestController
@RequestMapping("/booking")
public class BookingController {
	Logger log=LoggerFactory.getLogger(BookingController.class);
	@Autowired
	BookingService bserv;
	@Autowired
	RestTemplate rtemp;
	
	@ApiOperation(value="This Resource Will be used to book the slot")
	@GetMapping("/{supervisorId}/{date}")
	public String addNewBooking(@PathVariable("supervisorId") String supervisorId,@PathVariable("date") String date){
		log.info("Booking the hall for this slot");
		ResponseEntity<Supervisor[]> response =rtemp.getForEntity("http://admin-supervisor/adminsupervisor/getall",Supervisor[].class);
		Supervisor[] h = response.getBody();
		String str=null;
		for(Supervisor temp:h) {
		if(temp.getSupervisorId().equals(supervisorId))
		{
			if(!(bserv.checkByBookingDate(date) &&bserv.checkBySupervisorId(supervisorId))) {
			Booking b1=new Booking(supervisorId,date);
			bserv.addEntry(b1);
			return "Hall has been Booked Successfully for Supervisor Id "+supervisorId+" On the date "+date+" with BookingNo: "+b1.getBookingNo();
			}
			else
				return "Hall has already been Booked on :"+date+" by someone else!!!! ";
		}
		else
			{
			str="Hall for this Id is not present in database";
			}
		}
		return str;
	}
	
	@ApiOperation(value="This Resource Will see all the bookings done")
	@GetMapping("/list")
	public List<Booking> seeAllBookings(){
		log.info("Returning all the Bookings");
		return bserv.getAll();
		}
	
	@ApiOperation(value="This Resource Will check if the booking slot is available or not")
	@GetMapping("/hallavailability/{supervisorId}/{date}")
	public String checkBooking(@PathVariable("supervisorId") String supervisorId,@PathVariable("date") String date){
		log.info("Checking if the hall is available or not");
		if(bserv.checkByBookingDate(date) &&bserv.checkBySupervisorId(supervisorId))
			return "Hall with ID "+supervisorId+" is Already Booked for date "+date;
		else {
			
			return "Hall with ID "+supervisorId+" is Available for Booking on date "+date;
		}
	}
	
	@ApiOperation(value="This resource will check of the slot with id")
	@GetMapping("/checkid/{supervisorId}")
	public Optional<Booking> getBookingById(@PathVariable("supervisorId") String supervisorId) {
		log.info("Get Booking by Id");
		if(!bserv.checkBySupervisorId(supervisorId))
			throw new IDNotFoundException("Booking Does Not Exist");
		return bserv.findEntry(supervisorId);
	}
	
	@ApiOperation(value="This resource will delete the Booking")
	@GetMapping("/delete/{bookingNo}")
	public String deleteById(@PathVariable("bookingNo") int bookingNo) {
		log.info("Delete the booking");
		if(bserv.checkById(bookingNo))
			bserv.deleteEntry(bookingNo);
		else
			throw new IDNotFoundException("Booking Does Not Exist");
		return "Id Deleted Successfully";
	} 
	
	@ApiOperation(value="This resource will give available halls for that date")
	@GetMapping("/hallavailblitylist/{date}")
	public List<Supervisor> availableHallByDate(@PathVariable("date") String date) 
	{
		
		List<String> booked = null;
		
		List<Booking> l=bserv.checkByBookingDateReturnsList(date);
		for(Booking b : l)
		{
			if(b.getBookingDate().equals(date))
			{
				booked.add(b.getSupervisorId());
			}
		}
		ResponseEntity<Supervisor[]> response =rtemp.getForEntity("http://admin-supervisor/adminsupervisor/getall",Supervisor[].class);
		List<Supervisor> list = Arrays.asList(response.getBody());
		for(String temp1 : booked)
		{
			for(Supervisor temp2 : list)
			{
				if(temp1.equals(temp2.getSupervisorId()))    
				{
					list.remove(temp2);
				}
			}
		}
		
		return list;
		
	}
}























