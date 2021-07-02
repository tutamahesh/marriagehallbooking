package com.hallbooking.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hallbooking.dao.SupervisorRepository;
import com.hallbooking.model.Hall;
import com.hallbooking.services.SupervisorService;

@SpringBootTest
class SupervisorServiceTests {
	
	@MockBean
	SupervisorRepository repo;
	
	@Autowired
	SupervisorService service;
	

	
	@Test
	void testAdd(){
		Hall h=new Hall("s01","Central hall","Anand nagar,Belgaum",1500,2,"electrical equiptment available","available",50000.0,"1234567891");

		service.addHallDetails(h);
		verify(repo,times(1)).save(h);
	}
	
	
	@Test
	void modifyTest() {
		Hall h=new Hall("s01","Central hall","Anand nagar,Belgaum",1500,2,"electrical equiptment available","available",50000.0,"1234567891");

		
		service.modifyHallDetailsById(h,"s01");
		verify(repo,times(1)).save(h);
	}
	
	@Test
	void testRemove() {
		
		service.deleteHallDetailsById("s01");
		verify(repo,times(1)).deleteById("s01");
	}

	@Test
	void testFindById() {
		Optional<Hall> h=Optional.of(new Hall("s01","Central hall","Anand nagar,Belgaum",1500,2,"electrical equiptment available","available",50000.0,"1234567891"));
		
		when(service.getHallDetailsById("s01")).thenReturn(h);
		assertEquals(h,service.getHallDetailsById("s01"));
		
	}

}
