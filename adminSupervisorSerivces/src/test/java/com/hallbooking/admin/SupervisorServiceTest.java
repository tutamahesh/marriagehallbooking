//package com.hallbooking.admin;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.hallbooking.admin.dao.SupervisorDao;
//import com.hallbooking.admin.model.Supervisor;
//import com.hallbooking.admin.services.SupervisorService;
//
//@SpringBootTest
//class SupervisorServiceTest {
//
//@MockBean	
//SupervisorDao supervisorDao;
//
//@Autowired
//SupervisorService supervisorService;
//
//@Test
//void testAdd()
//{
//	Supervisor s1=new Supervisor();
//	s1.setSupervisorId("S01");
//	s1.setHallname("A");
//	s1.setLocation("AA");
//	s1.setNumberOfRooms(10);
//	s1.setElectricalEquipmentDetails("ElectricEq");
//	s1.setHouseKeepingDetails("HouseKeep");
//	s1.setHallPrice(100);
//	s1.setContactNo("1234567890");
//	supervisorService.addSupervisor(s1);
//	verify(supervisorDao,times(1)).save(s1);
//}
//
//@Test
// void testDelete()
//{
//	supervisorService.deleteSupervisor("S01");
//	verify(supervisorDao,times(1)).deleteById("S01");
//}
//@Test
//void testUpdate()
//{
//	Supervisor s1=new Supervisor();
//	s1.setSupervisorId("S01");
//	s1.setHallname("B");
//	s1.setLocation("AA");
//	s1.setNumberOfRooms(10);
//	s1.setElectricalEquipmentDetails("ElectricEq");
//	s1.setHouseKeepingDetails("HouseKeep");
//	s1.setHallPrice(100);
//	s1.setContactNo("1234567890");
//	//supervisorService.updateSupervisor("S01", s1);
//	verify(supervisorDao,times(1)).save(s1);
//	
//}
//
//@Test
//void testgetSupervisorById()
//{
//	Supervisor s1=new Supervisor();
//	s1.setSupervisorId("S01");
//	s1.setHallname("B");
//	s1.setLocation("AA");
//	s1.setNumberOfRooms(10);
//	s1.setElectricalEquipmentDetails("ElectricEq");
//	s1.setHouseKeepingDetails("HouseKeep");
//	s1.setHallPrice(100);
//	s1.setContactNo("1234567890");
//	
//	when(supervisorDao.getById("S01")).thenReturn(s1);
//	assertEquals(s1,supervisorService.findSupervisorById("S01"));
//	
//}
//
////@Test
////public void testgetSupervicorByCity()
////{
////	Supervisor s1=new Supervisor();
////	s1.setSupervisorId("S01");
////	s1.setHallname("B");
////	s1.setLocation("AA");
////	s1.setNumberOfRooms(10);
////	s1.setElectricalEquipmentDetails("ElectricEq");
////	s1.setHouseKeepingDetails("HouseKeep");
////	s1.setHallPrice(100);
////	s1.setContactNo("1234567890");
////	
////	Supervisor s2=new Supervisor();
////	s2.setSupervisorId("S02");
////	s2.setHallname("C");
////	s2.setLocation("CC");
////	s2.setNumberOfRooms(30);
////	s2.setElectricalEquipmentDetails("ElectricEqCC");
////	s2.setHouseKeepingDetails("HouseKeepCC");
////	s2.setHallPrice(1000);
////	s2.setContactNo("2234587890");
////
////List<Supervisor> sList=List.of(s1);
////when(supervisorDao.findSupervisorByLocation("CC")).thenReturn(sList);
////assertEquals(sList,supervisorService.findSupervisorByLocation("CC"));
////}
//
//}
