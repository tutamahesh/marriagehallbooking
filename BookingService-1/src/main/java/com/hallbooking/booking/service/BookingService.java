package com.hallbooking.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hallbooking.booking.dao.BookingDao;
import com.hallbooking.booking.model.Booking;
@Service("bserv")
public class BookingService  {
	@Autowired
	BookingDao bdao;
	
	public boolean checkById(int bookingNo) {
		return bdao.existsById(bookingNo);
	}
	
	public boolean checkBySupervisorId(String supervisorId) {
		return bdao.existsBySupervisorId(supervisorId);
	}
	
	public boolean checkByBookingDate(String bookingDate) {
		return bdao.existsByBookingDate(bookingDate);
	}
	
	public List<Booking> getAll(){
		return bdao.findAll();
	}
	
	public void addEntry(Booking b) {
		bdao.save(b);
	}
	
	public String updateEntry(Booking b,int bookingNo) {
		bdao.save(b);
		return "Entry updated with BookingNo: "+bookingNo;
	}
	
	public void deleteEntry(int bookingNo) {
			bdao.deleteById(bookingNo);
	}
	
	public Optional<Booking> findEntry(String supervisorId) {
		return Optional.of(bdao.findBySupervisorId(supervisorId));
	}
	public List<Booking> checkByBookingDateReturnsList(String bookingDate) {
		return bdao.findByBookingDate(bookingDate);
	}
	 
	
}
