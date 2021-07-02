package com.hallbooking.admin.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hallbooking.admin.model.Hall;
import com.hallbooking.admin.model.Supervisor;
import com.hallbooking.admin.services.SupervisorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="This Controller Is For Supervisor")
@RestController
@RequestMapping("/adminsupervisor")
public class AdminSupervisorController {
	@Autowired
	RestTemplate rtemp;
	
	Logger log =LoggerFactory.getLogger(AdminSupervisorController.class);
	
	@Autowired
	SupervisorService sserv;
	
	@ApiOperation(value="Insert Supervisor Details",response=Supervisor.class)
	@GetMapping("/addsupervisor/{supervisorId}")
	public ResponseEntity<String>addSupervisor(@PathVariable("supervisorId") String supervisorId)
	{	
			Hall h=rtemp.getForObject("http://supervisor-service/supervisors/gethall/"+supervisorId, Hall.class);
			if(h==null)
			{
				throw new NullPointerException();
			}
			Supervisor s=new Supervisor(h.getSupervisorId(),h.getHallname(),h.getLocation(),h.getHallCapacity(),h.getNumberOfRooms(),h.getElectricalEquiptmentDetails(),h.getHouseKeepingDetails(),h.getHallPrice(),h.getContactNo());
			sserv.addSupervisor(s);
			log.info("Supervisor Added To database Successfully ");
		return new ResponseEntity<>("Supervisor Added Succesful",HttpStatus.CREATED);		
	}
	@ApiOperation(value="Delete Supervisor Details",response=Supervisor.class)
	  @DeleteMapping("/{supervisorId}")	
	  public ResponseEntity<String>deleteSupervisor(@PathVariable("supervisorId") String supervicorId)
	  {
		  sserv.deleteSupervisor(supervicorId);
		  log.info("Supervisor Deleted From database Successfully ");
		return new ResponseEntity<String>("Supervisor Deleted Successfully",HttpStatus.OK);		  
	  }  
	@ApiOperation(value="Update Supervisor Details",response=Supervisor.class)
	  @PutMapping("/{supervisorId}")
	  public ResponseEntity<String>updateInTable(@PathVariable("supervisorId") String supervisorId)
	  {
		  Hall h=rtemp.getForObject("http://supervisor-service/supervisors/gethall/"+supervisorId, Hall.class);
		  Supervisor supervisor=new Supervisor(h.getSupervisorId(),h.getHallname(),h.getLocation(),h.getHallCapacity(),h.getNumberOfRooms(),h.getElectricalEquiptmentDetails(),h.getHouseKeepingDetails(),h.getHallPrice(),h.getContactNo());
		  sserv.updateSupervisor(supervisorId, supervisor);
		  log.info("supervisor Updated Into database Successfully ");
		  return new ResponseEntity<String>("Supervisor Updated Successfully",HttpStatus.OK);
	  }	
	@ApiOperation(value="Find Supervisor Details By Id",response=Supervisor.class)
	  @GetMapping("/{supervisorId}")
	  public Optional<Supervisor> getSupervisorById(@PathVariable("supervisorId")String supervisorId)
	  {
		log.info("Supervisor Returned By Id");
		  return sserv.findSupervisorById(supervisorId);
	  }	
	@ApiOperation(value="Find Supervisors Details By Location",response=Supervisor.class)
	  @GetMapping("/gethalls/{location}")
	  public List<Supervisor> findSupervisorByLocation(@PathVariable("location") String location)
	  {
		log.info("Supervisors Returned By Location");
		  return sserv.findSupervisorByLocation(location);
	  }
  	
	@GetMapping("/getall")
	public List<Supervisor> getAllHalls(){
		return sserv.findSupervisor();
	}
}
