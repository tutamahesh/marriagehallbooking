package com.hallbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hallbooking.booking.dao.BookingDao;
import com.hallbooking.booking.model.Booking;
import com.hallbooking.booking.service.BookingService;


@SpringBootTest
class BookingService1ApplicationTests {

	@MockBean
	private BookingDao bdao;
	
	@Autowired
	private BookingService bserv;
	
	@Test
	public void getList() {
		Booking b1=new Booking("H125","2021-04-15"); 
		Booking b2=new Booking("H126","2021-04-14"); 
		List<Booking> mylist=List.of(b1,b2);
		when(bdao.findAll()).thenReturn(mylist);
		assertEquals(mylist,bserv.getAll());
	} 
	@Test
	public void testAdd() {
		Booking b1=new Booking("H125","2021-04-15"); 
		
		bserv.addEntry(b1);
		verify(bdao,times(1)).save(b1);
	}
	
	@Test
	public void modifyTest() {
		Booking b1=new Booking("H125","2021-04-15"); 
		
		bserv.updateEntry(b1,1);
		verify(bdao,times(1)).save(b1);
	}
	
	@Test
	public void testRemove() {
		bserv.deleteEntry(1);
		verify(bdao,times(1)).deleteById(1);
	}


	

	@Test
	public void testExistBySupervisorId() {
		
		
		when(bdao.existsBySupervisorId("H125")).thenReturn(true);
		assertEquals(true,bserv.checkBySupervisorId("H125"));
	}
	
	
	
	
	
}
