package com.hallbooking.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hallbooking.booking.model.Booking;

@Repository("bdao")
public interface BookingDao extends JpaRepository<Booking,Integer>{
	boolean existsBySupervisorId(String supervisorId);
	boolean existsByBookingDate(String bookingDate);
	Booking findBySupervisorId(String supervisorId);
	List<Booking> findByBookingDate(String bookingDate);
	
}
