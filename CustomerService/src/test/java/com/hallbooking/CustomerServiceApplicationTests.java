package com.hallbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hallbooking.customer.dao.CustomerDao;
import com.hallbooking.customer.model.Customer;
import com.hallbooking.service.CustomerService;

@SpringBootTest
class CustomerServiceApplicationTests {
	@MockBean
	CustomerDao cdao;
	
	@Autowired
	CustomerService cserv;

	@Test
	void testList() {
		Customer c1=new Customer("123","Pratik Durge","9365478912");
		Customer c2=new Customer("1234","Mahesh Tuta","9158763248");
		List<Customer> mylist=List.of(c1,c2);
		when(cdao.findAll()).thenReturn(mylist);
		
		assertEquals(mylist,cserv.getAllCustomers());
	}
	
	@Test
	 void testAdd() {
		Customer c1=new Customer("123","Pratik Durge","9365478912");
		
		cserv.addCustomer(c1);
		verify(cdao,times(1)).save(c1);
	}
	
	@Test
	 void modifyTest() {
		Customer c1=new Customer("123","Pratik Durge","9365478912");
		
		cserv.updateCustomer(c1,"123");
		verify(cdao,times(1)).save(c1);
	}
	
	@Test
	 void testRemove() {
		cserv.deleteCustomer("123");
		verify(cdao,times(1)).deleteById("123");
	}

	
}
