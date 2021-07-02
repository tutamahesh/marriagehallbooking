package com.hallbooking.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hallbooking.admin.dao.VendorDao;
import com.hallbooking.admin.model.AdminVendor;
import com.hallbooking.admin.services.VendorService;

@SpringBootTest
class AdminVendorSerivcesApplicationTests {

	@MockBean	
	VendorDao vendorDao;

	@Autowired
	VendorService vendorService;

	@Test
	 void testAdd()
	{
		AdminVendor v1=new AdminVendor();
		v1.setVendorId("V01");
		v1.setCity("AA");
		v1.setTypeOfVendor("Good");
		v1.setPrice(1000);
		vendorService.addVendor(v1);
		verify(vendorDao,times(1)).save(v1);
	}

	@Test
	void testDelete()
	{
		vendorService.deleteVendor("V01");
		verify(vendorDao,times(1)).deleteById("V01");
	}
	@Test
 void testUpdate()
	{
		AdminVendor v1=new AdminVendor();
		v1.setVendorId("V01");
		v1.setCity("AA");
		v1.setTypeOfVendor("Better");
		v1.setPrice(1000);
		vendorService.updateVendor("V01", v1);
		verify(vendorDao,times(1)).save(v1);
		
	}
/**
	@Test
	 void testgetVendorById()
	{
		Vendor v1=new Vendor();
		v1.setVendorId("V01");
		v1.setCity("AA");
		v1.setTypeOfVendor("Better");
		v1.setPrice(1000);
		
		when(vendorDao.getById("V01")).thenReturn(v1);
		assertEquals(v1,vendorService.findVendorById("V01"));
		
	}
**/
	@Test
	 void testgetVendorByCity()
	{
		AdminVendor v1=new AdminVendor();
		v1.setVendorId("V01");
		v1.setCity("AA");
		v1.setTypeOfVendor("Better");
		v1.setPrice(1000);
		
		AdminVendor v2=new AdminVendor();
		v2.setVendorId("V02");
		v2.setCity("BB");
		v2.setTypeOfVendor("Bad");
		v2.setPrice(2000);

	List<AdminVendor> vList=List.of(v1,v2);
	when(vendorDao.findVendorByCity("BB")).thenReturn(vList);
	assertEquals(vList,vendorService.findVendorByCity("BB"));
	
	
}

}
