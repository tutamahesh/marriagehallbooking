package com.hallbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.hallbooking.vendor.dao.VendorDao;
import com.hallbooking.vendor.model.Vendor;
import com.hallbooking.vendor.service.VendorService;

import java.util.List;
@SpringBootTest
class VendorServiceApplicationTests {

	
	@MockBean
	VendorDao vdao;
	
	@Autowired
	VendorService vserv;
	
	@Test
	public void testList() {
		
		Vendor v1=new Vendor("M123","kphp","cattering",3000);
		
		Vendor v2=new Vendor("N145","mvp","Dj",8000);
		List<Vendor> mylist=List.of(v1,v2);
		
		when(vdao.findVendorByCity("mvp")).thenReturn(List.of(v2));
		
		assertEquals(List.of(v2),vserv.vendorlist("mvp"));
	}
	
	@Test
	public void testAdd() {
		Vendor v1=new Vendor("N67","gvp","decoration",6900);
		
		String result = vserv.vendorRegistration(v1);
		assertEquals(result, "sucessfullyRegistred");
		verify(vdao,times(1)).save(v1);
	}
	
	@Test
	public void testDelete() {
		
		String result = vserv.delete("8123");
		assertEquals(result, "sucessfullyDeleted");
		verify(vdao,times(1)).deleteById("8123");
	}
	
	@Test
	public void modifyTest() {
		Vendor v1=new Vendor("K134","gajw","sound",6090);
		
		String result = vserv.update(v1);
		verify(vdao,times(1)).save(v1);
		assertEquals(result, "sucessfullyUpdated");
	}

	

}
